package com.example.exchangeex.api

import com.example.exchangeex.api.model.ExchangeRequest
import com.example.exchangeex.api.model.ExchangeResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/site/program/financial/exchangeJSON")
    fun getExchangeInfo(@Body exchangeRequest: ExchangeRequest) : Call<ArrayList<ExchangeResponse>>
}