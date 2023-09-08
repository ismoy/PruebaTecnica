package com.ismoyb.pruebatecnica.data.remote

import com.ismoyb.pruebatecnica.domain.model.Payload
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApi {
    @GET("volumes")
    suspend fun searchBooks(
        @Query("q") query:String
        ):Response<Payload>
}