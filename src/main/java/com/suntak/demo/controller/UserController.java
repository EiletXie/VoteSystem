package com.suntak.demo.controller;

import com.suntak.demo.entity.Msg;
import com.suntak.demo.entity.User;
import com.suntak.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method = RequestMethod.GET)
    @ResponseBody
    private Msg userlogin(String username, String password) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        System.out.println("进入登录验证" + username + password);
        User user = userService.checkUser(username,password);
        if(user.getUserid() != null) {
            return Msg.success().add("user",user);
        }else{
            return Msg.fail();
        }
    }

    @RequestMapping(value="/userlist",method = RequestMethod.GET)
    private Map<String,Object>  getUserList() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<User> list = userService.getUserList();
        modelMap.put("userList",list);
        return modelMap;
    }

    @RequestMapping(value="/getuserbyid",method = RequestMethod.GET)
    private Map<String,Object>  getUserById(Integer userid) {
        int i = 1/0;
        Map<String, Object> modelMap = new HashMap<String, Object>();
        User user = userService.getUserById(userid);
        modelMap.put("user",user);
        return modelMap;
    }

    @RequestMapping(value="/deleteuser",method = RequestMethod.GET)
    private Map<String,Object> deleteUser(Integer userid) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",userService.deleteUser(userid));
        return modelMap;
    }


    @RequestMapping(value="/adduser",method = RequestMethod.POST)
    private Map<String,Object>  addUser(@RequestBody User user) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",userService.addUser(user));
        return modelMap;
    }

    @RequestMapping(value="/updateuser",method = RequestMethod.POST)
    private Map<String,Object>  modifyUser(@RequestBody User user) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success",userService.modifyUser(user));
        return modelMap;
    }
}
