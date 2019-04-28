package com.example.coingekkoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;

import com.example.coingekkoapp.entities.Coins;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

            /**We can not create an object of NetworkService class
             * because it is a SingleTon pattern class*/
            //NetworService networkService = new NetworkService()
            NetworkService networkService = NetworkService.getInstance();
            if(mainSpinner.getSelectedItem().toString().contains("Top 3")){
                Call<List<Coins>> call = networkService.getApiGekko()
                        /**Здесь застрял по полной программе*/
                        .getCoins("btc", 3);


                /**Enqueue - is asynchronous method, which requires CALLBACK*/
                call.enqueue(new Callback<List<Coins>>() {
                    @Override
                    public void onResponse(Call<List<Coins>> call, Response<List<Coins>> response) {
                        Log.i("myTag", "in onResponse");
                        Intent intent = new Intent(btnChoose.getContext(), ResultActivity.class);
                        intent.putExtra("Result", response.toString());
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<List<Coins>> call, Throwable t) {
                        Log.i("myTag", "in onFailure" + t.getMessage() + call.toString());
                    }
                });

            }else if(mainSpinner.getSelectedItem().toString().contains("Top 1")){
                Call<List<Coins>> call = networkService.getApiGekko()
                        .getCoins("btc", 1);

                /**Enqeue - is asynchronous method, which requires CALLBACK*/
                call.enqueue(new Callback<List<Coins>>() {
                    @Override
                    public void onResponse(Call<List<Coins>> call, Response<List<Coins>> response) {
                        Intent intent = new Intent(btnChoose.getContext(), ResultActivity.class);
                        intent.putExtra("Result", response.toString());
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<List<Coins>> call, Throwable t) {
                        Log.i("myTag", "in onFailure" + t.getMessage() + call.toString());
                    }
                });

            }else if(mainSpinner.getSelectedItem().toString().contains("Least 3")){
                Call<List<Coins>> call = networkService.getApiGekko()
                        .getCoinsLeast("btc", 3, "market_cap_asc");

                /**Execute - is SYNCHRONOUS method, which does NOT require CALLBACK*/
                /**Execute can NOT be launched in the MAIN THREAD, therefore, we need to create a THREAD,
                 * which will be creating EXTRA thread for Execute*/
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Response<List<Coins>> responseOfExecute = call.execute();
                            if(responseOfExecute.isSuccessful()){
                                List<Coins> coinsList = responseOfExecute.body();
                                Coins coin = coinsList.get(0);
                                Coins coin1 = coinsList.get(1);
                                Coins coin2 = coinsList.get(2);
                                Intent intent = new Intent(v.getContext(), ResultActivity.class);
                                intent.putExtra("ResultSerialized", coin);
                                intent.putExtra("ResultSerialized1", coin1);
                                intent.putExtra("ResultSerialized2", coin2);
                                //Intent intent = new Intent(this, ResultActivity.class);
                                startActivity(intent);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();

            }else{
                Call<List<Coins>> call = networkService.getApiGekko()
                        .getCoinsLeast("btc", 1, "market_cap_asc");
                Intent intent = new Intent(this, ResultActivity.class);
                startActivity(intent);
            }


        });
    }
}
