package com.example.findhairdresser.data.model

import com.example.findhairdresser.R
import retrofit2.Call
import retrofit2.http.GET

interface CitiesAPI {

    @GET("snrylmz/il-ilce-json/blob/master/js/il-ilce.json")
    fun getData(): Call<List<cities>>

}
