package com.helloapp.network

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    //region main
//    @GET("v1/dashboard/hello/setting")
//    fun settingDP(): Observable<String>
//
    @POST("generalInfo/home")
    fun homeCall(@Body req: RequestBody) : Call<String>
//
//    @POST("v1/em_user/em_hellosetting")
//    fun settingN(@Body req: RequestBody): Observable<String>
//endregion
}