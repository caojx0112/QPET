package com.qf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qf.bean.*;
import com.qf.dao.*;
import com.qf.service.OrdersService;
import com.qf.util.DateFormat;
import com.qf.util.StatusUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ** 程序猿
 * 一入代码深似海，
 * 小试牛刀异常来。
 * 奈何BUG直挠耳，
 * 仰天大笑出门来。
 */
@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersMapper ordersMapper;
    @Resource
    private ShoppesMapper shoppesMapper;
    @Resource
    private OrderdetailMapper orderdetailMapper;
    @Resource
    private UsersMapper usersMapper;
    @Resource
    private UsersCouponsMapper usersCouponsMapper;
    @Resource
    private EvaluatesMapper evaluatesMapper;
    @Resource
    private SpecificationMapper specificationMapper;

    /*新增订单
    * */
    @Override
    @Transactional
    public Orders insertorders(Orders orders,String shops) {
        //新增订单表
        orders.setOrderstatus(StatusUtils.ORDERS_OFFPAY);
        orders.setPaystatus(StatusUtils.PAY_OFF);
        Date date=new Date();
        String format = DateFormat.format(date);
        orders.setOrderid(format);
        orders.setCreatetime(date);
        //计算过期时间
        try {
            Long time = System.currentTimeMillis();
            time +=1440*1000*60;//在当前系统时间的基础上往后加24小时
            String format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
            Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(format1);
            orders.setExpirationtime(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ordersMapper.insertSelective(orders);
        //任务调度--过期时间到期取消订单--还原商品库存

        //修改商品表信息
        List<Orderdetail> orderdetails = JSONObject.parseArray(shops, Orderdetail.class);
        for (Orderdetail orderdetail : orderdetails) {
            //查询商品详情
            Shoppes shoppes = shoppesMapper.selectByPrimaryKey(orderdetail.getShopid());
            //修改商品表库存
            int count=shoppes.getShopnum()-orderdetail.getShopnum();
            shoppes.setShopnum(count);
            //修改状态---不为下架
            if (shoppes.getShopstatus()!=StatusUtils.SHOP_SOLDOUT) {
                if (count == 0) {
                    shoppes.setShopstatus(StatusUtils.SHOP_SHOUKONG);
                }
            }
            shoppesMapper.updateByPrimaryKeySelective(shoppes);
            //修改商品规格表库存
            Specification specification = specificationMapper.selectByPrimaryKey(orderdetail.getSpecification());
            if (specification!=null){
                specification.setShopnum(specification.getShopnum()-orderdetail.getShopnum());
                //修改状态
                if (specification.getSpestatus()!=StatusUtils.SHOP_SOLDOUT){
                    if (specification.getShopnum()-orderdetail.getShopnum()==0){
                        specification.setSpestatus(StatusUtils.SHOP_SHOUKONG);
                    }
                }
                specificationMapper.updateByPrimaryKeySelective(specification);
            }
        }
        //修改用户信息 --E币  优惠卷
        if (orders.getEmoney()!=null) {
            Users users=usersMapper.selectByPrimaryKey(orders.getUserid());
            users.setEmoney(users.getEmoney()-orders.getEmoney());
            usersMapper.updateByPrimaryKeySelective(users);
        }
        if (orders.getCouponsid()!=null) { //使用了优惠卷
            Map map=new HashMap();
            map.put("userid",orders.getUserid());
            map.put("couponsid",orders.getCouponsid());
            UsersCoupons usersCoupons = usersCouponsMapper.selectcouponsnum(map);
            usersCoupons.setCouponstatus(StatusUtils.COUPONS_OFFUSE); //改为已使用  2
            usersCouponsMapper.updateByPrimaryKeySelective(usersCoupons);

        }
        //新增订单详情表
        for (Orderdetail orderdetail : orderdetails) {
            orderdetail.setOrderid(format);
            orderdetailMapper.insertSelective(orderdetail);
        }

        Orders orders1 = ordersMapper.selectByPrimaryKey(format);
        return orders1;
    }

    /*支付
    * */
    @Override
    @Transactional
    public boolean paystaus(Orders orders) {
        if (orders.getPaystatus()==2){//支付成功
            orders.setPaystatus(StatusUtils.PAY_YES);
            orders.setOrderstatus(StatusUtils.ORDERS_OFFSHIPMENTS);
            orders.setExpirationtime(null);  //取消过期时间
            ordersMapper.updatepaystatus(orders);
            //修改用户E币  +商品返利E币
            int count=0;
            orders=ordersMapper.selectByPrimaryKey(orders.getOrderid());
            Users users = usersMapper.selectByPrimaryKey(orders.getUserid());
            List<Orderdetail> orderdetails = orderdetailMapper.findbyOrderid(orders.getOrderid());
            for (Orderdetail orderdetail : orderdetails) {
                Shoppes shoppes = shoppesMapper.selectByPrimaryKey(orderdetail.getShopid());
                count=count+shoppes.getEmoney();
                //修改销量
                shoppes.setShopsales(shoppes.getShopsales()+orderdetail.getShopnum());
                shoppesMapper.updateByPrimaryKeySelective(shoppes);
            }
            users.setEmoney(users.getEmoney()+count);
            usersMapper.updateByPrimaryKeySelective(users);
            return true;
        }
        return false;
    }

    /*取消订单
    * */
    @Override
    @Transactional
    public boolean cancel(String orderid, Integer userid) {
        boolean falg=false;
        Orders orders = ordersMapper.selectByPrimaryKey(orderid);
        //修改订单状态为已取消  --5
        orders.setOrderstatus(StatusUtils.ORDERS_CANCEL);
        ordersMapper.updateByPrimaryKeySelective(orders);
        //  --修改E币
        Users users = usersMapper.selectByPrimaryKey(orders.getUserid());
        int count=0;
        if (orders.getEmoney()>0){
            //付款使用的E币  +回去
            count=users.getEmoney() + orders.getEmoney();
        }
        //查询购买的商品
        List<Orderdetail> orderdetails = orderdetailMapper.findbyOrderid(orderid);
        for (Orderdetail orderdetail : orderdetails) {
            Shoppes shoppes = shoppesMapper.selectByPrimaryKey(orderdetail.getShopid());
            //修改商品表数量
            shoppes.setShopnum(shoppes.getShopnum()+orderdetail.getShopnum());
            //修改销量
            shoppes.setShopsales(shoppes.getShopsales()-orderdetail.getShopnum());
            //修改商品状态
            if (shoppes.getShopstatus()!=StatusUtils.SHOP_SOLDOUT){ //状态不为下架 改为在售
                shoppes.setShopstatus(StatusUtils.SHOP_SELL);
            }
            shoppesMapper.updateByPrimaryKeySelective(shoppes);
            //修改规格表库存
            Specification specification = specificationMapper.selectByPrimaryKey(orderdetail.getSpecification());
            if (specification!=null) {
                specification.setShopnum(specification.getShopnum() + orderdetail.getShopnum());
                //修改状态
                if (specification.getSpestatus() != StatusUtils.SHOP_SOLDOUT) {
                    specification.setSpestatus(StatusUtils.SHOP_SELL);
                }
                specificationMapper.updateByPrimaryKeySelective(specification);
            }
            //E币
            if (orders.getPaystatus()==StatusUtils.PAY_YES) {  //已付款  扣除返利的E币
                count=count-shoppes.getEmoney();
            }
        }
        users.setEmoney(count);
        usersMapper.updateByPrimaryKeySelective(users);
        falg=true;
        return falg;
    }
    /*收货
    * */
    @Override
    @Transactional
    public boolean shouhuo(String orderid, Integer userid) {
        boolean falg=false;
        Orders orders = ordersMapper.selectByPrimaryKey(orderid);
        orders.setOrderstatus(StatusUtils.ORDERS_OFFEVALUATE);
        ordersMapper.updateByPrimaryKeySelective(orders);
        falg=true;
        return falg;
    }
    /*好评
    * */
    @Override
    @Transactional
    public boolean evaluate(Evaluates evaluates) {
        evaluates.setCreatetime(new Date());
        int i = evaluatesMapper.insertSelective(evaluates);
        if (i>0){
            return true;
        }

        return false;
    }

    /*查看订单列表
    * */
    @Override
    public List<OrdersList> findall(int userid) {
        List<Orders> orders = ordersMapper.findbyuserid(userid);
        List<OrdersList> list=new ArrayList<>();
        for (Orders order : orders) {
            List<Shoppes> shopList=new ArrayList<>(); //存放每个订单商品信息
//            使用订单返回类封装返回数据
            OrdersList ordersList=new OrdersList();
            ordersList.setOrderid(order.getOrderid());
            ordersList.setOrderamount(order.getOrderamount());
            ordersList.setOrderstatus(order.getOrderstatus());
            //订单详情对应的商品id
            List<Orderdetail> shopids = orderdetailMapper.findshopidbyorderid(order.getOrderid());
            ordersList.setOrdercount(shopids.size()); //该条订单商品数量
            //    根据id查询商品信息
            for (Orderdetail orderdetail : shopids) {
                Shoppes shoppes = shoppesMapper.selectByPrimaryKey(orderdetail.getShopid());
                Specification specification = specificationMapper.selectByPrimaryKey(orderdetail.getSpecification());
                if (specification!=null) {
                    shoppes.setShopweight(specification.getShopwegiht());
                    shoppes.setNewprice(specification.getShopmoney());
                }
                shoppes.setShopnum(orderdetail.getShopnum());  //购买商品数量
                shopList.add(shoppes);
            }
            ordersList.setShoppes(shopList);  //添加商品信息列表
            list.add(ordersList);  //订单添加到集合中
        }
        return list;
    }

    /*查看订单详情
    * */
    @Override
    public Orders findbyorderid(String orderid) {
        //查询该订单信息
        Orders orders = ordersMapper.findorderdetail(orderid);
        List<Shoppes> shopList=new ArrayList<>(); //存放每个订单商品信息
        //订单详情对应的商品id
        List<Orderdetail> shopids = orderdetailMapper.findshopidbyorderid(orders.getOrderid());
        //    根据id查询商品信息
        for (Orderdetail orderdetail : shopids) {
            Shoppes shoppes = shoppesMapper.selectByPrimaryKey(orderdetail.getShopid());
            Specification specification = specificationMapper.selectByPrimaryKey(orderdetail.getSpecification());
            if (specification!=null) {
                shoppes.setShopweight(specification.getShopwegiht());
                shoppes.setNewprice(specification.getShopmoney());
            }
            shoppes.setShopnum(orderdetail.getShopnum());  //购买商品数量
            shopList.add(shoppes);
        }
        orders.setShoppes(shopList);  //添加商品信息列表
        return orders;
    }

    /*删除订单
    * */
    @Override
    @Transactional
    public boolean deleteorder(String orderid) {
        Orders orders = ordersMapper.selectByPrimaryKey(orderid);
        orders.setOrderstatus(StatusUtils.ORDERS_DELETE);
        int i = ordersMapper.updateByPrimaryKeySelective(orders);
        if (i>0){
            return  true;
        }
        return false;
    }
}



