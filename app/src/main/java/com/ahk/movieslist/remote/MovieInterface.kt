package com.ahk.movieslist.remote

import com.ahk.movieslist.data.MovieResponse
import com.ahk.movieslist.data.ResponseItems
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieInterface {

    @GET("popular")
    suspend fun getPopularMovies(
        @Query("api_key")api_key:String,
        @Query("page")page:Int
    ):Response<MovieResponse>

    @GET("latest")
    suspend fun getLatestMovies(
        @Query("api_key")api_key:String,
        @Query("page")page:Int
    ):Response<MovieResponse>

}
