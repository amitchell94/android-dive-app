package com.codingnomads.andy.mydivingapplication;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class DiveAdapter extends RecyclerView.Adapter<DiveAdapter.MyViewHolder> {
    private List<Dive> diveList;

    public DiveAdapter(List<Dive> diveList) {
        this.diveList = diveList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView location, date, duration_in_minutes,
                max_depth_in_meters, water_conditions, performed_safety_stop;
        public MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.fish);
            location = view.findViewById(R.id.location);
            date = view.findViewById(R.id.date);
            duration_in_minutes = view.findViewById(R.id.duration_in_minutes);
            max_depth_in_meters = view.findViewById(R.id.max_depth_in_meters);
            water_conditions = view.findViewById(R.id.water_conditions);
            performed_safety_stop = view.findViewById(R.id.performed_safety_stop);
        }
    }

    @Override
    public DiveAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dive_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        Dive dive = diveList.get(position);
//        Picasso.get().load(R.drawable.fish)
//                .into(holder.imageView);
        Picasso.get()
                .load("https://4.bp.blogspot.com/-GKLQoOOvVNQ/VbuWoDSD0zI/AAAAAAAAKvg/I0lc-gxKbKs/s1600/38-dos-ojos-cenote-review-ojo-uno.jpg")
                .into(holder.imageView);
        //holder.imageView.setImageResource(R.drawable.fish);
        holder.location.setText(dive.getLocation());
        holder.date.setText(dive.getDate());
        holder.duration_in_minutes.setText(Integer.toString(dive.getDurationInMinutes()) + " mins");
        holder.max_depth_in_meters.setText("Max depth: " + Double.toString(dive.getMaxDepthInMeters()) + " m");
        holder.water_conditions.setText("Water conditions: " + dive.getWaterConditions());
        holder.performed_safety_stop.setText("Performed safety stop: " + Boolean.toString(dive.isPerformedSafetyStop()));
    }

    @Override
    public int getItemCount() {
        return diveList.size();
    }

}
