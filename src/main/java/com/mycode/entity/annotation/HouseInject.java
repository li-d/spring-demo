package com.mycode.entity.annotation;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

public class HouseInject {

    @Value("HouseInject name")
    private String name;
    private Door door;
    private Room room;

    @Inject
    public HouseInject(Door door, @Named("2room2") Room room) {
        this.door = door;
        this.room = room;
    }

    public HouseInject() {

    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", doorInfo=" + door.doorInfo() +
                ", roomInfo=" + room.roomInfo() +
                '}';
    }
}
