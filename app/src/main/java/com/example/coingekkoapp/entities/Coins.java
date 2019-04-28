package com.example.coingekkoapp.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


/**INTERFACES can not be extended, they can be IMPLEMENTED*/
public class Coins implements Serializable {
    @Expose
    @SerializedName("symbol")
    private String symbol;

    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("current_price")
    private double current_price;

    @Expose
    @SerializedName("market_cap")
    private long market_cap;

    @Expose
    @SerializedName("market_cap_rank")
    private int market_cap_rank;

    public Coins(String symbol, String name, int current_price, long market_cap, int market_cap_rank) {
        this.symbol = symbol;
        this.name = name;
        this.current_price = current_price;
        this.market_cap = market_cap;
        this.market_cap_rank = market_cap_rank;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getCurrent_price() {
        return current_price;
    }

    public long getMarket_cap() {
        return market_cap;
    }

    public int getMarket_cap_rank() {
        return market_cap_rank;
    }
}
