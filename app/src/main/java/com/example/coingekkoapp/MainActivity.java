package com.example.coingekkoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import com.example.coingekkoapp.entities.CoinsMain;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private Button btnChoose;
    private Spinner mainSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChoose = findViewById(R.id.btnChoose);
        mainSpinner = findViewById(R.id.mainSpinner);

        btnChoose.setOnClickListener(v -> {
            NetworkService networkService = NetworkService.getInstance();
            Call<CoinsMain> call = networkService.getApiGekko()
                    /**Здесь застрял по полной программе*/
                    .getCoins(mainSpinner.toString())
        });
    }
}
