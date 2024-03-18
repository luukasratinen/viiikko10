package com.example.androidohjelma2;

import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> userList;

    private static UserStorage instance;

    private UserStorage() {
        userList = new ArrayList<>();
    }

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public ArrayList<User> getUsers() {
        return userList;
    }
}