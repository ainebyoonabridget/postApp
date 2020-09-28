package com.example.postsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.postsapp.repository.CommentsRepository

class CommentsViewModelFactory(val commentsRepository: CommentsRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CommentsViewModel::class.java)){
            return CommentsViewModel(commentsRepository)as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
        TODO("Not yet implemented")
    }
}