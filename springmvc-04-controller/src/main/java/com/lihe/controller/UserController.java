package com.lihe.controller;

import com.lihe.pojo.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    // 最好加上RequestParam
    public String test1(@RequestParam("username") String name, Model model){
        // 1.接收前端参数
        System.out.println("接收到的前端参数：" + name);
        // 2.将返回的结果传递给前端
        model.addAttribute("msg", name);
        return "test";
    }
    // 接受三个参数
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }

    /*
    1.接受的是参数，判断参数名字，匹配之后直接使用
    2. 传递的参数式一个对象，匹配USer对象中的字段，名字一致，否则匹配失败
     */

    @GetMapping("/t3")
    public String test3(ModelMap map){
        map.addAttribute("msg", "nn");
        return "test";
    }
}
