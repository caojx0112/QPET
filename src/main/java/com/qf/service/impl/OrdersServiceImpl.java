package com.qf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.qf.bean.Orderdetail;
import com.qf.bean.Orders;
import com.qf.bean.Shoppes;
import com.qf.dao.OrderdetailMapper;
import com.qf.dao.OrdersMapper;
import com.qf.dao.ShoppesMapper;
import com.qf.service.OrdersService;
import com.qf.util.DateFormat;
import com.qf.util.StatusUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Override
    @Transactional
    public Orders insertorders(Orders orders,String shops) {
        //新增订单表
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
        //修改商品表信息
        List<Orderdetail> orderdetails = JSONObject.parseArray(shops, Orderdetail.class);
        for (Orderdetail orderdetail : orderdetails) {
            //查询商品详情
            Shoppes shoppes = shoppesMapper.selectByPrimaryKey(orderdetail.getShopid());
            //修改库存
            int count=shoppes.getShopnum()-orderdetail.getShopnum();
            shoppes.setShopnum(count);
            //修改状态
            if (count==0){
                shoppes.setShopstatus(StatusUtils.SHOP_SHOUKONG);
            }
            shoppesMapper.updateByPrimaryKeySelective(shoppes);
        }
        //新增订单详情表
        for (Orderdetail orderdetail : orderdetails) {
            orderdetail.setOederid(format);
            orderdetailMapper.insertSelective(orderdetail);
        }

        Orders orders1 = ordersMapper.selectByPrimaryKey(format);
        return orders1;
    }


}
