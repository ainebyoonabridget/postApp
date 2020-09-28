package com.example.postsapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.postsapp.R
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        post.setOnClickListener {
            startActivity(Intent(baseContext,MainActivity::class.java))
        }
        comment.setOnClickListener {
            startActivity(Intent(baseContext,CommentsActivity::class.java))
        }


    }
}