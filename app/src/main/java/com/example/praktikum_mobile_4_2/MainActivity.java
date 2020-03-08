package com.example.praktikum_mobile_4_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    Fragment selectedFragment       =   new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView        =   findViewById(R.id.activitymain_bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId())
        {
            case R.id.menu_home:
                selectedFragment        =   new HomeFragment();
                break;
            case R.id.menu_person:
                selectedFragment        =   new ProfileFragment();
                break;
        }

        return loadFragment(selectedFragment);
    }

    private boolean loadFragment(Fragment selectedFragment) {
        if(selectedFragment != null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.activitymain_container,selectedFragment).commit();
        }
        return false;
    }
}
