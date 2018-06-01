package com.zhujh.controller.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/31.
 */
@RestController
public class HelloController
{
    @RequestMapping("/index")
    public String index()
    {
        return "Greetings From Spring";
    }

}
