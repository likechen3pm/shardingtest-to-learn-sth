package com.example.shardingtest.dao;

import com.example.shardingtest.domain.UserTest;
import org.springframework.stereotype.Repository;

@Repository("userTestMapperBean")
public interface UserTestMapper {
    int insert(UserTest userTest);

    UserTest selectTestById(Integer id);
}
