package com.example.coingekkoapp;

import com.example.coingekkoapp.entities.CoinsMain;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiGekko {

    @GET(Constants.PATH_FOR_DATA + "markets")
    Call<CoinsMain> getCoins(
        @Query("vs_currency") String symbol,
        @Query("per_page") int per_page
    );
}
