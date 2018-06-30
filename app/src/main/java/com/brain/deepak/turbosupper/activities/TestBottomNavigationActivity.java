package com.brain.deepak.turbosupper.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.brain.deepak.turbosupper.R;
import com.brain.deepak.turbosupper.fragments.ExampleFragment;

public class TestBottomNavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;

    private int lastSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_bottom_navigation);

        lastSelected = R.id.message;    // basically dummied out

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.testNav_fragmentWindow, ExampleFragment.newInstance("uwu"));
        fragmentTransaction.commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() != lastSelected) {
            lastSelected = item.getItemId();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fragmentTransaction.replace(R.id.testNav_fragmentWindow, ExampleFragment.newInstance("Home"));
                    fragmentTransaction.commit();
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    fragmentTransaction.replace(R.id.testNav_fragmentWindow, ExampleFragment.newInstance("Dashboard"));
                    fragmentTransaction.commit();
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
            }
        }
        return false;
    }

}
