package com.example.androidohjelma2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;

    private ArrayList<User> users;


    public UserListAdapter(Context context, ArrayList<User> users) {

        this.context = context;
        this.users = users;


    }


    public void updateUserList(ArrayList<User> users) {
        this.users = users;

        notifyDataSetChanged();

    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.userview, parent, false));

    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        User user = users.get(position);
        holder.FirstName.setText(user.getFirstName());
        holder.LastName.setText(user.getLastName());
        holder.Email.setText(user.getEmail());
        holder.DegreeProgram.setText(user.getDegreeProgram());


    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}