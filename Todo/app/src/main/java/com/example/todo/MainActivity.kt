package com.example.todo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var toDoTitle: EditText
    private lateinit var addButton: Button
    private lateinit var deleteButton: Button


    private val todoList = mutableListOf<tododataclass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Views
        recyclerView = findViewById(R.id.recyclerView)
        toDoTitle = findViewById(R.id.toDoTitle)
        addButton = findViewById(R.id.button)
        deleteButton = findViewById(R.id.button2)

        // Set Layout Manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Initialize Adapter with empty list
        todoAdapter = TodoAdapter(todoList)
        recyclerView.adapter = todoAdapter

        deleteButton.setOnClickListener {
            todoAdapter.deleteCheckedItems()
        }

        // Add Button Click Listener
        addButton.setOnClickListener {
            val title = toDoTitle.text.toString()
            if (title.isNotEmpty()) {
                val newTodo = tododataclass(title)
                todoList.add(newTodo)
                todoAdapter.notifyItemInserted(todoList.size - 1)
                toDoTitle.text.clear()
            }
        }
    }
}
