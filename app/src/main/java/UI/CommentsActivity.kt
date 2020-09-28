package com.example.postsapp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.postsapp.R
import com.example.postsapp.repository.CommentsRepository
import com.example.postsapp.viewmodel.CommentsViewModel
import com.example.postsapp.viewmodel.CommentsViewModelFactory
import kotlinx.android.synthetic.main.activity_comments.*
import kotlinx.android.synthetic.main.row_item_comments.*

class CommentsActivity : AppCompatActivity() {
    lateinit var commentsViewModel: CommentsViewModel
    lateinit var commentsViewModelFactory: CommentsViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        val commentsRepository= CommentsRepository()
        commentsViewModelFactory= CommentsViewModelFactory(commentsRepository)
        commentsViewModel=
            ViewModelProvider(this, commentsViewModelFactory).get(CommentsViewModel::class.java)

        commentsViewModel.getPosts()

        commentsViewModel.commentsLiveData.observe(this, Observer { commentsList->
            rvComments.apply{
                layoutManager= LinearLayoutManager(this@CommentsActivity)
                hasFixedSize()
                adapter=CommentsAdapter(commentsList)
            }
            Toast.makeText(baseContext,"${commentsList.size} comments fetched", Toast.LENGTH_LONG).show()
        })
        commentsViewModel.commentsFailedLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error, Toast.LENGTH_LONG).show()
        })

    }
}