package com.example.shardingtest.util;

import io.shardingsphere.api.HintManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class datasourceAspect {

    @Pointcut("execution(* com.example.shardingtest.service..*(..))")
    public void dataAccessService(){}

    @Around("dataAccessService()")
    public Object setHint(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around start:--------------");
        HintManager hintManager = HintManager.getInstance();
        hintManager.setDatabaseShardingValue(DatasourceUtil.getDatasource());
        Object res =  pjp.proceed();
        hintManager.close();
        System.out.println("Around end:----------------");
        return res;
    }




}
