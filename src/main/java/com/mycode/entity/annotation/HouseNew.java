package com.mycode.entity.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

public class HouseNew {


    @Value("HouseNew name")
    private String name;

    @Resource
    private Door ctt;
    @Resource
    private Room room;

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", doorInfo=" + ctt.doorInfo() +
                ", roomInfo=" + room.roomInfo() +
                '}';
    }
}
