package com.ismoyb.pruebatecnica.di
import com.ismoyb.pruebatecnica.Constant
import com.ismoyb.pruebatecnica.data.remote.BooksApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
 @InstallIn(SingletonComponent::class)
object NetworkModule {
  @Provides
  @Singleton
  fun provideBooksApi(): BooksApi {
   return Retrofit.Builder()
    .baseUrl(Constant.BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
    .create(BooksApi::class.java)
  }
}
