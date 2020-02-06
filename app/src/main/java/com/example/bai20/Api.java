package com.example.bai20;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

//    @GET("f600/f2017_listFriendF600Search?FO100=17590&pvSEARCH=duy&pvNUMBER=&pvLOGIN=qbtest_NhapMaGt2333&v=v1&MODEL=oppo&OS=28&SRC=android&VERSION=167&token=326eb6e645c9ef419bc5c7b24560f57c")
//    Call<DataResponse> getUsers();


    @GET("f600/f2017_listFriendF600Search")
    Call<DataResponse> getUsers(

            @Query("pvSEARCH") String pvSEARCH,
            @Query("apiKey") String apiKey

    );


}
