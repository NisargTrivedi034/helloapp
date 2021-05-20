package com.helloapp.repository

import androidx.lifecycle.MutableLiveData
import com.helloapp.network.RetrofitClient
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response

object HomeRepository {

    val homeResponse = MutableLiveData<String>()

     fun getLocation(string: RequestBody) : MutableLiveData<String>{

        val call = RetrofitClient.apiInterface
        call.homeCall(string).enqueue(object :retrofit2.Callback<String>{
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                if(response.isSuccessful) {
                    val responseData = response.body()
                    homeResponse.value = responseData.toString()
                }

            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                System.out.println("Erorr-->"+t.message)
            }
        })
        return  homeResponse
    }
}

//val responseData = response.body()
//locationResponse.value = LocationResponse(responseData!!.status,responseData!!.country,responseData!!.regionName,responseData!!.city)
//System.out.println("STATUS------>"+responseData!!.status)
//System.out.println("STATE------>"+responseData!!.regionName)
//System.out.println("CITY------>"+responseData!!.city)
