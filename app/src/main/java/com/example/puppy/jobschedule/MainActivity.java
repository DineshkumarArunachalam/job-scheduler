package com.example.puppy.jobschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.firebase.jobdispatcher.Constraint;
import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.firebase.jobdispatcher.Lifetime;
import com.firebase.jobdispatcher.Trigger;

public class MainActivity extends AppCompatActivity {

    int i= 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create a new dispatcher using the Google Play driver.
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(MainActivity.this));

        Toast.makeText(MainActivity.this,"intial....",Toast.LENGTH_LONG).show();

        ++i;
        Job myJob = dispatcher.newJobBuilder()
                // the JobService that will be called
                .setService(MyService.class)
                // uniquely identifies the job
                .setTag("my-unique-tag"+i)
                // one-off job
                .setRecurring(true)
                // don't persist past a device reboot
                .setLifetime(Lifetime.UNTIL_NEXT_BOOT)
                // start between 0 and 60 seconds from now
                .setTrigger(Trigger.executionWindow(0, 0))
                // don't overwrite an existing job with the same tag
                .setReplaceCurrent(false)

                // constraints that need to be satisfied for the job to run
                .setConstraints(

                        // only run when the device is charging
                        Constraint.DEVICE_CHARGING

                )

                .build();

        dispatcher.mustSchedule(myJob);
    }
}
