package com.example.coingekkoapp.entities;

public class Coins {
    private String symbol;
    private String name;
    private int current_price;
    private long market_cap;
    private int market_cap_rank;

    public Coins(String symbol, String name, int current_price, long market_cap, int market_cap_rank) {
        this.symbol = symbol;
        this.name = name;
        this.current_price = current_price;
        this.market_cap = market_cap;
        this.market_cap_rank = market_cap_rank;
    }

    public String getBtc() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public int getCurrent_price() {
        return current_price;
    }

    public long getMarket_cap() {
        return market_cap;
    }

    public int getMarket_cap_rank() {
        return market_cap_rank;
    }
}
