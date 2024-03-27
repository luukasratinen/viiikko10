package com.example.androidohjelma2;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserStorage {

    private ArrayList<User> userList;
    private static UserStorage instance;
    private static final String FILENAME = "users.data";

    private UserStorage() {
        userList = new ArrayList<>();
    }

    public static synchronized UserStorage getInstance(Context context) {
        if (instance == null) {
            instance = new UserStorage();
            instance.loadUsers(context);
        }
        return instance;
    }

    public void addUser(Context context, User user) {
        userList.add(user);
        saveUsers(context);
    }

    public ArrayList<User> getUsers() {
        return userList;
    }

    public void listUsers() {
        int i = 0;
        for (User user : userList) {
            System.out.println(i++ + ": " + user.getLastName());
        }
    }

    public void listUsersInformation() {
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    public void saveUsers(Context context) {
        try {
            FileOutputStream fileOutputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadUsers(Context context) {
        try {
            FileInputStream fileInputStream = context.openFileInput(FILENAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            userList = (ArrayList<User>) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsersByLastName() {
        Collections.sort(userList, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getLastName().compareTo(user2.getLastName());
            }
        });
        return userList;
    }
}