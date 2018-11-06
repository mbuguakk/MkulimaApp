package com.example.anslo.mkulimaapp.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.anslo.mkulimaapp.Data.Constant;
import com.example.anslo.mkulimaapp.Data.Crop;
import com.example.anslo.mkulimaapp.R;

import java.util.List;

/**
 * Created by Paul Mburu on 11/5/18.
 */

public class ActivityTheDetails extends AppCompatActivity {

    public static final String EXTRA_OBJCT="key.OBJCT";

    // give preparation animation activity transition
    public static void navigate(AppCompatActivity activity, View transitionImage, Crop obj) {
        Intent intent = new Intent(activity, ActivityTheDetails.class);
        intent.putExtra(EXTRA_OBJCT, obj.getCropName());
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_OBJCT);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_details);

        // get extra object
        String cropName = (String) getIntent().getSerializableExtra(EXTRA_OBJCT);

        ListView listView=(ListView)findViewById(R.id.the_details_listview);
        List<String> items;
        ArrayAdapter<String> adapter;
        if(cropName.equals("Oranges")){
            items= Constant.getOrangeDetails(getBaseContext());
            adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
            listView.setAdapter(adapter);
        }else if(cropName.equals("Tomatoes")){
            items= Constant.getTomatoesDetails(getBaseContext());
            adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
            listView.setAdapter(adapter);
        }else if(cropName.equals("Tomatoes")){
            items= Constant.getOnionDetails(getBaseContext());
            adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
            listView.setAdapter(adapter);
        }else if(cropName.equals("Sunflower")){
            items= Constant.getSunflowerDetails(getBaseContext());
            adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
            listView.setAdapter(adapter);
        }else if(cropName.equals("Cabbage")){
            items= Constant.getCabbageDetails(getBaseContext());
            adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items);
            listView.setAdapter(adapter);
        }
    }
}
