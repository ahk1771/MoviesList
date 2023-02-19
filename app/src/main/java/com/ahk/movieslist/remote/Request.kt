package com.ahk.movieslist.remote

import com.ahk.movieslist.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Request {

    val retrofitBuilder = Retrofit.Builder().baseUrl(Constants.BASE_URL).addConverterFactory(
        GsonConverterFactory.create()
    )

    val retrofit = retrofitBuilder.build()

    val movieInterface = retrofit.create(MovieInterface::class.java)

    fun retrofitInterface() : MovieInterface {
        return movieInterface
    }
}