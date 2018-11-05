package com.example.anslo.mkulimaapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.anslo.mkulimaapp.R;

/**
 * Created by Paul Mburu on 11/5/18.
 */

public class ActivityTheDetails extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_details);

        ListView listView=(ListView)findViewById(R.id.the_details_listview);
    }
}
