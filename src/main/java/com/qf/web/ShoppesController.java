package com.qf.web;

import com.qf.bean.Shoppes;
import com.qf.bean.Shoptypes;
import com.qf.service.ShoppesService;
import com.qf.service.ShoptypesService;
import com.qf.util.DataView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 何以与君识,
 * 何以与卿识
 * 无言泪千行
 * 终究是意难平
 */
@RestController
public class ShoppesController {
    @Resource
    private ShoppesService shoppesService;
    @Resource
    private ShoptypesService shoptypesService;

    //首页全查(首页显示信息)
    @GetMapping("api/animal")
    public Map findAll(){
        Map map = new HashMap();
        Map list = shoppesService.findAll();
        DataView dataView = new DataView();
        if (list==null){
            map.put("code",1);
            map.put("msg","失败");
            map.put("data",null);
        }else {
            map.put("code",0);
            map.put("msg","成功");
            map.put("data",list);
        }
        return map;
    }
    //搜索填充
    @PostMapping("api/keyword")
    public DataView fill(String k, Integer type){
        List<String> list = shoppesService.fill(k,type);
        DataView dataView = new DataView();
        if (list==null){
            dataView.setCode(1);
            dataView.setMsg("失败");
            dataView.setData(null);
        }else {
            dataView.setCode(0);
            dataView.setMsg("成功");
            dataView.setData(list);
        }
        return dataView;
    }
    //热门搜索
    @GetMapping("api/hotserch")
    public DataView findHot(){
        List<String> list = shoppesService.findHot();
        DataView dataView = new DataView();
        if (list==null){
            dataView.setCode(1);
            dataView.setMsg("失败");
            dataView.setData(null);
        }else {
            dataView.setCode(0);
            dataView.setMsg("成功");
            dataView.setData(list);
        }
        return dataView;
    }


    //搜索功能( 上架时间  排序方式  商品种类     价格筛选    销量筛选 )
    @PostMapping("api/serchlist")
    public DataView find(String shopname, Integer type, Integer sort1, Integer sort2, Integer sort3, Integer sort4, Integer sort5){
        List<Shoppes> list = shoppesService.find(shopname,type,sort1,sort2,sort3,sort4,sort5);
        DataView dataView = new DataView();
        if (list==null){
            dataView.setCode(1);
            dataView.setMsg("失败");
            dataView.setData(null);
        }else {
            dataView.setCode(0);
            dataView.setMsg("成功");
            dataView.setData(list);
        }
        return dataView;
    }


    //后台页面商品列表
    @GetMapping("admin/pet/type")
    public DataView pettype(Integer typeid){
        List<Shoptypes> list = shoppesService.pettype(typeid);
        DataView dataView = new DataView();
        if (list==null){
            dataView.setCode(1);
            dataView.setMsg("失败");
            dataView.setData(null);
        }else {
            dataView.setCode(0);
            dataView.setMsg("成功");
            dataView.setData(list);
        }
        return dataView;
    }
    //修改商品
    @PostMapping("admin/pet/update")
    public DataView petupdate(Shoppes shoppes){
        int i = shoppesService.updateByPrimaryKeySelective(shoppes);
        DataView dataView = new DataView();
        if (i<0){
            dataView.setCode(1);
            dataView.setMsg("失败");
        }else {
            dataView.setCode(0);
            dataView.setMsg("成功");
        }
        return dataView;
    }
    //新增商品
    @PostMapping("admin/pet/additem")
    public DataView insertSelective(Shoppes shoppes){
        int i = shoppesService.insertSelective(shoppes);
        DataView dataView = new DataView();
        if (i<0){
            dataView.setCode(1);
            dataView.setMsg("失败");
        }else {
            dataView.setCode(0);
            dataView.setMsg("成功");
        }
        return dataView;
    }
    //删除商品
    @GetMapping("admin/pet/delete")
    public DataView deleteByPrimaryKey(Integer shopid){
        int i = shoppesService.deleteByPrimaryKey(shopid);
        DataView dataView = new DataView();
        if (i<0){
            dataView.setCode(1);
            dataView.setMsg("失败");
        }else {
            dataView.setCode(0);
            dataView.setMsg("成功");
        }
        return dataView;
    }
    //删除商品
    @GetMapping("admin/pet/findbyid")
    public Map selectByPrimaryKey(Integer shopid,Integer type){
        Shoppes shoppes = shoppesService.selectByPrimaryKey(shopid);
        List<Shoptypes> list = shoptypesService.findbytype(type);
        shoppes.setSpecies(list);
        Map map = new HashMap();
        if (shoppes==null){
            map.put("code",1);
            map.put("msg","失败");
            map.put("data",null);
        }else {
            map.put("code",0);
            map.put("msg","成功");
            map.put("data",shoppes);
        }
        return map;
    }
}
