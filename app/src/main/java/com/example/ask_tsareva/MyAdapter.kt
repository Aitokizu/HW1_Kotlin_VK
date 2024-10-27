package com.example.ask_tsareva

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.core.content.ContextCompat

class MyAdapter(): RecyclerView.Adapter<MyViewHolder>() {

    private val items = ArrayList<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        )
    }



    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val number = items[position]
        holder.bind(number)
        val context = holder.itemView.context
        val colorRes = if (number % 2 == 0){
            R.color.red
        } else {
            R.color.purple_500
        }
        holder.image.setBackgroundColor(ContextCompat.getColor(context, colorRes))
    }

    fun setItems(list:List<Int>){
        items.clear()
        items.addAll(list)
        notifyDataSetChanged()
    }

    fun addItems(item: Int){
        items.add(item)
        notifyDataSetChanged()
    }

    fun getItems(): List<Int>{
        return items
    }
}