package com.example.admin.exercise2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Random;

public class RandomNumberActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent startIntent = getIntent();
        int upperLimit = startIntent.getIntExtra("upper_limit", 10);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("random", getRandomNumberAsString(upperLimit));
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    private String getRandomNumberAsString(int upperLimit) {
        return String.valueOf(new Random().nextInt(upperLimit));
    }


}
