package com.qf.service;

import com.qf.bean.Orders;

/**
 * ** 程序猿
 * 一入代码深似海，
 * 小试牛刀异常来。
 * 奈何BUG直挠耳，
 * 仰天大笑出门来。
 */
public interface OrdersService {
    //新增订单
    public Orders insertorders(Orders orders,String shops);
    //订单-支付
    public boolean paystaus(Orders orders);
    //订单--取消
    public boolean cancel(String orderid,Integer userid);
    //确认收货
    public boolean shouhuo(String orderid,Integer userid);
}
