package com.mycode.service;

public class BookService {

    public String add(String name, Double price) {
        if(name == null){
            throw new RuntimeException("书名不能为空");
        }


        System.out.println("添加书籍.....");

        return "添加书籍完成....";
    }

    public void show(){
        System.out.println("显示所有书籍");
    }
}
