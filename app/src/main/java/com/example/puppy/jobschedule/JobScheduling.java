package com.example.puppy.jobschedule;

import android.app.Activity;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

/**
 * Created by puppy on 1/8/2018.
 */

public class JobScheduling {

    // schedule the start of the service every 10 - 30 seconds
    public static void scheduleJob(Context ct) {

        ComponentName sericeCpt=new ComponentName(ct,MyService.class);
        JobInfo.Builder builder=new JobInfo.Builder(0,sericeCpt);
        builder.setMinimumLatency(1000);// wait at least
        builder.setOverrideDeadline(3 * 1000); // maximum delay
       // builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED); // require unmetered network
        builder.setRequiresDeviceIdle(true); // device should be idle
        builder.setRequiresCharging(true); // we don't care if the device is charging or not
        JobScheduler jobScheduler = ((Activity)ct).getSystemService(JobScheduler.class);
        jobScheduler.schedule(builder.build());

    }
}
