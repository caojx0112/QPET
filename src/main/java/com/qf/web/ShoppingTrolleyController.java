package com.qf.web;

import com.qf.bean.*;
import com.qf.service.*;
import com.qf.util.DataView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 别闹！学习呢！
 */
@Controller
public class ShoppingTrolleyController  {
    @Resource
    private ShoppingTrolleyService shoppingTrolleyService;
    @Resource
    private CouponsService couponsService;
    @Resource
    private ShopaddressService shopaddressService;
    @Resource
    private ShoppesService shoppesService;
    @Resource
    private UsersService usersService;

    /**
     * 加入购物车
     */
    @RequestMapping(method = RequestMethod.GET,value = "api/addshoppingcart")
    @ResponseBody
    public Map addshoppingcart(ShoppingTrolley shoppingTrolley){
        shoppingTrolley.setCreatetime(new Date(System.currentTimeMillis()));
        int i = shoppingTrolleyService.insertSelective(shoppingTrolley);
        Map map=new HashMap();
        map.put("code",0);
        map.put("msg","成功");
        return map;
    }

    /**
     *  购物车展示
     * @param userid
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value ="api/showshoppingcart" )
    @ResponseBody
    public DataView<ShoppingTrolley> showshoppingcart(int userid){
        List<ShoppingTrolley> shoppingTrolleys = shoppingTrolleyService.selectByPrimaryKey(userid);
        DataView<ShoppingTrolley> dataView=new DataView<ShoppingTrolley>();
        dataView.setMsg("成功");
        dataView.setCode(0);
        dataView.setData(shoppingTrolleys);
        return dataView;
    }


    /**
     * 购物车商品数量修改
     */
    @RequestMapping(method = RequestMethod.GET,value = "api/updateshoppingnum")
    @ResponseBody
    public Map updateshoppingnum(ShoppingTrolley shoppingTrolley){
        int i = shoppingTrolleyService.updateByPrimaryKeySelective(shoppingTrolley);
        ShoppingTrolley shoppingTrolley1 = shoppingTrolleyService.selectShoppingTrolley(shoppingTrolley.getUserid(), shoppingTrolley.getShopid());
        Map map=new HashMap();
        Map map1=new HashMap();
        map.put("code",0);
        map.put("msg","成功");
        Double totalmoney=0.0;
       Double shopmoney=shoppingTrolley1.getShopmoney();
       int shopnum=shoppingTrolley1.getShopnum();
        totalmoney=shopnum*shopmoney;
        map1.put("shopmoney",totalmoney);
        map.put("data",map1);
        return map;
    }

    /**
     *  购物车编辑—删除
     */
    @RequestMapping(method = RequestMethod.GET,value = "api/deleteshoppingcart")
    @ResponseBody
    public Map deleteshoppingcart(int shopcard){
        int i = shoppingTrolleyService.deleteByPrimaryKey(shopcard);
        Map map=new HashMap();
        if (i>0){
            map.put("code",0);
            map.put("msg","成功");
        }else {
            map.put("code",1);
            map.put("msg","失败");
        }

        return map;
    }

    /**
     * 购物车去结算
     */
    @RequestMapping(method = RequestMethod.POST,value = "api/shopaccount")
    @ResponseBody
    public Map shopaccount(int userid, String shoppes,double shopamount){
        List<Shopaddress> shopaddresses = shopaddressService.selectByPrimaryKey(userid);
        List<Coupons> coupons = couponsService.selectCoupons(userid);
        int emoney= usersService.selectEmoney(userid);
        int addressid = usersService.selectAddressid(userid);
        List<ShoppingTrolley> shoppes1 = shoppingTrolleyService.selectShoppes(shoppes);
        Map map=new HashMap();
        Map map1=new HashMap();
        Map map2=new HashMap();
        map.put("code",0);
        map.put("msg","成功");
        map.put("data",map1);
        map1.put("userid",userid);
        map1.put("emoney",emoney);
        map1.put("coupons",coupons);
        map1.put("addressid",addressid);
        map1.put("shoppingaddress",shopaddresses);
       // map1.put("shopes",shoppes1);
        List list=new ArrayList();
        for (ShoppingTrolley shoppingTrolley : shoppes1) {
            map2.put("shopid",shoppingTrolley.getShopid());
            map2.put("shopimage",shoppingTrolley.getShoppes().getShopimage());
            map2.put("shopname",shoppingTrolley.getShoppes().getShopname());
            map2.put("newprice",shoppingTrolley.getShoppes().getNewprice());
            map2.put("shopweight",shoppingTrolley.getSpecification());
            map2.put("shopnum",shoppingTrolley.getShopnum());
            list.add(map2);
        }
        map1.put("shopes",list);
        map1.put("shopamount",shopamount);
        return map;
    }
}
