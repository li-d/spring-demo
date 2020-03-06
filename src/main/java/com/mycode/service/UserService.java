package com.mycode.service;

import com.mycode.dao.AccountDao;
import com.mycode.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service  //默认使用类名首字母小写(即userService)作为Bean的id

// @Component三个衍生注解
//为了更好的进行分层，Spring可以使用其它三个注解，功能一样，目前使用哪一个功能都一样。
//@Controller：web层
//@Service：service层
//@Repository：dao层
public class UserService {

    @Autowired
    private UserDao userDao;
    @Resource
    private AccountDao accountDao;

    public void getUser(){
        userDao.getUser();
        accountDao.getAccountInfo();
    }

    public String addUser(){
        System.out.println("添加学生.....");

        return "添加学生完成。。。。";
    }

}
