package com.mycode.entity.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class House {


    @Value("House name")
    private String name;

    @Autowired(required = false)
    @Qualifier(value="ctt")
    private Door door;

    @Autowired
    private Room room;

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", doorInfo=" + door.doorInfo() +
                ", roomInfo=" + room.roomInfo() +
                '}';
    }
}
