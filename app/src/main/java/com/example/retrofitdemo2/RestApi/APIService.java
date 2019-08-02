package com.example.retrofitdemo2.RestApi;

import com.example.retrofitdemo2.Models.ResourceList;
import com.example.retrofitdemo2.Models.UserList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") int page);

    @GET("/api/unknown")
    Call<ResourceList> doGetResourceList();
}
