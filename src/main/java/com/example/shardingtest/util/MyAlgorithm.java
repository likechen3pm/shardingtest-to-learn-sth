package com.example.shardingtest.util;

import com.alibaba.druid.util.StringUtils;
import io.shardingsphere.api.algorithm.sharding.ListShardingValue;
import io.shardingsphere.api.algorithm.sharding.ShardingValue;
import io.shardingsphere.api.algorithm.sharding.hint.HintShardingAlgorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyAlgorithm implements HintShardingAlgorithm {

    /**
     *
     * @param collection 存放所有的datasource，即可以路由到的所有数据源，就是配置文件里定义的所有ds
     * @param shardingValue 由hintmanager传入的目标数据源参数，可能是list<>或是range<>
     *                      如果用setDatebaseShardingValue(),里面其实只有一个值，表示强制路由到目标数据库
     * @return 我们的算法需要从collection中筛选出与shardingValue指定的目标数据源相匹配的项，进行返回
     */
    @Override
    public Collection<String> doSharding(Collection<String> collection, ShardingValue shardingValue) {
        //结果集
        List<String> shardingResult = new ArrayList<>();

        //筛选collection，填入结果集，collection里其实是数据源名称：ds0,ds1.....
        collection.forEach(datasourceName -> {
            //获取数据源名称后面的数字,数据源都是ds+数字命名的，改变命名方式，下面的代码要重写
            String suffix = datasourceName.substring(datasourceName.lastIndexOf("s") + 1);
            if(StringUtils.isNumber(suffix)){
                ListShardingValue<Integer> listShardingValue = (ListShardingValue<Integer>) shardingValue;
                listShardingValue.getValues().forEach(value->{
                    if(value == Integer.parseInt(suffix)){
                        shardingResult.add(datasourceName);
                    }

                });
            }

        });
        System.out.println("ds集合collection:" + collection);
        System.out.println("shardingValue:" + shardingValue);
        System.out.println("路由结果:" + shardingResult);
        return shardingResult;
    }

}
