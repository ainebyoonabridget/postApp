package com.example.postsapps.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapps.R
import com.example.postsapps.model.Post
import com.example.postsapps.ui.Post
import kotlinx.android.synthetic.main.item_posts.view.*

private val View.ids: Any
    get() {
        TODO("Not yet implemented")
    }
private val View.body: Any
    get() {
        TODO("Not yet implemented")
    }
private val View.title: Any
    get() {
        TODO("Not yet implemented")
    }
private var Any.text: Any
    get() {
        TODO("Not yet implemented")
    }
    set() {}
private val View.userId: Any
    get() {
        TODO("Not yet implemented")
    }

class PostsAdapter(
    var posts: List<Post>
) : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_posts, parent, false)
    )

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var post = posts[position]

        holder.itemView.userId.text = post.userId.toString()
        holder.itemView.ids.text = post.id.toString()
        holder.itemView.title.text = post.title
        holder.itemView.body.text = post.body
    }

    inner class PostsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}