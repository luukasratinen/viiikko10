package com.example.androidohjelma2;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView FirstName, LastName, Email, DegreeProgram;

    public UserViewHolder(View itemView) {
        super(itemView);
        FirstName = itemView.findViewById(R.id.textFirstName);
        LastName = itemView.findViewById(R.id.textLastName);
        Email = itemView.findViewById(R.id.textEmail);
        DegreeProgram = itemView.findViewById(R.id.textDegreeProgram);
    }
}