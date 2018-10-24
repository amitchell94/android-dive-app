package com.codingnomads.andy.mydivingapplication;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GetDivesTask extends AsyncTask<String, Void,List<Dive>> {

    private List<Dive> diveList;
    private DiveService diveService;
    private RecyclerView.Adapter mAdapter;

    public GetDivesTask(List<Dive> diveList, DiveService diveService, RecyclerView.Adapter mAdapter) {
        this.diveList = diveList;
        this.diveService = diveService;
        this.mAdapter = mAdapter;
    }

    @Override
    protected List<Dive> doInBackground(String... strings) {
        return diveService.getAllDives();
    }

    @Override
    protected void onPostExecute(List<Dive> dives) {
        super.onPostExecute(dives);
        diveList.clear();
        diveList.addAll(dives);
        mAdapter.notifyDataSetChanged();
    }
}
