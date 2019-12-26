package com.e.thirdassignment.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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
                Validate();
                int id = radioGender.getCheckedRadioButtonId();

                radioButton =view.findViewById(id);

                String gender =radioButton.getText().toString();

                if(gender.equals("Male")) {
                    HomeFragment.users.add(new User(etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), etAddress.getText().toString(), R.drawable.male));
                }
                else if(gender.equals("Female")) {
                    HomeFragment.users.add(new User(etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), etAddress.getText().toString(), R.drawable.female));
                }
                else {
                    HomeFragment.users.add(new User(etName.getText().toString(), Integer.parseInt(etAge.getText().toString()), etAddress.getText().toString(), R.drawable.others));
                }
                Toast.makeText(getContext(), "User Added", Toast.LENGTH_SHORT).show();




            }
        });

        return view;

    }
    private  void Validate(){
        if(TextUtils.isEmpty(etName.getText())){
            etName.setError("Enter your name");
            etName.requestFocus();
            return;
        }else if(TextUtils.isEmpty(etAddress.getText())){
            etAddress.setError("Please enter address");
            etAddress.requestFocus();
            return;
        }else if(TextUtils.isEmpty(etAge.getText())){
            etAge.setError("Please enter age");
            etAge.requestFocus();
            return;
        }
    }

}
