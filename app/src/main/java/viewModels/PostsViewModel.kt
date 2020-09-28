package com.example.postsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsapp.models.Post
import com.example.postsapp.repository.PostsRepository
import kotlinx.coroutines.launch

class PostsViewModel(val postsRepository: PostsRepository) : ViewModel() {
    var postsLiveData=MutableLiveData<List<Post>>()
    var postsFailedLiveData=MutableLiveData<String>()
    fun getPosts(){
        viewModelScope.launch{
            val response =postsRepository.getPosts()
            if (response.isSuccessful){
                postsLiveData.postValue(response.body())

            }
            else{
                postsFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    fun getDbPosts(){
        postsLiveData= PostsRepository.getDbPosts()
    }
}