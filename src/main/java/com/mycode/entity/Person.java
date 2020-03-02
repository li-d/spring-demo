package com.mycode.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {

   private String name;
   private int age;
   private Hello hell0;
   private Set<Book> bookInfos;
   private List<Integer> friendAges;
   private Map<String,Long> socres;
   private Properties properties;
   private String girlFriend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Hello getHell0() {
        return hell0;
    }

    public void setHell0(Hello hell0) {
        this.hell0 = hell0;
    }

    public Set<Book> getBookInfos() {
        return bookInfos;
    }

    public void setBookInfos(Set<Book> bookInfos) {
        this.bookInfos = bookInfos;
    }

    public List<Integer> getFriendAges() {
        return friendAges;
    }

    public void setFriendAges(List<Integer> friendAges) {
        this.friendAges = friendAges;
    }

    public Map<String, Long> getSocres() {
        return socres;
    }

    public void setSocres(Map<String, Long> socres) {
        this.socres = socres;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getGirlFriend() {
        return girlFriend;
    }

    public void setGirlFriend(String girlFriend) {
        this.girlFriend = girlFriend;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", hell0=" + hell0 +
                ", bookInfos=" + bookInfos +
                ", friendAges=" + friendAges +
                ", socres=" + socres +
                ", properties=" + properties +
                ", girlFriend='" + girlFriend + '\'' +
                '}';
    }
}
