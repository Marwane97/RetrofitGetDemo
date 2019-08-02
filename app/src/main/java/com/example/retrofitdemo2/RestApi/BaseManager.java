package com.example.retrofitdemo2.RestApi;

public class BaseManager {
    protected APIService getApiServiceClient(){
        /*** restApi döndürcek***/
        APIServiceClient apıServiceClient = new APIServiceClient(BaseUrl.MY_URL);
        return apıServiceClient.getMyApiService();
    }
}
