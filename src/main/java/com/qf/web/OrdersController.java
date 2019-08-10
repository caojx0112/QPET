package com.qf.web;

import com.qf.bean.Evaluates;
import com.qf.bean.Orders;
import com.qf.bean.OrdersList;
import com.qf.service.OrdersService;
import com.qf.util.DataView;
import com.qf.util.DateFormat;
import com.qf.util.StatusUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
@Controller
public class OrdersController {
    @Resource
    private OrdersService ordersService;

/*
*订单结算---提交订单
 */
    @RequestMapping(value = "/api/submitorder",method = RequestMethod.POST)
    @ResponseBody
    public Map submitorder(Orders orders,String shops){

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

    /*
     * 订单结算---支付
     * */
    @RequestMapping(value = "/api/payfororder",method = RequestMethod.GET)
    @ResponseBody
    public DataView payfororder(Orders orders){
        boolean b = ordersService.paystaus(orders);
        DataView<Orders> dataView=new DataView<>();
        if (b){
            dataView.setCode(0);
            dataView.setMsg("成功");
            dataView.setData(null);
            return dataView;
        }
        dataView.setCode(1);
        dataView.setMsg("失败");
        dataView.setData(null);
        return dataView;
    }
    /*
    * 取消订单
    * */
    @RequestMapping(value = "/api/cancelorder",method = RequestMethod.GET)
    @ResponseBody
    public DataView cancelorder(String orderid,Integer userid){
        boolean b = ordersService.cancel(orderid, userid);
        DataView<Orders> dataView=new DataView<>();
        if (b){
            dataView.setCode(0);
            dataView.setMsg("成功");
            dataView.setData(null);
            return dataView;
        }
        dataView.setCode(1);
        dataView.setMsg("失败");
        dataView.setData(null);
        return dataView;
    }

    /*
    * 确认收货
    * */
    @RequestMapping(value = "/api/shouhuo",method = RequestMethod.GET)
    @ResponseBody
    public DataView shouhuo(String orderid,Integer userid){
        boolean b = ordersService.shouhuo(orderid, userid);
        DataView<Orders> dataView=new DataView<>();
        if (b){
            dataView.setCode(0);
            dataView.setMsg("成功");
            dataView.setData(null);
            return dataView;
        }
        dataView.setCode(1);
        dataView.setMsg("失败");
        dataView.setData(null);
        return dataView;
    }
    /*
    * 订单--好评
    * */
    @RequestMapping(value = "api/evaluate",method = RequestMethod.POST)
    @ResponseBody
    public Map evaluate(Evaluates evaluates, MultipartFile myfile, HttpServletRequest request) {
        try {
            String realPath = request.getRealPath("/image");
            System.out.println("realpath:"+realPath);
            myfile.transferTo(new File(realPath+"/"+myfile.getOriginalFilename()));
            //String s = realPath = realPath + "/" + myfile.getOriginalFilename();
            Date date = new Date();
            String format = DateFormat.format(date);
            String url="http://129.28.91.97:8080/Qpet_ssm/image/"+format;
            System.out.println(url);
            evaluates.setEvaluateimage(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        boolean b = ordersService.evaluate(evaluates);
        Map map=new HashMap();
        if(b) {
            map.put("code", 0);
            map.put("msg", "成功");
            return map;
        }
        map.put("code", 1);
        map.put("msg", "失败");
        return map;

    }

    /*
    * 查看订单列表
    * */
    @RequestMapping(value = "/api/showorder",method = RequestMethod.GET)
    @ResponseBody
    public DataView showorder(int userid){
        List<OrdersList> ordersList = ordersService.findall(userid);
        DataView<OrdersList> dataView=new DataView<>();
        if (ordersList.size()>0) {
            dataView.setCode(0);
            dataView.setMsg("成功");
            dataView.setData(ordersList);
            return dataView;
        }
        dataView.setCode(1);
        dataView.setMsg("失败");
        dataView.setData(ordersList);
        return dataView;
    }

    /*
     * 查看订单详情
     * */
    @RequestMapping(value = "/api/showorderdetail",method = RequestMethod.GET)
    @ResponseBody
    public Map showorderdetail(String orderid){
        Orders orders = ordersService.findbyorderid(orderid);
        Map map=new HashMap();
        if(orders!=null) {
            map.put("code", 0);
            map.put("msg", "成功");
            map.put("data", orders);
            return map;
        }
        map.put("code", 1);
        map.put("msg", "失败");
        map.put("data", orders);
        return map;
    }

    /*
     * 删除订单
     * */
    @RequestMapping(value = "/api/deleteorder",method = RequestMethod.GET)
    @ResponseBody
    public Map deleteorder(String orderid){
        boolean b = ordersService.deleteorder(orderid);
        Map map=new HashMap();
        if(b) {
            map.put("code", 0);
            map.put("msg", "成功");
            return map;
        }
        map.put("code", 1);
        map.put("msg", "失败");
        return map;
    }

}
