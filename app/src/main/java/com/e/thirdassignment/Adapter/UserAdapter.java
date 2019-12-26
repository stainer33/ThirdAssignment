package com.e.thirdassignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.thirdassignment.Model.User;
import com.e.thirdassignment.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.Viewholder>{

List<User>users;

    public UserAdapter(List<User> users) {

        this.users = users;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //attaching layout
        View view = LayoutInflater.from(parent.getContext())
                .inflate((R.layout.recycle_layout),parent, false);
        return  new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        //attaching data one by one
        User user=users.get(position);
        holder.imageView.setImageResource(user.getImgId());
        holder.name.setText(user.getName());
        holder.address.setText(user.getAddress());
        holder.age.setText(user.getAge()+"");

    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
        TextView name, address, age;
        public Viewholder(@NonNull View itemView)
        {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.name);
            address=itemView.findViewById(R.id.address);
            age=itemView.findViewById(R.id.age);
        }
    }
    public void notifyData(List<User> users) {
        //Log.d("notifyData ", myList.size() + "");
        this.users = users;

        notifyDataSetChanged();
    }
}
