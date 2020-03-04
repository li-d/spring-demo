package com.mycode.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;

//通知
public class Advice {

    //前置通知
    public void methodBefore() {
        System.out.println("methodBefore前置通知执行....");
    }


    //前置通知 获取参数
    public void before(JoinPoint joinPoint) {
        //org.aspectj.lang.JoinPoint这个参数会获得切入点的信息 可以获取方法名 还可以获取参数等等
        String params = "";
        Object[] objects = joinPoint.getArgs();
        if (!CollectionUtils.isEmpty(Arrays.asList(objects))) {
            for (Object obj : objects) {
                params += obj + "----";
            }

        }
        System.out.println("before前置通知执行:方法名:" + joinPoint.getSignature().getName() + "----参数:" + params);
    }


    //返回通知
    public void afterReturning(String returnIng) {
        System.out.println("afterReturning返回通知执行:" + returnIng);
    }
}
