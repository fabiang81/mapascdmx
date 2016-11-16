package com.fabcode.mapascdmx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static RecyclerView.Adapter adapter;
    private static RecyclerView recyclerView;
    private static ArrayList<PlaceDataModel> data;
    static View.OnClickListener myOnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        GridLayoutManager glm = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(glm);

        data = new ArrayList<>();
        for(int i=0; i<MyData.nameArray.length; i++){
            data.add(new PlaceDataModel(
                    MyData.nameArray[i],
                    MyData.drawableArray[i],
                    MyData.coordsArray[i]
            ));
        }

        adapter = new CustomAdapter(data, this);
        recyclerView.setAdapter(adapter);

    }

}
