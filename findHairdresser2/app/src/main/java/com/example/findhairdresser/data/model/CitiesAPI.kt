package com.example.findhairdresser.data.model

import com.example.findhairdresser.R
import retrofit2.Call
import retrofit2.http.GET

interface CitiesAPI {

    @GET(R.raw.cities.toString())
    fun getData(): Call<List<cities>>
}