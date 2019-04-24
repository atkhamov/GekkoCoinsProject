package com.example.coingekkoapp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mService = null;
    private Retrofit mRetrofit;

    public static NetworkService getInstance(){
        if(mService == null){
            mService = new NetworkService();
        }return mService;
    }

    private NetworkService(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public ApiGekko getApiGekko(){
        return mRetrofit.create(ApiGekko.class);
    }
}
