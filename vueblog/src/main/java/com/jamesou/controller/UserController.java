package com.jamesou.controller;

import com.jamesou.common.util.Result;
import com.jamesou.entity.User;
import com.jamesou.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author JamesOu
 * @since 2020-05-24
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/test")
    public Result test(){
        User user = userService.getById(1L);
        return Result.succ(user) ;
    }


    @PostMapping("/save")
    public Result save(User user){
      return Result.succ(user);
    }

}
