package com.e.thirdassignment.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.e.thirdassignment.Adapter.UserAdapter;
import com.e.thirdassignment.MainActivity;
import com.e.thirdassignment.Model.LIstData;
import com.e.thirdassignment.Model.User;
import com.e.thirdassignment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }

    EditText etName, etAge, etAddress;
    RadioGroup radioGender;
    RadioButton radioButton;
    Button btnSave;
    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view =inflater.inflate(R.layout.fragment_register, container, false);
        etName=view.findViewById(R.id.etName);
        etAddress=view.findViewById(R.id.etAddress);
        etAge=view.findViewById(R.id.etAge);
        radioGender=view.findViewById(R.id.radioGender);
        btnSave=view.findViewById(R.id.btnSave);
        recyclerView=(RecyclerView) view.findViewById(R.id.recyclerView);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = radioGender.getCheckedRadioButtonId();

                radioButton =view.findViewById(id);

                String gender =radioButton.getText().toString();
                Toast.makeText(getContext(), gender, Toast.LENGTH_SHORT).show();
                List<User> users=new ArrayList<>();
                HomeFragment homeFragment=new HomeFragment();
                homeFragment.users.add(new User("Johan Bach",33,"New York",R.drawable.male));
                users.add(new User("Johan Bach",33,"New York",R.drawable.male));
                LIstData listData = new LIstData();
                listData.setUsers(users);

               // homeFragment.users.add(users);
               UserAdapter userAdapter = new UserAdapter(users);
               userAdapter.notifyData(users);

             //   Toast.makeText(MainActivity.class, "", Toast.LENGTH_SHORT).show();

            }
        });

        return view;

    }

}
