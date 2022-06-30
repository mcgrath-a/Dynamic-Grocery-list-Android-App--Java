package com.example.homework9comp181;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private itemListAdapter itemListAdapter;


    private RecyclerView recyclerView;
    private Button add_button;
    private Button calculate_button;
    public static EditText textInput;
    public static EditText priceInput;

    static ArrayList<String> items = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    double total = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



       List<String> items = new LinkedList<>();




        add_button = findViewById(R.id.add_button);
        calculate_button = findViewById(R.id.calculate_button);
        textInput = findViewById(R.id.textInput);
        priceInput = findViewById(R.id.priceInput);


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemListAdapter adapter = new itemListAdapter(items);
        recyclerView.setAdapter(adapter);

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = textInput.getText().toString().trim();
                String price = priceInput.getText().toString().trim();

                if (text == null || text.length() == 0 || price == null || price.length() == 0) {
                    makeToast("Enter in both fields");

                } else if (!price.matches("[0-9.]+")) {
                    makeToast("Enter only digits for price");

                } else {
                    items.add((text));
                    adapter.notifyItemInserted(items.size() - 1);

                    textInput.setText("");
                    priceInput.setText("");
                    makeToast("Added " + text);


                    Double new_price = Double.parseDouble(price);
                    addPrice(new_price);

                    totalPrices(prices);
                    Log.d("Total:", new_price + "");








                }

            }
        });

        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                for (int i = 0; i < prices.size(); i++)
                    if (prices.get(i) != null) {
                        total = total + prices.get(i);
                    }
                prices.clear();
                Log.d("calculate:", total + "");
                launchNextActivity(v);








            }
        });


    }
    //add item

    //remove item


    //removing prices
    public static void addPrice(Double new_price) {
        prices.add(new_price);
        Log.d("Total:", prices + "");

    }

    public static void removePrice(int remove) {
        prices.remove(remove);

    }

    public static double totalPrices(ArrayList<Double> prices) {
        double total = 0;
        for (int i = 0; i < prices.size(); i++)
            if (prices.get(i) != null) {
                total = total + prices.get(i);
            }
        return total;
    }


    Toast t;

    private void makeToast(String s) {
        if (t != null) t.cancel();
        t = Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG);

        t.show();
    }

    private void launchNextActivity(View view) {
        // create an Intent that explicitly says that I want to go to second activity
        Intent second_intent = new Intent(this, SecondActivity1.class);// from, to
      second_intent.putExtra("total", total);
        startActivity(second_intent);



    }




//shared prefernces
    }
