package com.example.puppy.jobschedule;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by puppy on 1/8/2018.
 */

public class LocalWordService extends IntentService {

    private List<String> resultList = new ArrayList<String>();
    private int counter = 1;

    public LocalWordService(String name) {
        super(name);
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        addResultValues();
    }


    private void addResultValues() {
        Random random = new Random();
        List<String> input = Arrays.asList("Linux", "Android","iPhone","Windows7" );
        resultList.add(input.get(random.nextInt(3)) + " " + counter++);
        if (counter == Integer.MAX_VALUE) {
            counter = 0;
        }
        Log.e("service",resultList.size()+"::::::");

    }
}
