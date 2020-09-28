package com.example.postsapp.repository

import androidx.lifecycle.LiveData
import com.example.postsapp.api.ApiClient
import com.example.postsapp.api.ApiInterface
import com.example.postsapp.database.PostAppDatabase
import com.example.postsapp.models.Comment
import com.example.postsapp.models.Post
import com.example.postsapp.viewmodel.PostsApp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CommentsRepository {
    suspend fun getComments(): Response<List<Comment>> = withContext(Dispatchers.IO){
        val apiInterface=ApiClient.buildService(ApiInterface::class.java)
        val response= apiInterface.getComments()
        return@withContext response
    }
    suspend fun saveComments(commentList: List<Comment>) = withContext(Dispatchers.IO) {
        val database = PostAppDatabase.getDbInstance(PostsApp.appContext)
        val commentDao=database.commentsDao()
        commentList.forEach { comment->
            commentDao.insertComment(comment)
        }
    }
    fun getDbPosts(): LiveData<List<Comment>> {
        val database = PostAppDatabase.getDbInstance(PostsApp.appContext)
        return database.commentDao().getComments()

    }
    fun getPostById(postId:Int): LiveData<Comment> {
        val database = PostAppDatabase.getDbInstance(PostsApp.appContext)
        return database.CommentDao().getPostById(postId)
    }




}