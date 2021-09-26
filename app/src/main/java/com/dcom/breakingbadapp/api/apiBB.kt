package com.dcom.breakingbadapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var api =
    Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://breakingbadapi.com/api/")
        .build()