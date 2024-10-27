package com.example.ask_tsareva

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyActivity: AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var fab: FloatingActionButton

    private val adapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)

        recyclerView.adapter = adapter

        fab = findViewById(R.id.fab)
        fab.setOnClickListener{
            adapter.addItems(adapter.itemCount+1)

        }
        adapter.setItems(listOf(1,2,3,4,5))
    }
}