package com.example.homework9comp181;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.homework9comp181.MainActivity;

public class SecondActivity1 extends AppCompatActivity {

    private TextView total_textview;
    private Button home_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        total_textview = findViewById(R.id.total_textview);
        home_button = findViewById(R.id.home_button);

        // i need to receive the intent and get the data that was sent with the intent
        Intent intent = getIntent();
        double total = intent.getDoubleExtra("total", 0); // When getting an int from the intent
        // in case there is nothing sent over, you need a default value




        // set the display string as the text for the text view
        total_textview.setText("$" + String.valueOf(total));

        home_button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                launchNextActivity(v);






            }
        });

    }



    private void launchNextActivity(View view){
        // create an Intent that explicitly says that I want to go to second activity
        Intent second_intent = new Intent(this, MainActivity.class);// from, to
        startActivity(second_intent);
    }
}