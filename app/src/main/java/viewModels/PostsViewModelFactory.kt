package com.example.postsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.postsapp.repository.PostsRepository
import java.lang.IllegalArgumentException

class PostsViewModelFactory(val postsRepository: PostsRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostsViewModel::class.java)){
            return PostsViewModel(postsRepository)as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
        TODO("Not yet implemented")
    }
}