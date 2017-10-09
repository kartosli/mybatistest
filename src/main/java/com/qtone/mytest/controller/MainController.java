package com.qtone.mytest.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qtone.mytest.Model.User;
import com.qtone.mytest.Model.UserTest;
import com.qtone.mytest.Service.ITestUserService;
import com.qtone.mytest.Service.IUserService;
import com.qtone.mytest.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    ITestUserService iTestUserService;

    private IUserService service = new UserServiceImpl();

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/nice", method = RequestMethod.GET)
    public String nice(Model model) {

        model.addAttribute("result", "hahaha 第一个参数");
        return "nice";
    }

    @RequestMapping(value ="/toJsonXml")
    @ResponseBody
    public User toJsonXml(User user){
//        service.addUser(user); //一起测试了
        return service.findUserById(2);
    }

    @RequestMapping(value ="/toJson")
    @ResponseBody
    public List<User> toJson(User user){
//        service.addUser(user); //一起测试了
        return service.findAllUser();
    }


    @RequestMapping(value ="/toJsonCount")
    @ResponseBody
    public Map toJsonCount(User user){
//        service.addUser(user); //一起测试了
        int rescount =  service.getDataCount();
        Map res = new HashMap();
        res.put("count",rescount);
        return res;
    }

    @RequestMapping(value ="/toJsonList")
    @ResponseBody
    public List<UserTest> toJsonList(User user){
//        service.addUser(user); //一起测试了
        String username = user.getUsername();
        String password = user.getPassword();
        Map param = new HashMap();
        param.put("username",username);
        param.put("password",password);
        List<UserTest> uList = service.findUserList(param);

        return uList;
    }

    @RequestMapping(value ="/toJsonListPage")
    @ResponseBody
    public  List<UserTest> toJsonListPage(User user){
//        service.addUser(user); //一起测试了
        String username = user.getUsername();
        Map param = new HashMap();
        param.put("username",username);
        PageHelper.startPage(2, 2);
        List<UserTest> uList = service.findUserList(param);
        PageInfo<UserTest> users = new PageInfo<UserTest>(uList);
        List<UserTest> ulist =  users.getList();
        return ulist;
    }


    @RequestMapping(value ="/toJsonListIU")
    @ResponseBody
    public  List<UserTest> toJsonItestU(User user){
//        service.addUser(user); //一起测试了
        List  list =  iTestUserService.findUserList();
        return list;
    }
}