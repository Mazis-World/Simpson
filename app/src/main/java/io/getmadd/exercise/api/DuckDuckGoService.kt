package io.getmadd.exercise.api

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DuckDuckGoService {

    @GET("/")
    fun getResponse(
        @Query("q") query: String,
        @Query("format") format: String): Call<DuckDuckGoResponse?>?
}