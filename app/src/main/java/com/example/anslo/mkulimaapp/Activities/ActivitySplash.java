package com.example.anslo.mkulimaapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.anslo.mkulimaapp.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Paul Mburu on 10/27/18.
 */

public class ActivitySplash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                Intent i=new Intent(getApplicationContext(),ActivityMain.class);
                startActivity(i);
            }

        };
        new Timer().schedule(task,2000);

    }
}
