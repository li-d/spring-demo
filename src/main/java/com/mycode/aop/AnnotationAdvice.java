package com.mycode.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;


@Aspect
@Component
public class AnnotationAdvice {

    @Pointcut("execution(public * com.mycode.service.UserService.addUser())")
    public void pointCut(){

    }


    @Before(value = "pointCut()")
    public void methodBefore() {
        System.out.println("methodBefore前置通知执行....");
    }


    @Before(value = "pointCut()")
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


    @AfterReturning(value = "pointCut()",returning = "returnIng")
    public void afterReturning(String returnIng) {
        System.out.println("afterReturning返回通知执行:" + returnIng);
    }


    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowing(Exception ex) {
        System.out.println("如果有配置后置通知就会在这句话前边打印。。。。");
        System.out.println("afterThrowing异常通知执行:【" + ex.getMessage()+"】");
    }

    //环绕通知
   /* @Around(value = "pointCut()")
    public void around(){
        System.out.println("around环绕通知执行：...");
    }*/
}
