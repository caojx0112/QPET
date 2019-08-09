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
    public Map addressadd(Shopaddress shopaddress,Integer defaultaddress){
        int i = shopaddressService.insertSelective(shopaddress);
       if (defaultaddress==1){
            Users users = usersService.selectByPrimaryKey(shopaddress.getUserid());
            users.setAddressid(shopaddress.getAddressid());
           int i1 = usersService.updateByPrimaryKeySelective(users);
       }

        Map map=new HashMap();
        Map map1=new HashMap();

        map.put("code",0);
        map.put("msg","成功");
        map1.put("addressid",shopaddress.getAddressid());
        map.put("data",map1);
        return map;
    }

    /**
     * 收货地址列表展示
     *
     * @param userid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "api/selectaddress")
    public DataView selectaddress(int userid){
        DataView<Shopaddress> dataView=new DataView<>();
        int addressid= usersService.selectAddressid(userid);
        List<Shopaddress> shopaddressList = shopaddressService.selectAdderssByuserid(userid);
        List list=new ArrayList();
        dataView.setCode(0);
        dataView.setMsg("成功");
        Map map=new HashMap();
        map.put("defaultaddress",addressid);
        //Map map1=new HashMap();
        //map1.put("shopaddressList",shopaddressList);
        map.put("shopaddressList",shopaddressList);
        list.add(map);
        dataView.setData(list);
        return dataView;
    }

    /**
     * 收货地址--编辑
     */
    @RequestMapping(method = RequestMethod.POST,value = "api/updateaddress")
    public Map updateaddress(Shopaddress shopaddress,Integer defaultaddress){
        int i = shopaddressService.updateByPrimaryKeySelective(shopaddress);
        Shopaddress shopaddress1 =
                shopaddressService.selectByPrimaryKey(shopaddress.getAddressid());
        if (defaultaddress==1){
            Users users = usersService.selectByPrimaryKey(shopaddress1.getUserid());
            users.setAddressid(shopaddress.getAddressid());
            int i1 = usersService.updateByPrimaryKeySelective(users);
        }
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
