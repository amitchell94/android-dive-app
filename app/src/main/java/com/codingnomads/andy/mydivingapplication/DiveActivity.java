package com.codingnomads.andy.mydivingapplication;

import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DiveActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Dive> diveList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dive);
        mRecyclerView = findViewById(R.id.dive_recycler_view);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new DiveAdapter(diveList);
        mRecyclerView.setAdapter(mAdapter);

        prepareDiveData();
    }

    public void prepareDiveData(){
        Dive dive1 = new Dive();
        dive1.setDate("2018-03-03");
        dive1.setDurationInMinutes(12);
        dive1.setLocation("The Pit");
        dive1.setMaxDepthInMeters(24);
        dive1.setPerformedSafetyStop(true);
        dive1.setWaterConditions("bad");

        diveList.add(dive1);

        dive1 = new Dive();
        dive1.setDate("2018-02-02");
        dive1.setDurationInMinutes(12);
        dive1.setLocation("Dos Ojos");
        dive1.setMaxDepthInMeters(24);
        dive1.setPerformedSafetyStop(true);
        dive1.setWaterConditions("bad");

        diveList.add(dive1);
    }
}
