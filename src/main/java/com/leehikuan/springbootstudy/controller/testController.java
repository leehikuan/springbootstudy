package com.leehikuan.springbootstudy.controller;

import com.alibaba.fastjson.JSONObject;
import com.leehikuan.springbootstudy.myannotation.MethodTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/test")
public class testController {

    @MethodTime("测试")
    @GetMapping("info")
    public Object testInfo(){
        System.out.println("进入testInfo方法");
        Object parse = JSONObject.parse("{\n" +
                "\t\t\"requestId\":\"\",\n" +
                "\t\t\"appId\":\"\",\n" +
                "\t\t\"nonce\":\"\",\n" +
                "\t\t\"timestamp\":12345676543,\n" +
                "\t\t\"signature\":\"\",\n" +
                "\t\t\"sjgsd\":\"61000\",\n" +
                "\t\t\"starTime\":12345676543\n" +
                "\t}");
        try {
            Thread.sleep(new Random().nextInt(100));//随机时间休眠
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testInfo执行完毕");
        return parse ;
    }
}
