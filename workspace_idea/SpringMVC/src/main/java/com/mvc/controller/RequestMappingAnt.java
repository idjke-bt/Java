package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author YangFeng
 * @create 2022-05-31 15:01
 */
@Controller
public class RequestMappingAnt {

    @RequestMapping(value = "/ant1")
    public String antRes1(){
        System.out.println("======antRes1=====");
        return "HelloWorld";
    }

    @RequestMapping(value = "/ant?")
    public String antRes2(){
        System.out.println("=====antRes2=====");
        return "HelloWorld";
    }
}
