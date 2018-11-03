package com.example.anslo.mkulimaapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.anslo.mkulimaapp.R;

/**
 * Created by Paul Mburu on 11/1/18.
 */

public class ActivitySampleSoilDetails extends AppCompatActivity {

    public static final String EXTRA_OBJCT = "key.OBJCT";

    // give preparation animation activity transition
    public static void navigate(AppCompatActivity activity, View transitionImage, String obj) {
        Intent intent = new Intent(activity, ActivitySampleSoilDetails.class);
        intent.putExtra(EXTRA_OBJCT, obj);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, transitionImage, EXTRA_OBJCT);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_soil_details);
    }
}
