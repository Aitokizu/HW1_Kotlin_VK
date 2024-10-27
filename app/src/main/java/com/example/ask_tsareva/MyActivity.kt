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
        fab = findViewById(R.id.fab)

        recyclerView.adapter = adapter


        fab.setOnClickListener{
            adapter.addItems(adapter.itemCount+1)
            recyclerView.scrollToPosition(adapter.itemCount-1)

        }

        if(savedInstanceState != null){
            val savedItems = savedInstanceState.getIntegerArrayList("items")?: listOf(1,2,3,4,5)
            adapter.setItems(savedItems)


        } else {

            adapter.setItems(listOf(1, 2, 3, 4, 5))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntegerArrayList("items", ArrayList(adapter.getItems()))

    }
}