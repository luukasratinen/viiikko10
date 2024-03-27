package com.example.androidohjelma2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToAddUser(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void switchToListUser(View view) {
        Intent intent = new Intent(this, ListUserActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Lataa käyttäjälista automaattisesti
        UserStorage.getInstance().loadUsers(getApplicationContext());
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Tallenna käyttäjälista automaattisesti
        UserStorage.getInstance().saveUsers(getApplicationContext());
    }
}