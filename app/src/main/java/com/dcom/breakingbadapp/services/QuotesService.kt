package com.dcom.breakingbadapp.services

import com.dcom.breakingbadapp.api.Response
import com.dcom.breakingbadapp.api.ResponsePhrase
import com.dcom.breakingbadapp.api.api
import retrofit2.http.GET

interface QuotesService {

    @GET("quote/random")
    suspend fun getQuotes(): ResponsePhrase
}

var quotesService: QuotesService = api.create<QuotesService>(QuotesService::class.java)

