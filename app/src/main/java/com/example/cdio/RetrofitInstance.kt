package com.example.cdio

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    companion object {
        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            val gson = Gson()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
            Retrofit.Builder()
                .baseUrl("http://mama.lan/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()
        }
        val api by lazy {
            retrofit.create(API::class.java)
        }
    }
}