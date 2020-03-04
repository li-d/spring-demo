package com.mycode.config;

import com.mycode.dao.AccountDao;
import com.mycode.entity.xml.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration // 通过该注解来表明该类是一个Spring的配置，相当于一个xml文件
@ComponentScan("com.mycode") //将包下的注解扫描进入Spring容器中 必须要配置 否则注解配置无效  相当于<context:component-scan base-package="com.mycode"/>
//@Import(SpringConfig2.class)  //导入合并其他配置类，类似于配置文件中的 import 标签
public class SpringConfig {

    @Bean(name = "accountDao") //相当于在容器中配置了一个Bean 默认bean的id为方法名 若配置name属性则为对应的值
    @Scope(value = "prototype") //作用域
    public AccountDao getAccountDao(){
        return new AccountDao();
    }






    //关于@Bean的参数注入问题:

    @Bean
    public User user1() {
        User user = new User();
        user.setAge(1);
        return user;
    }

    @Bean
    public User user2(User user1) {
        System.out.println("user1 is -> "+ user1);
        User user2 = new User();
        user2.setAge(2);
        return user2;
    }

    @Bean
    public User user3(User user2) {
        System.out.println("user2 is -> "+ user2);
        User user23 = new User();
        user23.setAge(3);
        return user23;
    }

    // 如上，有参数user1，user2
    // 若spring容器中只有一个User类型的bean，则不论参数名称是什么都是按唯一类型取bean作为参数
    // 若有多个User类型的bean 则按照参数的名称取参数,取不到则报错。
}
