package com.e.thirdassignment.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.thirdassignment.Model.User;
import com.e.thirdassignment.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.Viewholder>{
Context context;
List<User>users;

    public UserAdapter(Context context,List<User> users) {
        this.context=context;
        this.users = users;
    }
    public void AddData(List<User> users) {
        //Log.d("notifyData ", myList.size() + "");


        this.users = users;

        notifyDataSetChanged();
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
    public void onBindViewHolder(@NonNull Viewholder holder, final int position) {
        //attaching data one by one
        final User user=users.get(position);
        holder.imageView.setImageResource(user.getImgId());
        holder.name.setText(user.getName());
        holder.address.setText(user.getAddress());
        holder.age.setText(user.getAge()+"");
        holder.imgDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                users.remove(position);
                notifyItemRemoved(position);

            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "This is "+user.getName(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder
    {
        ImageView imageView,imgDel;
        TextView name, address, age;
        public Viewholder(@NonNull View itemView)
        {
            super(itemView);
            imgDel=itemView.findViewById(R.id.imgDel);
            imageView=itemView.findViewById(R.id.imageView);
            name=itemView.findViewById(R.id.name);
            address=itemView.findViewById(R.id.address);
            age=itemView.findViewById(R.id.age);
        }
    }

}
