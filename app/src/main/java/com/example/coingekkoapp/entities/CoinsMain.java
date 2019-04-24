package com.example.coingekkoapp.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoinsMain {
    @Expose
    @SerializedName("markets")
    private List<Coins> coinsList;

    public CoinsMain(List<Coins> coinsList) {
        this.coinsList = coinsList;
    }

    public List<Coins> getCoinsList() {
        return coinsList;
    }
}
