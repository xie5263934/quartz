package com.test.sheldon.controller;

import com.test.sheldon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author JINRUN.XIE
 * @since 2017/5/23
 */
@Controller
public class Hello {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/test/hello")
    public String hello(){
        helloService.hello();
        return "a";
    }
}
