package com.lihe.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lihe.pojo.User;
import com.lihe.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

//@Controller
@RestController
public class UserController {

    @RequestMapping(value = "/j1")
//    @ResponseBody (和Controller配合使用) // 他就不会走视图解析器，会直接返回一个字符串
    public String json1() throws JsonProcessingException {
        // jackson, ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // 创建一个对象
        User user = new User("李赫1", 3, "男");

        String str = mapper.writeValueAsString(user);
        return str;
    }
    @RequestMapping(value = "/j2")
    public String json2() throws JsonProcessingException {
        // jackson, ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // 创建一个对象
        User user = new User("李赫1", 3, "男");
        User user1 = new User("李赫2", 3, "男");
        User user2 = new User("李赫3", 3, "男");
        User user3 = new User("李赫4", 3, "男");
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        String str = mapper.writeValueAsString(users);
        return str;
    }
    @RequestMapping(value = "/j3")
    public String json3() throws JsonProcessingException {
        // jackson, ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        // 创建一个对象
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String str = mapper.writeValueAsString(sdf.format(date));
        return str;
    }
    @RequestMapping(value = "/j4")
    public String json4() throws JsonProcessingException {

        Date date = new Date();

        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("/j5")
    public String json5(){
        // 创建一个对象
        User user = new User("李赫1", 3, "男");
        User user1 = new User("李赫2", 3, "男");
        User user2 = new User("李赫3", 3, "男");
        User user3 = new User("李赫4", 3, "男");
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);

        String str = JSON.toJSONString(users);
        return str;
    }
}
