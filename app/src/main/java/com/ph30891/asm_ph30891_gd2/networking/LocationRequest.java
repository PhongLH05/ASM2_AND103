package com.ph30891.asm_ph30891_gd2.networking;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LocationRequest {
    public final static String SHOPID = "2509769";
    public final static String TokenGHN = "492f6cd2-1637-11f0-95d0-0a92b8726859";
    private LocationService locationService;

    public LocationRequest(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request request = chain.request().newBuilder()
                    .addHeader("ShopId",SHOPID)
                    .addHeader("Token",TokenGHN)
                    .build();
            return  chain.proceed(request);
        });
        // create retrofit
        locationService = new Retrofit.Builder()
                .baseUrl(LocationService.GHN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build().create(LocationService.class);
    }
    public LocationService callAPI(){
        return locationService;
    }
}
