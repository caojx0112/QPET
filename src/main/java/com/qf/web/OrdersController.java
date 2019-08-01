package com.qf.web;

import com.qf.bean.Orders;
import com.qf.service.OrdersService;
import com.qf.util.StatusUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * ** 程序猿
 * 一入代码深似海，
 * 小试牛刀异常来。
 * 奈何BUG直挠耳，
 * 仰天大笑出门来。
 */
@Controller
public class OrdersController {
    @Resource
    private OrdersService ordersService;

/*
*订单结算---提交订单
 */
    @RequestMapping(value = "/api/submitorder",method = RequestMethod.POST)
    @ResponseBody
    public Map submitorder(int userid,int emoney,int couponsid,int addressid,double orderamount,
                           String orderdesc,String shops){
        Orders orders=new Orders();
        orders.setUserid(userid);
        orders.setAddressid(addressid);
        orders.setCouponsid(couponsid);
        orders.setEmoney(emoney);
        orders.setOrderamount(orderamount);
        orders.setOrderstatus(StatusUtils.ORDERS_OFFPAY);
        orders.setPaystatus(StatusUtils.PAY_OFF);
        orders.setOrderdesc(orderdesc);

        Orders orders1=null;
        orders1 = ordersService.insertorders(orders, shops);
        Map map=new HashMap();
        if(orders1!=null) {
            map.put("code", 0);
            map.put("msg", "成功");
            Map map1 = new HashMap();
            map1.put("orderid",orders1.getOrderid());
            map1.put("expirationtime",orders1.getExpirationtime());
            map.put("data", map1);
            return map;
        }
        map.put("code", 1);
        map.put("msg", "失败");
        Map map1 = new HashMap();
        map1.put("orderid",orders1.getOrderid());
        map1.put("expirationtime",orders1.getExpirationtime());
        map.put("data", map1);
        return map;
    }
}
