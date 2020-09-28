package com.example.postsapp.models

data class ToDo(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)