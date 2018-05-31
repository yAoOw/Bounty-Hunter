package com.chason.nas.bountyhunter.controller;

import com.chason.nas.bountyhunter.model.User;
import com.chason.nas.bountyhunter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/torRegister")
    public String register(){
        return "user/register";
    }
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public String addUser(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        String passWord = request.getParameter("passWord");
        String phone = request.getParameter("re");
        User user = new User();
        user.setUserName(name);
        user.setPassword(passWord);
        user.setPassword(phone);
         userService.addUser(user);
        return "index";
    }



}
