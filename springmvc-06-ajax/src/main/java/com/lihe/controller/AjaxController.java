package com.lihe.controller;

import com.lihe.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        System.out.println("a1:para=>" + name);
        if ("lihe".equals(name)){
            response.getWriter().println("true");
        }else {
            response.getWriter().println("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2(){
        List<User> userList = new ArrayList<User>();
        userList.add(new User("李赫", 3, "男"));
        userList.add(new User("李赫2", 3, "男"));
        userList.add(new User("李赫3", 3, "男"));
        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name, String pwd){
        String msg = "";
        if (name != null){
            // 这些数据应该在数据库中 查
            if ("admin".equals(name)){
                msg = "OK";
            }else {
                msg = "用户名有误";
            }
        }
        if (pwd != null){
            // 这些数据应该在数据库中 查
            if ("123456".equals(pwd)){
                msg = "OK";
            }else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
