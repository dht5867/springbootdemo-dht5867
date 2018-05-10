package com.example.demo.controller;

import com.example.demo.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 代洪涛
 * @description
 * @create 2018-05-06 下午12:17
 **/
@Controller
public class HelloController {


    @RequestMapping("/thymeleaf")
    public String thymeleaf(ModelMap map) {
        map.addAttribute("host", "http://www.baidu.com");
        return "thymeleaf-index";
    }

    @RequestMapping("/freemarker")
    public String freemarker(ModelMap map) {
        map.addAttribute("host", "http://www.baidu.com");
        return "freemarker-index";
    }
    @RequestMapping("/velocity")
    public String velocity(ModelMap map) {
        map.addAttribute("host", "http://www.baidu.com");
        return "velocity";
    }


    @RequestMapping("/html")
    public String error() throws Exception {
        throw new Exception("发生错误");
    }


    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
}
