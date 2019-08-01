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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            //修改库存
            int count=shoppes.getShopnum()-orderdetail.getShopnum();
            shoppes.setShopnum(count);
            //修改状态---不为下架
            if (shoppes.getShopstatus()!=StatusUtils.SHOP_SOLDOUT) {
                if (count == 0) {
                    shoppes.setShopstatus(StatusUtils.SHOP_SHOUKONG);
                }
            }
            shoppesMapper.updateByPrimaryKeySelective(shoppes);
        }
        //修改用户信息 --E币  优惠卷数量
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
            usersCoupons.setCouponstatus(StatusUtils.COUPONS_OFFUSE); //改为已使用2
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

    @Override
    @Transactional
    public boolean paystaus(Orders orders) {
        if (orders.getPaystatus()==2){//支付成功
            orders.setPaystatus(StatusUtils.PAY_YES);
            orders.setOrderstatus(StatusUtils.ORDERS_OFFSHIPMENTS);
            orders.setExpirationtime(null);  //取消过期时间
            ordersMapper.updatepaystatus(orders);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean cancel(String orderid, Integer userid) {
        boolean falg=false;
        Orders orders = ordersMapper.selectByPrimaryKey(orderid);
        //修改订单状态为已取消  --5
        orders.setOrderstatus(StatusUtils.ORDERS_CANCEL);
        ordersMapper.updateByPrimaryKeySelective(orders);
        //修改E币
        if (orders.getEmoney()>0){
            Users users = usersMapper.selectByPrimaryKey(orders.getUserid());
            users.setEmoney(users.getEmoney()+orders.getEmoney());
            usersMapper.updateByPrimaryKeySelective(users);
        }
        //查询购买的商品
        List<Orderdetail> orderdetails = orderdetailMapper.findbyOrderid(orderid);
        for (Orderdetail orderdetail : orderdetails) {
            Shoppes shoppes = shoppesMapper.selectByPrimaryKey(orderdetail.getShopid());
            //修改商品数量
            shoppes.setShopnum(shoppes.getShopnum()+orderdetail.getShopnum());
            //修改商品状态
            if (shoppes.getShopstatus()!=StatusUtils.SHOP_SOLDOUT){
                shoppes.setShopstatus(StatusUtils.SHOP_SELL);
            }
            shoppesMapper.updateByPrimaryKeySelective(shoppes);
        }
        falg=true;
        return falg;
    }

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
}



