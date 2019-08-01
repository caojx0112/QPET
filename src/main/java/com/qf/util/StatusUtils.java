package com.qf.util;

/**
 * ** 程序猿
 * 一入代码深似海，
 * 小试牛刀异常来。
 * 奈何BUG直挠耳，
 * 仰天大笑出门来。
 */
/*
* 状态工具类
* */
public class StatusUtils {
    public static int ORDERS_DELETE=0;  //订单状态 -已删除
    public static int ORDERS_OFFPAY=1;  //订单状态 -待付款
    public static int ORDERS_OFFSHIPMENTS=2;  //订单状态 -待发货
    public static int ORDERS_SHIPMENTS=3;  //订单状态 -待收货
    public static int ORDERS_OFFEVALUATE=4;  //订单状态 -待评价
    public static int ORDERS_CANCEL=5;  //订单状态 -已取消

    public static int PAY_OFF=1;    //订单支付 -未支付
    public static int PAY_YES=2;    //订单支付 -已支付

    public static int SHOP_SELL=1;     //商品 --在售
    public static int SHOP_SHOUKONG=2;     //商品 --售空
    public static int SHOP_SOLDOUT=3;     //商品 --下架

    public static int COUPONS_ONUSE=1;  //优惠卷  --未使用
    public static int COUPONS_OFFUSE=2;  //优惠卷  --已使用
    public static int COUPONS_PASTDUE=3;  //优惠卷  --已过期
}
