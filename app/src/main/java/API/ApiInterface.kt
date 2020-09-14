package com.example.postsapps.api

import com.example.postsapps.model.Post
import com.example.postsapps.ui.Post
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>
}