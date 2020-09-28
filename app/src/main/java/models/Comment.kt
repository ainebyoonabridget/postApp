package com.example.postsapp.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "Comments")
data class Comment(
    val body: String,
    val email: String,
    @PrimaryKey @NonNull val id: Int,
    val name: String,
    val postId: Int
)