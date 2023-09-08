package com.ismoyb.pruebatecnica.domain.repository

import com.ismoyb.pruebatecnica.data.remote.BooksApi
import com.ismoyb.pruebatecnica.domain.model.Payload
import retrofit2.Response
import javax.inject.Inject

class BooksRepository @Inject constructor(private val mBooksApi: BooksApi) {
    suspend fun searchBooks(query:String):Response<Payload>{
        return mBooksApi.searchBooks(query)
    }
}