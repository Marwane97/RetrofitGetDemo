package com.example.retrofitdemo2.RestApi;

import com.example.retrofitdemo2.Models.ResourceList;
import com.example.retrofitdemo2.Models.UserList;

import retrofit2.Call;

public class ManagerAll extends BaseManager {
    protected static  ManagerAll ourIntance = new ManagerAll();
    public static synchronized ManagerAll getIntance(){
        return ourIntance;
    }

  public Call<UserList> UsersList(int value){
     Call<UserList> mod =getApiServiceClient().doGetUserList(value);
     return mod;
  }

  public Call<ResourceList> ResourceList(){
       Call<ResourceList> resource = getApiServiceClient().doGetResourceList();
      return resource;
  }
}
