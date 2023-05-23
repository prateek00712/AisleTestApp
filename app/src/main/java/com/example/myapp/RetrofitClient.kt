package com.example.myapp

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {
    private const val BASE_URL = "https://app.aisle.co/V1/"

    val okHttpClient = OkHttpClient.Builder()
        .readTimeout(100, TimeUnit.SECONDS)
        .connectTimeout(100, TimeUnit.SECONDS)
        .build()
   /* val okHttpClient = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val originalRequest = chain.request()

            // Add your headers here
            val headers = originalRequest.headers.newBuilder()
                .add("Authorization", "32c7794d2e6a1f7316ef35aa1eb34541")
                .build()

            val newRequest = originalRequest.newBuilder()
                .headers(headers)
                .build()

            chain.proceed(newRequest)
        }
        .build()*/

    val apiService: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }

}