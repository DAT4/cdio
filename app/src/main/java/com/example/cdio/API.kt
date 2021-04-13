package com.example.cdio

import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface API {
    @Multipart
    @POST("image")
    suspend fun sendImage(
        @Part image: MultipartBody.Part
    ) : Response<Card>

}