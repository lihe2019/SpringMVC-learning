package com.lihe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {


    @RequestMapping("/main")
    public String main(){
        return "main";
    }
    @RequestMapping("/goLogin")
    public String login(){
        return "login";
    }
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password, Model model){
        // 把用户的信息存在session中，页面跳转后还存在
        session.setAttribute("userLoginInfo", username);
        model.addAttribute("username", username);
        return "main";
    }

    @RequestMapping("/goOut")
    public String goOut(HttpSession session){
        // 把用户的信息存在session中，页面跳转后还存在
        session.removeAttribute("userLoginInfo");

        return "main";
    }
}
