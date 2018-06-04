package com.chason.nas.bountyhunter.controller;

import com.chason.nas.bountyhunter.enums.ResponseEnum;
import com.chason.nas.bountyhunter.model.ResponseModel;
import com.chason.nas.bountyhunter.model.User;
import com.chason.nas.bountyhunter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>description: </p>
 * <p>Date: 2018/5/30</p>
 * <p>modify：</p>
 *
 * @author zhang qq.773935581
 **/

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/toAdd")
    public String toAdd(){
        return "user/addUser";
    }

    @GetMapping("/toRegister")
    public String register(){
        return "user/register";
    }

    @PostMapping(value = "/doRegister")
    @ResponseBody
    public ResponseModel addUser(User user){
        int c =userService.addUser(user);
        ResponseModel model = new ResponseModel(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getDesc(),c);
        return model;
    }


    @PostMapping(value = "/doLogin")
    @ResponseBody
    public ResponseModel login(User user){
        return userService.loginUser(user);

    }

}
