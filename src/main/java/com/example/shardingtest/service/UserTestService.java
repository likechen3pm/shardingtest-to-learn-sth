package com.example.shardingtest.service;

import com.example.shardingtest.dao.UserTestMapper;
import com.example.shardingtest.domain.UserTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserTestService {

    private UserTestMapper userTestMapper;

    public int addUserTest(UserTest userTest){
        return userTestMapper.insert(userTest);
    }

    public UserTest findById(Integer id){
        return userTestMapper.selectTestById(id);
    }

    public void findByIdTwice(Integer id){
        System.out.println(userTestMapper.selectTestById(id));
        System.out.println(userTestMapper.selectTestById(id+1));
    }

    @Autowired
    public void setUserTestMapper(UserTestMapper userTestMapper) {
        this.userTestMapper = userTestMapper;
    }
}
