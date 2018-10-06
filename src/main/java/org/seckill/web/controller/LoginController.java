package org.seckill.web.controller;

import org.seckill.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liguotao on 17/10/23.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(String userName,String password){
        System.out.println("username-->"+userName+":: password---"+password);
        System.out.println("登陆成功");
        return "main";
    }
    @RequestMapping(value = "/login1")
    public ModelAndView login1(User user) {

        ModelAndView modelAndView = new ModelAndView("main");
        modelAndView.addObject("userName", user.getUserName());

        return  modelAndView;
    }


    @RequestMapping(value = "/main")
    public String toMain(){

        return "main";
    }



}
