package com.fabcode.mapascdmx;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by RGonzales on 11/15/2016.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<PlaceDataModel> dataSet;
    private Activity activity;

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView placeName;
        ImageView imageView;
        TextView lat;
        TextView lon;

        public MyViewHolder(View v) {
            super(v);
            this.placeName = (TextView) v.findViewById(R.id.placeName);
            this.imageView = (ImageView) v.findViewById(R.id.imageView);
            this.lat = (TextView) v.findViewById(R.id.lat);
            this.lon = (TextView) v.findViewById(R.id.lon);
        }
    }

    public CustomAdapter(ArrayList<PlaceDataModel> dataSet, Activity activity) {
        this.dataSet = dataSet;
        this.activity = activity;
    }

    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cards_layout, parent, false);
        view.setOnClickListener(MainActivity.myOnClickListener);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.MyViewHolder holder, int position) {
        final PlaceDataModel placeData = dataSet.get(position);
        TextView placeViewName = holder.placeName;
        ImageView imageView = holder.imageView;
        TextView latitudeView = holder.lat;
        TextView longitudeView = holder.lon;

        placeViewName.setText(dataSet.get(position).getName());
        imageView.setImageResource(dataSet.get(position).getImage());
        latitudeView.setText(String.valueOf(dataSet.get(position).getCoords().getLat()));
        longitudeView.setText(String.valueOf(dataSet.get(position).getCoords().getLon()));

        imageView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(activity, MapsActivity.class);
                intent.putExtra("latitude", placeData.getCoords().getLat());
                intent.putExtra("longitude", placeData.getCoords().getLon());
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
