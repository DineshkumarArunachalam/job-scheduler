package com.example.puppy.jobschedule;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

/**
 * Created by puppy on 1/8/2018.
 */

public class MyService extends JobService {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        Intent service = new Intent(getApplicationContext(), LocalWordService.class);
        getApplicationContext().startService(service);
        JobScheduling.scheduleJob(getApplicationContext());
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
