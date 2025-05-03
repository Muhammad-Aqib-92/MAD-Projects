package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(private val todoList: MutableList<tododataclass>) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val todoTextView: TextView = itemView.findViewById(R.id.titletxt)
        val checkBox: CheckBox = itemView.findViewById(R.id.checkBox)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return TodoViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = todoList[position]
        holder.todoTextView.text = currentTodo.title
        holder.checkBox.isChecked = currentTodo.check

        holder.checkBox.setOnCheckedChangeListener { _, isChecked ->
            currentTodo.check = isChecked
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }


    fun deleteCheckedItems() {
        val iterator = todoList.iterator()
        var index = 0
        while (iterator.hasNext()) {
            if (iterator.next().check) {
                iterator.remove()
                notifyItemRemoved(index)
            } else {
                index++
            }
        }
        notifyDataSetChanged()
    }

}







