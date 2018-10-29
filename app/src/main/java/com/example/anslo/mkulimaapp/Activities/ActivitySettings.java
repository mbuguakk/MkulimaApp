package com.example.anslo.mkulimaapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.anslo.mkulimaapp.R;

/**
 * Created by anslo on 10/30/18.
 */

public class ActivitySettings extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initToolbar();
    }
    private void initToolbar(){
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbr);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Settings");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

    }
}
