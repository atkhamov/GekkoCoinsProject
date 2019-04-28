package com.example.coingekkoapp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**This is the SINGLETON pattern class*/
public class NetworkService {
    private static NetworkService nService = null;
    private Retrofit nRetrofit;

    public static NetworkService getInstance(){
        if(nService == null){
            nService = new NetworkService();
        }return nService;
    }

    private NetworkService(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        nRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public ApiGekko getApiGekko(){
        return nRetrofit.create(ApiGekko.class);
    }
}
