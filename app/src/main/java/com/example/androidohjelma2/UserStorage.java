
package com.example.androidohjelma2;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;

public class UserStorage {

    private ArrayList<User> userList;
    private static UserStorage instance;

    private static final String FILENAME = "users.data";


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


    public ArrayList<User> getUsersByLastName() {
        ArrayList<User> sortedUsers = new ArrayList<>(userList);
        sortedUsers.sort(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getLastName().compareTo(user2.getLastName());
            }


        });

        return sortedUsers;
    }



    public void saveUsers(Context context) {

        try {
            FileOutputStream fileOutputStream = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
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

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}