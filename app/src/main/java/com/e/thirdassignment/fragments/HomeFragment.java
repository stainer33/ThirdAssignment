package com.e.thirdassignment.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.thirdassignment.Adapter.UserAdapter;
import com.e.thirdassignment.Model.LIstData;
import com.e.thirdassignment.Model.User;
import com.e.thirdassignment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {



      RecyclerView recyclerView;
    UserAdapter userAdapter;
    public   List<User> users=new ArrayList<>();
   // List<User> users=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_home, container, false);
       recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView);


        LIstData listData = new LIstData();
        listData.setUsers(users);

        users.add(new User("Pasang Sherpa",33,"New York",R.drawable.male));
        users.add(new User("Puja Shah",33,"New York",R.drawable.female));
        users.add(new User("Saroj Tamang",33,"New York",R.drawable.others));
        // Inflate the layout for this fragment
       userAdapter = new UserAdapter(users);
        recyclerView.setAdapter(userAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
