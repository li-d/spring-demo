package com.mycode.entity.xml;

public class House {

    private String name;
    private Door door;
    private Room room;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
