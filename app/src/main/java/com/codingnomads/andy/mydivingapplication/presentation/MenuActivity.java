package com.codingnomads.andy.mydivingapplication.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.codingnomads.andy.mydivingapplication.R;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void viewDives(View view) {
        startActivity(new Intent(MenuActivity.this,DiveActivity.class));
    }
    public void addDive(View view) {
        startActivity(new Intent(MenuActivity.this,AddDiveActivity.class));
    }
}
