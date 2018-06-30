package com.brain.deepak.turbosupper.activities.debug;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.brain.deepak.turbosupper.BuildConfig;
import com.brain.deepak.turbosupper.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DebugSelectActivity extends AppCompatActivity {

    private final String PACKAGE_NAME_WITH_DOT = BuildConfig.APPLICATION_ID + ".";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug_select);

        populate();
    }

    private String[] getActivityList() throws PackageManager.NameNotFoundException {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_LAUNCHER);
        PackageManager pm = this.getPackageManager();

        PackageInfo info = pm.getPackageInfo(getApplicationContext().getPackageName(), PackageManager.GET_ACTIVITIES);

        ApplicationInfo test = info.applicationInfo;
        ActivityInfo[] list = info.activities;

        ArrayList<String> names = new ArrayList<>();
        for (int x = 0; x < list.length; x++) {
            if (list[x].toString().contains(PACKAGE_NAME_WITH_DOT)) {
                String newClassName = list[x].toString().substring(list[x].toString().indexOf(PACKAGE_NAME_WITH_DOT) + PACKAGE_NAME_WITH_DOT.length(), list[x].toString().length() - 1);
                names.add(newClassName);
            }
        }
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            }
        });

        return names.toArray(new String[names.size()]);
    }

    private void populate() {
        try {
            String[] classNames = getActivityList();
            LinearLayout list = findViewById(R.id.debugSelect_buttonList);
            for (final String name : classNames) {
                Button button = new Button(this);
                button.setTransformationMethod(null);
                list.addView(button);
                button.setText(name);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivityButton(name);
                    }
                });
            }
        } catch (PackageManager.NameNotFoundException e) {
            //Toast.makeText(MainActivity.getCurrentApplicationContext(), "could not load activity list", Toast.LENGTH_LONG).show();
        }
    }

    private void startActivityButton(String className) {
        String activityToStart = PACKAGE_NAME_WITH_DOT + className;
        try {
            Class<?> c = Class.forName(activityToStart);
            Intent intent = new Intent(this, c);
            startActivity(intent);
        } catch (ClassNotFoundException ignored) {
            //Toast.makeText(MainActivity.getCurrentApplicationContext(), "Invalid class name: " + className, Toast.LENGTH_SHORT).show();
        }
    }
}
