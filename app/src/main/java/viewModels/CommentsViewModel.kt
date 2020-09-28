package com.example.postsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsapp.models.Comment
import com.example.postsapp.repository.CommentsRepository
import kotlinx.coroutines.launch

class CommentsViewModel(val commentsRepository: CommentsRepository) : ViewModel() {
    var commentsLiveData=MutableLiveData<List<Comment>>()
    var commentsFailedLiveData=MutableLiveData<String>()
    fun getComments(){
        viewModelScope.launch{
            val response =commentsRepository.getComments()
            if (response.isSuccessful){
                commentsLiveData.postValue(response.body())

            }
            else{
                commentsFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}