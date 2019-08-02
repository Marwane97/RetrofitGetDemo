package com.example.retrofitdemo2.RestApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIServiceClient {
    private APIService myApiService;

    public APIServiceClient(String restApiServiceUrl) {
        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(restApiServiceUrl)
                .addConverterFactory(GsonConverterFactory.create(gson));
        Retrofit retrofit = builder.build();
        myApiService = retrofit.create(APIService.class);
    }
    public APIService getMyApiService(){
        return myApiService;
    }
}
