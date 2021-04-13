package com.example.cdio

import okhttp3.MultipartBody
import retrofit2.Response

class Repository() {

    suspend fun postImage(image: MultipartBody.Part): Resource<Card> {
        return handleGetEvents(RetrofitInstance.api.sendImage(image))
    }

    private fun handleGetEvents(response: Response<Card>): Resource<Card> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }
}