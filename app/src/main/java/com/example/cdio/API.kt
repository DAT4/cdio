package com.example.cdio

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface API {
    @Multipart
    @POST("image")
    suspend fun sendImage(
        @Part image: MultipartBody.Part
    )

}