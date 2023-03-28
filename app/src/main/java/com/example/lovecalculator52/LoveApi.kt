package com.example.lovecalculator52

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface LoveApi {

    @GET("getPercentage")
    fun getPercentage(
        @retrofit2.http.Query("fname") firtsName: String,
        @retrofit2.http.Query("sname") second: String,
        @Header("X-RapidAPI-key") key : String = "78bb8ecc8dmsha71f7db1db6c66cp1338f5jsn2ae3a25d70d2",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
        ): Call<LoveModel>
}