package com.example.cdio

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody

open class CardViewModel() : ViewModel() {
    private val repository = Repository()
    private val _card = MutableStateFlow<Resource<String>>(Resource.Loading())
    val card: StateFlow<Resource<String>> = _card

    fun getCard(image: MultipartBody.Part) = viewModelScope.launch {
        _card.value = Resource.Loading()
        val response = repository.postImage(image)
        Log.d("MVVM",response.toString())
        _card.value = response
    }
}