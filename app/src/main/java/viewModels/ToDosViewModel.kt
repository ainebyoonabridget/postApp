package com.example.postsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postsapp.models.Comment
import com.example.postsapp.models.ToDo
import com.example.postsapp.repository.CommentsRepository
import com.example.postsapp.repository.ToDosRepository
import kotlinx.coroutines.launch

class ToDosViewModel(val toDosRepository: ToDosRepository) : ViewModel() {
    var todosLiveData=MutableLiveData<List<ToDo>>()
    var todosFailedLiveData=MutableLiveData<String>()
    fun getToDos(){
        viewModelScope.launch{
            val response =toDosRepository.getToDos()
            if (response.isSuccessful){
                todosLiveData.postValue(response.body())

            }
            else{
                todosFailedLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}