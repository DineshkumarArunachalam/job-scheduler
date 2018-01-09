package com.example.puppy.jobschedule;

import android.app.job.JobScheduler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JobScheduling.scheduleJob(MainActivity.this);
    }
}
