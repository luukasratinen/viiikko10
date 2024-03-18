package com.example.androidohjelma2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;



public class AddUserActivity extends AppCompatActivity {

    private EditText editFirstName, editLastName, editEmail;
    private RadioGroup radioDegreeProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        radioDegreeProgram = findViewById(R.id.radioDegreeProgram);

    }



    public void addUser(View view) {


        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String email = editEmail.getText().toString();


        int selectedRadioButtonId = radioDegreeProgram.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonId);
        String degreeProgram = selectedRadioButton.getText().toString();



        User user = new User(firstName, lastName, email, degreeProgram);

        UserStorage.getInstance().addUser(user);

        finish(); //toimiskohan tää


        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}