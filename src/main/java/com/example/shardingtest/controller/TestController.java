package com.example.shardingtest.controller;

import com.example.shardingtest.dao.UserTestMapper;
import com.example.shardingtest.domain.UserTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/findTest")
public class TestController {
    @Resource
    private UserTestMapper userTestMapper;

    @GetMapping
    @ResponseBody
    public UserTest findTest(@RequestParam("id") Integer id){
        UserTest userTest = userTestMapper.selectTestById(id);
        return userTest;
    }
}
