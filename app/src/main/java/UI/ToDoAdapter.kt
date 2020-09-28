package com.example.postsapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.postsapp.R
import com.example.postsapp.models.Comment
import com.example.postsapp.models.ToDo
import kotlinx.android.synthetic.main.row_item_comments.view.*
import kotlinx.android.synthetic.main.row_item_todos.view.*

class ToDoAdapter(
    var todos: List<ToDo>
) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {
    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ToDoViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.row_item_todos, parent, false)

    )

    override fun getItemCount() = todos.size

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        var todo = todos[position]
        holder.itemView.completed.text = todo.completed.toString()
        holder.itemView.ids.text = todo.id.toString()
        holder.itemView.title.text = todo.title.toString()
        holder.itemView.userId.text = todo.userId.toString()





    }
}