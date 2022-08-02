package com.example.onlineorder.controller;

import com.example.onlineorder.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.example.onlineorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;


@Controller //has to add this. 看到这个就会监测到底下有要用到的
public class SignUpController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED) //返回给前端看注册成不成功
    public void signUp(@RequestBody Customer customer) { //自动转换json对应到cuctomer model.省去手动解析json获取数据的过程
        customerService.signUp(customer);//负责去数据库把customer保存下来
    }
}