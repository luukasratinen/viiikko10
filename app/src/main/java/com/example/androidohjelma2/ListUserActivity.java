package com.example.androidohjelma2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class ListUserActivity extends AppCompatActivity {


    private UserListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_user_in_recycle_view);

        RecyclerView recyclerView = findViewById(R.id.rvUserView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserListAdapter(this, UserStorage.getInstance().getUsers());
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onResume() {

        super.onResume();
        //toimiskohan tää täs
        adapter.updateUserList(UserStorage.getInstance().getUsers());
    }
}