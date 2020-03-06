package com.mycode.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.mycode.*")
@Configuration
@EnableAspectJAutoProxy // 对应此标签<aop:aspectj-autoproxy />
public class SpringAopConfig {
}
