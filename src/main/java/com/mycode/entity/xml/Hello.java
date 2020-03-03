package com.mycode.entity.xml;

public class Hello {

    private String desc;

    public String getDesc() {
        return desc;
    }

    //要有set方法进行依赖注入
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Hello() {
        System.out.println("Hello 对象被创建");
    }

    @Override
    public String toString() {
        return "Hello{" +
                "desc='" + desc + '\'' +
                '}';
    }


}
