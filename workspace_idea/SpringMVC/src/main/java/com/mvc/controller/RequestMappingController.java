package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author YangFeng
 * @create 2022-05-28 10:50
 */
@RequestMapping("/rmc")
@Controller
public class RequestMappingController {
    @RequestMapping("/handle1")
    public String handle1(){
        System.out.println("RequestMappingController----handle");
        return "HelloWorld";
    }

    /**
     * RequestMapping的其他属性
     * @return
     */
    @RequestMapping(value = "/handle2", method = RequestMethod.POST)
    public String handle2(){
        return "HelloWorld";
    }

    @RequestMapping(value = "/handle3", params = "username")
    public String handle3(){
        return "HelloWorld";
    }
}
