package com.example.exchangeex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exchangeex.adapter.ItemListAdapter
import com.example.exchangeex.api.ApiService
import com.example.exchangeex.api.RetrofitClient
import com.example.exchangeex.api.model.ExchangeRequest
import com.example.exchangeex.api.model.ExchangeResponse
import com.example.exchangeex.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var exchangeData : ArrayList<ExchangeResponse> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val exchangeRequest = ExchangeRequest(getString(R.string.bank_open_api_key), "20230214", "AP01")

        binding.mainRecycler.layoutManager = LinearLayoutManager(this)
        val apiInterface : ApiService = RetrofitClient.getRetrofitInfo()!!.create(ApiService::class.java)
        apiInterface.getExchangeInfo(exchangeRequest).enqueue(object : Callback<ArrayList<ExchangeResponse>> {
            override fun onResponse(
                call: Call<ArrayList<ExchangeResponse>>,
                response: Response<ArrayList<ExchangeResponse>>
            ) {
                exchangeData = response.body()!!
                binding.mainRecycler.adapter = ItemListAdapter(response.body()!!)
            }

            override fun onFailure(call: Call<ArrayList<ExchangeResponse>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

    }
}