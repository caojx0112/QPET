package com.qf.web;

import com.qf.bean.Shoppes;
import com.qf.bean.Shoptypes;
import com.qf.service.ShoptypesService;
import com.qf.util.DataView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 何以与君识,
 * 何以与卿识
 * 无言泪千行
 * 终究是意难平
 */
@RestController
public class ShoptypesController {

    @Resource
    private ShoptypesService shoptypesService;

    //后台页面商品分类
    @GetMapping("admin/pet")
    public DataView pet(){
        List<Shoptypes> list = shoptypesService.pet();
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
    @PostMapping("admin/pet/addtype")
    public DataView insertSelective(Shoptypes shoptypes){
        int i = shoptypesService.insertSelective(shoptypes);
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
}

