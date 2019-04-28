package com.example.coingekkoapp;

import com.example.coingekkoapp.entities.Coins;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiGekko {

    @GET(Constants.PATH_FOR_DATA + "markets")
    Call<List<Coins>> getCoins(
        @Query("vs_currency") String symbol,
        @Query("per_page") int per_page
    );

    @GET(Constants.PATH_FOR_DATA + "markets")
    Call<List<Coins>> getCoinsLeast(
        @Query("vs_currency") String symbol,
        @Query("per_page") int per_page,
        @Query("order") String order_ascendance
    );
}
