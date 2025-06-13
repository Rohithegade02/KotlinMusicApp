package com.example.musicapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers("X-RapidAPI-Key:cbf2a05005mshecba0d6877787cep1af7abjsncad45a795cb9",
        "X-RapidAPI-Host:deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query: String):Call<MyData>
}