package com.example.coingekkoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.coingekkoapp.entities.Coins;

public class ResultActivity extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTV);

        Intent intent = getIntent();
        /**Here I don't know what to do*/
        if(intent.hasExtra("Result")){
            String result = intent.getStringExtra("Result");
            resultTextView.setText(result);
        }else if(intent.hasExtra("ResultSerialized")){
            /**Try to USE stringBuilder*/

            Bundle bundle = getIntent().getExtras();
            Coins coins = (Coins)bundle.getSerializable("ResultSerialized");
            resultTextView.setText(String.format("Coin name: %s\n Coin price: %s", coins.getName(), String.valueOf(coins.getCurrent_price())));
            if(intent.hasExtra("ResultSerialized1")){
                Coins coins1 = (Coins)bundle.getSerializable("ResultSerialized1");
                resultTextView.setText(String.format("Coin name: %s\n Coin price: %s", coins1.getName(), String.valueOf(coins1.getCurrent_price())));
            }else if(intent.hasExtra("ResultSerialized2")){
                Coins coins2 = (Coins)bundle.getSerializable("ResultSerialized2");
                resultTextView.setText(String.format("Coin name: %s\n Coin price: %s", coins2.getName(), String.valueOf(coins2.getCurrent_price())));
            }



        }else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }
}
