package com.delhitransit.delhitransit_android.api;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    //private static final String BASE_URL = "http://delhitransit.herokuapp.com/";
    //private static final String BASE_URL = "http://www.delhitransit.ml/";
    private static final String BASE_URL = "http://delhitransit.centralindia.cloudapp.azure.com";
    private static Retrofit retrofit = null;


    private static Retrofit getApiClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .readTimeout(2, TimeUnit.MINUTES)
                .connectTimeout(2, TimeUnit.MINUTES);
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

    public static ApiInterface getApiService() {
        return getApiClient().create(ApiInterface.class);
    }
}