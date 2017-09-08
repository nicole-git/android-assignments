package com.example.admin.exercise2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    final int RANDOM_NUMBER_ACTIVITY_ID = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toast.makeText(getBaseContext(), "Hello", Toast.LENGTH_SHORT).show();

        Button button = (Button) findViewById(getResources().getIdentifier("random_number_button", "id", getPackageName()));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent("android.intent.action.RANDOM_NUMBER"), RANDOM_NUMBER_ACTIVITY_ID);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RANDOM_NUMBER_ACTIVITY_ID && resultCode == RESULT_OK) {
            TextView tvId = (TextView) findViewById(R.id.textView);
            tvId.setText("Your random number is: " + data.getStringExtra("random"));
        }
    }

}
