package com.codingnomads.andy.mydivingapplication.presentation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.codingnomads.andy.mydivingapplication.data.DiveAdapter;
import com.codingnomads.andy.mydivingapplication.data.DiveRepository;
import com.codingnomads.andy.mydivingapplication.logic.DiveService;
import com.codingnomads.andy.mydivingapplication.logic.GetDivesTask;
import com.codingnomads.andy.mydivingapplication.R;
import com.codingnomads.andy.mydivingapplication.logic.Dive;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

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
        mAdapter = new DiveAdapter(diveList);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        DiveService diveService = new DiveService(new DiveRepository(createRestTemplate()));

        mRecyclerView.setAdapter(mAdapter);

        GetDivesTask getDivesTask = new GetDivesTask(diveList,diveService,mAdapter);

        getDivesTask.execute();

    }


    private RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        return restTemplate;
    }

    public void addDive(View view) {
        startActivity(new Intent(DiveActivity.this,AddDiveActivity.class));
    }

}
