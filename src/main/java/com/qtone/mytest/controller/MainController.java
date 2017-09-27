package com.qtone.mytest.controller;

import com.qtone.mytest.Model.User;
import com.qtone.mytest.Service.IUserService;
import com.qtone.mytest.Service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
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
}