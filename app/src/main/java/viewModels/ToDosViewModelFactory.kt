package com.example.postsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.postsapp.repository.CommentsRepository
import com.example.postsapp.repository.ToDosRepository

class ToDosViewModelFactory(val toDosRepository: ToDosRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ToDosViewModel::class.java)){
            return ToDosViewModel(toDosRepository)as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
        TODO("Not yet implemented")
    }
}