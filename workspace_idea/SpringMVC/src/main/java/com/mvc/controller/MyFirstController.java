package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 1.告诉SpringMVC这个一个处理器可以处理请求--->@Controller:标识该组件是个控制器
 *
 * @author YangFeng
 * @create 2022-05-21 15:37
 */

@Controller
public class MyFirstController {
    /**
     * /hello:当前项目下的hello请求
     * / 代表当前项目下的开始，处理当前项目下的hello请求
     */
    @RequestMapping("/hello")
    public String firstRequest(){
        System.out.println("处理hello请求");
        System.out.println("前往HelloWorld.jsp....");
        return "HelloWorld";
    }


}
