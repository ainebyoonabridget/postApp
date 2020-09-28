package com.example.postsapp.repository

import androidx.lifecycle.LiveData
import com.example.postsapp.api.ApiClient
import com.example.postsapp.api.ApiInterface
import com.example.postsapp.database.PostAppDatabase
import com.example.postsapp.database.PostAppDatabase.PostAppDatabase.Companion.getDBInstance
import com.example.postsapp.models.Comment
import com.example.postsapp.models.Post
import com.example.postsapp.models.ToDo
import com.example.postsapp.viewmodel.PostsApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ToDosRepository {
    suspend fun getToDos(): Response<List<ToDo>> = withContext(Dispatchers.IO){
        val apiInterface=ApiClient.buildService(ApiInterface::class.java)
        val response= apiInterface.getToDo()
        return@withContext response
    }
    suspend fun saveComments(commentList: List<ToDo>) = withContext(Dispatchers.IO) {
        val database = PostAppDatabase.getDbInstance(PostsApp.appContext)
        val todoDao=database.todoDao()
        todosList.forEach { todo->
            todoDao.insertToDo(todo)
        }
    }
    fun getDbPosts(): LiveData<List<ToDo>> {
        val database = PostAppDatabase.getDbInstance(PostsApp.appContext)
        return database.todoDao().getToDos()

    }
    fun getPostById(postId:Int): LiveData<ToDo> {
        val database = PostAppDatabase.getDbInstance(PostsApp.appContext)
        return database.ToDoDao().getPostById(postId)
    }




}