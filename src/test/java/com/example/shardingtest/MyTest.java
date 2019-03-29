package com.example.shardingtest;

import com.example.shardingtest.dao.UserTestMapper;
import com.example.shardingtest.domain.UserTest;
import com.example.shardingtest.service.UserTestService;
import com.example.shardingtest.util.DatasourceUtil;
import io.shardingsphere.api.HintManager;
import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;
import io.shardingsphere.core.hint.HintManagerHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.crypto.Data;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private UserTestService userTestService;

    @Test
    public void selectTest(){

        System.out.println("===============================");
        System.out.println("从主库中选择4：");
        System.out.println(userTestService.findById(4));

        System.out.println("===============================");
        System.out.println("切换至1库");
        DatasourceUtil.changeDatasource(1);
        System.out.println("从1库中选择4：");
        System.out.println(userTestService.findById(4));

        System.out.println("===============================");
        System.out.println("切换回主库");
        DatasourceUtil.changeDatasource(0);
        System.out.println("在主库中添加：李" + "操作结果：" + userTestService.addUserTest(new UserTest("李")));

        System.out.println("===============================");
        System.out.println("切换至1库");
        DatasourceUtil.changeDatasource(1);
        System.out.println("从1库中选择id=2");
        System.out.println(userTestService.findById(2));
        System.out.println("在1库中添加：li" + "操作结果：" + userTestService.addUserTest(new UserTest("li")));

        System.out.println("从1库中选择id=2");
        System.out.println(userTestService.findById(2));

    }

    @Test
    public void test2(){

        System.out.println("===============================");
        System.out.println("切换至1库");
        DatasourceUtil.changeDatasource(1);
        System.out.println("HintManager:"+HintManagerHolder.get());
        System.out.println("从1库中选择4：");
        System.out.println(userTestService.findById(4));
        System.out.println("HintManager:"+HintManagerHolder.get());
        System.out.println("从1库中选择4：");
        System.out.println(userTestService.findById(4));

    }

    @Test
    public void test3(){
        DatasourceUtil.changeDatasource(1);
        System.out.println(userTestService.findById(4));
        System.out.println(userTestService.findById(4));
    }

    @Test
    public void test4(){

        userTestService.findByIdTwice(4);

    }

}
