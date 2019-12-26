package com.e.thirdassignment;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.e.thirdassignment.fragments.AboutFragment;
import com.e.thirdassignment.fragments.HomeFragment;
import com.e.thirdassignment.fragments.RegisterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNavigationView;
ActionBar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView=findViewById(R.id.bottomNavigationView);
        toolbar.setTitle("Home");
        bottomNavigationView.setSelectedItemId(R.id.navItemHome);
        loadFragment(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.navItemHome:
                        toolbar.setTitle("Home");
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navItemRegister:
                        toolbar.setTitle("My Gifts");
                        fragment = new RegisterFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navItemAbout:
                        toolbar.setTitle("Cart");
                        fragment = new AboutFragment();
                        loadFragment(fragment);
                        return true;

                }
                return false;
            }
        });


    }


        private void loadFragment(Fragment fragment) {
            // load fragment
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();
        }

    }

