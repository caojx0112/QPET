package com.qf.web;

import com.qf.bean.Users;
import com.qf.service.CollectService;
import com.qf.service.EvaluatesService;
import com.qf.service.OrdersService;
import com.qf.service.UsersService;
import com.qf.util.CodeUtil;
import com.qf.util.DataView;
import com.qf.util.MD5;
import com.sun.org.apache.xpath.internal.operations.Bool;
import javafx.geometry.Pos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Resource
    private UsersService usersService;
    @Resource
    private OrdersService ordersService;
    @Resource
    private EvaluatesService evaluatesService;
    @Resource
    private CollectService collectService;

    /**
     * 登录
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/api/user/login",method = RequestMethod.POST)
    @ResponseBody
    public Map login(String username, String password, HttpSession session){
        Map map=new HashMap();
        Users users = usersService.login(username);
        System.out.println(users.getPassword());
        System.out.println(new MD5().getMD5ofStr(password));
        if (users==null){
            map.put("code",1);//0成功/1失败
            map.put("msg","用户名不存在");
            map.put("data",null);
        }else if (users.getPassword().equals(new MD5().getMD5ofStr(password))){
            map.put("code",0);//0成功/1失败
            map.put("msg","成功");
            map.put("data",users);
            session.setAttribute("users",users);
        }else {
            map.put("code",1);//0成功/1失败
            map.put("msg","密码错误");
            map.put("data",null);
        }
        return map;
    }

    /**
     * 注册-获取验证码
     * @param type
     * @param textbox
     * @param session
     * @return
     */
    @RequestMapping(value = "api/user/getcode" ,method = RequestMethod.GET)
    @ResponseBody
    public Map getcode(int type,String textbox,HttpSession session){
        Map map=new HashMap();

        Users users = usersService.login(textbox);
        if (users==null){
            String code = CodeUtil.getCode();
            boolean flag=false;
            if (type==1){
                //短信发送....
                flag = usersService.getCodeBySms(textbox, code);
            }else{
                flag = usersService.getCodeByEmail(textbox, code);
            }
            if (flag){//成功
                session.setAttribute("code",code);
                session.setAttribute("textbox",textbox);
                session.setAttribute("codeStatus",false);
                map.put("code",0);
                map.put("msg","成功");
            }else {//失败
                map.put("code",1);
                map.put("msg","失败");
            }
        }else {
            map.put("code",1);
            map.put("msg","该用户已注册，请直接登录");
        }
        return map;
    }

    /**
     * 注册-发送验证码
     * @param code
     * @param session
     * @return
     */
    @RequestMapping(value = "api/user/postcode",method = RequestMethod.POST)
    @ResponseBody
    public Map postcode(String code,HttpSession session){
        Map map=new HashMap();
        String sessionCode =(String) session.getAttribute("code");
        if (code.equals(sessionCode)){
            map.put("code",0);
            map.put("msg","成功");
            session.setAttribute("codeStatus",true);
        }else {
            map.put("code",1);
            map.put("msg","验证码不正确");
        }
        return map;
    }

    /**
     * 注册-设置密码
     * @param textbox
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "api/user/setpassword",method = RequestMethod.POST)
    @ResponseBody
    public Map setPassword(String textbox,String password,HttpSession session){
        Map map=new HashMap();
        String sessionTextbox = (String) session.getAttribute("textbox");
        boolean codeStatus=(boolean) session.getAttribute("codeStatus");
        if (sessionTextbox==null){
            map.put("code",1);
            map.put("msg","请先验证");
        }else if (sessionTextbox.equals(textbox)){
            if (codeStatus==true){
                Users users=new Users();
                users.setUsername(textbox);
                users.setPassword(new MD5().getMD5ofStr(password));
                users.setNickname("小Q君");
                users.setUserimages("http://129.28.91.97:8080/Qpet_ssm/image/dfhead.jpg");
                Date date=new Date();
                date.setYear(100);
                date.setMonth(0);
                date.setDate(1);
                users.setBirthday(date);
                users.setEmoney(0);
                users.setUserstatus(1);
                users.setCreatetime(new Date());
                users.setUsersex("保密");
                int i = usersService.insertSelective(users);
                if (i>0){
                    map.put("code",0);
                    map.put("msg","成功");
                }else {
                    map.put("code",1);
                    map.put("msg","失败");
                }
            }else {
                map.put("code",1);
                map.put("msg","请先验证");
            }
        }
        return map;
    }

    /**
     * 找回密码-获取验证码
     * @param type
     * @param textbox
     * @param session
     * @return
     */
    @RequestMapping(value = "api/user/getusercode" ,method = RequestMethod.GET)
    @ResponseBody
    public Map getusercode(int type,String textbox,HttpSession session){
        Map map=new HashMap();
        String code = CodeUtil.getCode();
        boolean flag=false;
        Users login = usersService.login(textbox);
        if (login==null){
            map.put("code",1);
            map.put("msg","用户不存在");
        }else {
            if (type==1){
                //短信发送....
                flag=usersService.getCodeBySms(textbox,code);
            }else{
                flag = usersService.getCodeByEmail(textbox, code);
            }
            if (flag){//成功
                session.setAttribute("regcode",code);
                session.setAttribute("regtextbox",textbox);
                session.setAttribute("regcodeStatus",false);
                map.put("code",0);
                map.put("msg","成功");
            }else {//失败
                map.put("code",1);
                map.put("msg","失败");
            }
        }
        return map;
    }

    /**
     * 找回密码-发送验证码
     * @param code
     * @param session
     * @return
     */
    @RequestMapping(value = "api/user/postusercode",method = RequestMethod.POST)
    @ResponseBody
    public Map postusercode(String code,HttpSession session){
        Map map=new HashMap();
        String sessionCode =(String) session.getAttribute("regcode");
        if (code.equals(sessionCode)){
            map.put("code",0);
            map.put("msg","成功");
            session.setAttribute("regcodeStatus",true);
        }else {
            map.put("code",1);
            map.put("msg","验证码不正确");
        }
        return map;
    }

    /**
     * 找回密码-设置密码
     * @param textbox
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "api/user/setuserpassword",method = RequestMethod.POST)
    @ResponseBody
    public Map setuserpassword(String textbox,String password,HttpSession session){
        Map map=new HashMap();
        String sessionTextbox = (String) session.getAttribute("regtextbox");
        boolean codeStatus=(boolean) session.getAttribute("regcodeStatus");
        if (sessionTextbox==null){
            map.put("code",1);
            map.put("msg","请先验证");
        }else if (sessionTextbox.equals(textbox)){
            if (codeStatus==true){
                Users users=new Users();
                users.setUsername(textbox);
                users.setPassword(new MD5().getMD5ofStr(password));
                int i = usersService.setPassword(users);
                if (i>0){
                    map.put("code",0);
                    map.put("msg","成功");
                }else {
                    map.put("code",1);
                    map.put("msg","失败");
                }
            }else {
                map.put("code",1);
                map.put("msg","请先验证");
            }
        }
        return map;
    }
    @RequestMapping(value = "/api/islogin",method = RequestMethod.GET)
    @ResponseBody
    public Map islogin(HttpSession session){
        Map map=new HashMap();
        Object users = session.getAttribute("users");
        if (users!=null) {
            map.put("status","true");
        }else {
            map.put("status","false");
        }
        return map;
    }

    /*
    * 我的--信息展示
    * */
    @RequestMapping(value = "api/userinfo/select",method = RequestMethod.GET)
    @ResponseBody
    public Map select(int userid){
        Users users = usersService.selectByPrimaryKey(userid);
        Map map=new HashMap();
        if(users!=null) {
            map.put("code", 0);
            map.put("msg", "成功");
            map.put("data", users);
            return map;
        }
        map.put("code", 1);
        map.put("msg", "失败");
        map.put("data", users);
        return map;
    }


}
