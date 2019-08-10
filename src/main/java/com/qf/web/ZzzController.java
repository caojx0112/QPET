package com.qf.web;


import com.qf.bean.*;
import com.qf.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ZzzController {

    @Resource
    private UserAdminService userAdminMapperService;

    @Resource
    private EvaluatesService evaluatesMapperService;

    @Resource
    private ShopdetailService shopdetailMapperService;

    @Resource
    private ShoppesService shoppesMapperService;

    @Resource
    private CollectService collectMapperService;

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    @ResponseBody
    public Map login(UserAdmin userAdmin) {
        UserAdmin login = userAdminMapperService.login(userAdmin);
        if (login == null) {
//
            Map map = new HashMap();
            map.put("code", 1);
            map.put("msg", "失败");
            map.put("data", 0);

            return map;
        } else {
            Map map = new HashMap();
            map.put("code", 0);
            map.put("msg", "成功");
            Map map1 = new HashMap();
            map1.put("username", userAdmin.getUsername());
            map.put("data", map1);

            return map;
        }

    }


    @RequestMapping("/admin/logout")
    public void loginout(HttpSession session) {
        session.invalidate();
    }

    @RequestMapping(value = "admin/updatepassword", method = RequestMethod.POST)
    @ResponseBody
    public Map updatepassword(UserAdmin userAdmin) {

        int i = userAdminMapperService.updateByPrimaryKeySelective(userAdmin);
        if (i > 0) {
            Map map = new HashMap();
            map.put("code", 0);
            map.put("msg", "成功");

            return map;
        } else {
            Map map = new HashMap();
            map.put("code", 1);
            map.put("msg", "失败");

            return map;
        }

    }

    //商品详情
    @RequestMapping(value = "api/itemdetail", method = RequestMethod.GET)
    @ResponseBody
    public Map itemdetail(int shopid) {
        Shoppes shoppes = shoppesMapperService.findById(shopid);

        if (shoppes == null) {

            Map map = new HashMap();
            map.put("code", 1);
            map.put("msg", "失败");
            map.put("data", 0);

            return map;
        } else {

            Map map = new HashMap();
            map.put("code", 0);
            map.put("msg", "成功");

            map.put("data",shoppes);

            return map;

        }
    }

    //评论
    @RequestMapping(value = "api/comment", method = RequestMethod.GET)
    @ResponseBody
    public Map comment(int id, int type) {
        List<Evaluates> evaluates = evaluatesMapperService.findById(id);
        if (evaluates == null) {
            Map map = new HashMap();
            map.put("code", 1);
            map.put("msg", "失败");
            map.put("data", 0);
            return map;
        } else {
            Map map = new HashMap();
            map.put("code", 0);
            map.put("msg", "成功");
            List list=new ArrayList();

            Eva e=null;
            for (Evaluates evaluate : evaluates) {
                e= new Eva();
                e.setUserid(evaluate.getUserid());
                e.setNickname(evaluate.getUsers().getNickname());

                if (type==1&&evaluate.getEvaluateimage()!=null){
                    String[] split = evaluate.getEvaluateimage().split(",");
                    e.setEvaluateimage(split);
                }

                e.setContent(evaluate.getContent());
                e.setCreatetime(evaluate.getCreatetime());
                e.setStarlevel(evaluate.getStarlevel());
                list.add(e);
            }
            map.put("data", list);
            return map;
        }

    }

    @RequestMapping(value = "api/itemimage", method = RequestMethod.GET)
    @ResponseBody
    public Map itemimage(int id) {
        Shopdetail itemimag = shopdetailMapperService.findItemimag(id);

        if (itemimag == null) {
            Map map = new HashMap();
            map.put("code", 1);
            map.put("msg", "失败");
            map.put("data", 0);
            return map;
        } else {
            Map map = new HashMap();
            map.put("code", 0);
            map.put("msg", "成功");
            List list = new ArrayList();
            String[] split = itemimag.getDetailimages().split(",");
            list.add(split);
            map.put("data", split);
            return map;

        }


    }


    @RequestMapping(value = "api/addcollect", method = RequestMethod.GET)
    @ResponseBody
    public Map addcollect(int userid,int shopid){
        Collect collect=new Collect();
        collect.setShopid(shopid);
        collect.setUserid(userid);
        collect.setCollectid(null);
        int insert = collectMapperService.insert(collect);

        if (insert == 0) {
//
            Map map = new HashMap();
            map.put("code", 1);
            map.put("msg", "失败");

            return map;
        } else {
            Map map = new HashMap();
            map.put("code", 0);
            map.put("msg", "成功");
            return map;
        }
    }
}


