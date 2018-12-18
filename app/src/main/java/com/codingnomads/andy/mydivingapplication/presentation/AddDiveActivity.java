package com.codingnomads.andy.mydivingapplication.presentation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import com.codingnomads.andy.mydivingapplication.R;
import com.codingnomads.andy.mydivingapplication.data.DiveRepository;
import com.codingnomads.andy.mydivingapplication.logic.Dive;
import com.codingnomads.andy.mydivingapplication.logic.DiveService;
import com.codingnomads.andy.mydivingapplication.logic.SaveDiveTask;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class AddDiveActivity extends AppCompatActivity {
    private DiveService diveService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dive);
    }

    public void addNewDive (View view) {
        Dive dive = getDiveInputs();

        diveService = new DiveService(new DiveRepository(createRestTemplate()));

        SaveDiveTask saveDiveTask = new SaveDiveTask(diveService);

        saveDiveTask.execute(dive);

        startActivity(new Intent(AddDiveActivity.this,DiveActivity.class));
    }

    @NonNull
    private Dive getDiveInputs() {
        Dive dive = new Dive();

        EditText location = findViewById(R.id.location_input);
        EditText date = findViewById(R.id.date_input);
        EditText duration = findViewById(R.id.duration_in_minutes_input);
        EditText depth = findViewById(R.id.max_depth_in_meters_input);
        EditText waterConditions = findViewById(R.id.water_conditions_input);
        CheckBox performedSafetyStop = findViewById(R.id.performed_safety_stop_input);

        dive.setLocation(location.getText().toString());
        dive.setDate(date.getText().toString());
        dive.setDurationInMinutes(Integer.parseInt(duration.getText().toString()));
        dive.setMaxDepthInMeters(Double.parseDouble(depth.getText().toString()));
        dive.setWaterConditions(waterConditions.getText().toString());
        dive.setPerformedSafetyStop(performedSafetyStop.isChecked());
        return dive;
    }

    private RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        return restTemplate;
    }
}
