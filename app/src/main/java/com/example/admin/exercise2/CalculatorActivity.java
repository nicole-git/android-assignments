package com.example.admin.exercise2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends Activity {

    boolean switcher;

    final int RANDOM_NUM_1 = 1;
    final int RANDOM_NUM_2 = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        final TextView textView1 = (TextView) findViewById(getResources().getIdentifier("number1", "id", getPackageName()));
        final TextView textView2 = (TextView) findViewById(getResources().getIdentifier("number2", "id", getPackageName()));
        final EditText answerEdit = (EditText) findViewById(getResources().getIdentifier("answerEdit", "id", getPackageName()));
        final EditText upperLimitEdit = (EditText) findViewById(getResources().getIdentifier("upperLimitEdit", "id", getPackageName()));

        Button addButton = (Button) findViewById(getResources().getIdentifier("addButton", "id", getPackageName()));
        addButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int number1 = Integer.parseInt(textView1.getText().toString());
                int number2 = Integer.parseInt(textView2.getText().toString());
                int answer = Integer.parseInt(answerEdit.getText().toString());
                int upperLimit = Integer.parseInt(upperLimitEdit.getText().toString());
                int sum = number1 + number2;
                if (answer == sum) {
                    Toast.makeText(getBaseContext(), getString(R.string.correct), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), getString(R.string.wrong) + sum, Toast.LENGTH_SHORT).show();
                }
                Intent startIntent = new Intent("android.intent.action.RANDOM_NUMBER");
                startIntent.putExtra("upper_limit", upperLimit);
                startActivityForResult(startIntent, RANDOM_NUM_1);
                startActivityForResult(startIntent, RANDOM_NUM_2);
            }
        });

        Button multiplicationButton = (Button) findViewById(getResources().getIdentifier("multiplicationButton", "id", getPackageName()));
        multiplicationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number1 = Integer.parseInt(textView1.getText().toString());
                int number2 = Integer.parseInt(textView2.getText().toString());
                int answer = Integer.parseInt(answerEdit.getText().toString());
                int upperLimit = Integer.parseInt(upperLimitEdit.getText().toString());
                int product = number1 * number2;
                if (answer == product) {
                    Toast.makeText(getBaseContext(), getString(R.string.correct), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), getString(R.string.wrong) + product, Toast.LENGTH_SHORT).show();
                }
                Intent startIntent = new Intent("android.intent.action.RANDOM_NUMBER");
                startIntent.putExtra("upper_limit", upperLimit);
                startActivityForResult(startIntent, RANDOM_NUM_1);
                startActivityForResult(startIntent, RANDOM_NUM_2);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RANDOM_NUM_1 && resultCode == RESULT_OK) {
            final TextView textView1 = (TextView) findViewById(getResources().getIdentifier("number1", "id", getPackageName()));
            textView1.setText(data.getStringExtra("random"));
        }
        if (requestCode == RANDOM_NUM_2 && resultCode == RESULT_OK) {
            final TextView textView2 = (TextView) findViewById(getResources().getIdentifier("number2", "id", getPackageName()));
            textView2.setText(data.getStringExtra("random"));
        }
    }
}
