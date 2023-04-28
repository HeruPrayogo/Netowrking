package com.example.netowrking.network

import com.example.netowrking.model.DataFilmItem
import com.example.netowrking.model.ResponseDataNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface RestfulApi {
    //@GET("news")
    @GET("film")
    //fun getAllNews(): Call<List<ResponseDataNewsItem>>
    fun getAllNews(): Call<List<DataFilmItem>>
}