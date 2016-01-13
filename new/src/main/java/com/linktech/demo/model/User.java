package com.linktech.demo.model;

/**
 * Created by 飞 on 2015/12/16.
 */
public class User {
    public String name;
    public int age;
    public String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {

        return age;
    }

    public String getEmail() {
        return email;
    }
}
