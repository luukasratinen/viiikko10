package com.example.androidohjelma2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;

public class ListUserActivity extends AppCompatActivity {

    private UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user);

        RecyclerView recyclerView = findViewById(R.id.rvUserView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lataa käyttäjälista automaattisesti
        UserStorage.getInstance().loadUsers(getApplicationContext());

        // Haetaan käyttäjät sukunimen mukaan aakkosjärjestyksessä
        ArrayList<User> sortedUsers = UserStorage.getInstance().getUsersByLastName();

        adapter = new UserListAdapter(this, sortedUsers);
        recyclerView.setAdapter(adapter);
    }
}