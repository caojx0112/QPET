package com.qf.web;

import com.qf.bean.Shopaddress;
import com.qf.bean.Users;
import com.qf.service.OrdersService;
import com.qf.service.ShopaddressService;
import com.qf.service.UsersService;
import com.qf.util.DataView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 别闹！学习呢！
 */
@RestController
public class ShopaddressController {
    @Resource
    private ShopaddressService shopaddressService;
    @Resource
    private UsersService usersService;
    /**
     * 新增收货地址
     * @param shopaddress
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "api/addaddress")
    public Map addressadd(Shopaddress shopaddress){
        int i = shopaddressService.insertSelective(shopaddress);
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","成功");
        map.put("data",shopaddress.getAddressid());
        return map;
    }

    /**
     * 收货地址列表展示
     *
     * @param userid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "api/selectaddress")
    public Map selectaddress(int userid){
        DataView<Shopaddress> shopaddressDataView=new DataView<>();
        int addressid= usersService.selectAddressid(userid);
        Map map=new HashMap();
        Map map1=new HashMap();
        map.put("code",0);
        map.put("msg","成功");
        map1.put("defaultaddress",addressid);
        List<Shopaddress> shopaddressList = shopaddressService.selectByPrimaryKey(userid);
        map1.put("shopaddressList",shopaddressList);
        map.put("data",map1);
        return map;
    }

    /**
     * 收货地址--编辑
     */
    @RequestMapping(method = RequestMethod.POST,value = "api/updateaddress")
    public Map updateaddress(Shopaddress shopaddress){
        int i = shopaddressService.updateByPrimaryKeySelective(shopaddress);
        Map map=new HashMap();
        if (i>0){
            map.put("code",0);
            map.put("msg","成功");
        }else {
            map.put("code",0);
            map.put("msg","失败");
        }

        return map;
    }

    /**
     * 收货地址--删除
     */
    @RequestMapping(method = RequestMethod.GET,value = "api/deleteaddress")
    public Map deleteaddress(Integer addressid){
        int i = shopaddressService.deleteByPrimaryKey(addressid);
        Map map=new HashMap();
        if (i>0){
            map.put("code",0);
            map.put("msg","成功");
        }else {
            map.put("code",0);
            map.put("msg","失败");
        }

        return map;
    }

}
