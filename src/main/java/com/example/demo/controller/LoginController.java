package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author
 * @description
 * @create 2017-11-14 下午4:35
 **/
@Controller
public class LoginController {


    @RequestMapping("/login")
    public String login (HttpServletRequest request,String username,String password){

        if (!StringUtils.isEmpty(username)&&username.equalsIgnoreCase("dht")){
            request.getSession().setAttribute("user",username);
        }else{

            return "login";
        }
        return "index";
    }


}
