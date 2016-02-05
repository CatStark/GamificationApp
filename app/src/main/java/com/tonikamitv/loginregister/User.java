package com.tonikamitv.loginregister;

public class User {

    String name, username, password, knowlanguage, wantlanguage, interests;
    int age;

   /* public User(String name, int age, String username, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }*/

    public User(String name, int age, String username, String password, String knowlanguage, String wantlanguage, String interests) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.knowlanguage = knowlanguage;
        this.wantlanguage = wantlanguage;
        this.interests = interests;
    }

    public User(String username, String password) {
        this("", -1, username, password, "", "", "");
    }
}
