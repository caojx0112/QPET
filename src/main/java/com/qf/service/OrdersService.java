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
}
