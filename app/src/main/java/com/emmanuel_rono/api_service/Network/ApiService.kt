package com.emmanuel_rono.api_service.Network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import java.util.stream.DoubleStream.builder
//Creating the Retrofit Instance

    val baseUrl = "https://hp-api.onrender.com/api"

    //Builder to build the retrofit instance
    private val retrofit:Retrofit= Retrofit.Builder()
        .addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    //Data deserialized by the converter factory will be into String
//Interface define how the API access data from the internet
    interface ApiService {
        @GET("/characters")
        //Add the return Type
      suspend  fun getData(): String
    }
    //create Retrofit object
//define a public object called MarsApi to initialize the Retrofit service.
// This is the public singleton object that can be accessed from the rest of the app.
    object Api {
        //lazy Ensure that the block is accesed in a single point
        val retrofitService:ApiService by lazy { retrofit.create(ApiService::class.java) }
}