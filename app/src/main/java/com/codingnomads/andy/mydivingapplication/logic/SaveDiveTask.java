package com.codingnomads.andy.mydivingapplication.logic;

import android.os.AsyncTask;

public class SaveDiveTask extends AsyncTask<Dive,Void,Dive> {

    private DiveService diveService;

    public SaveDiveTask(DiveService diveService) {
        this.diveService = diveService;
    }

    @Override
    protected Dive doInBackground(Dive[] dives) {
        return diveService.saveDive(dives[0]);
    }
}
