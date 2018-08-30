package org.seckill.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liguotao on 17/10/23.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(){
        System.out.println("登陆成功");
        return "login";
    }

}
