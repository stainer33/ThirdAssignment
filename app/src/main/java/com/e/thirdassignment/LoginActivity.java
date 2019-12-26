package com.e.thirdassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
Button btnSave;
EditText etUserName,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               validation();



                if(etUserName.getText().toString().equals("softwarica") && etPassword.getText().toString().equals("coventry"))
                {
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    private void validation()
    {
        if(TextUtils.isEmpty(etUserName.getText()))
        {
            etUserName.setError("Enter username");
            return;
        }
        else if(TextUtils.isEmpty(etPassword.getText()))
        {
            etPassword.setError("Enter username");
            return;
        }
    }
}
