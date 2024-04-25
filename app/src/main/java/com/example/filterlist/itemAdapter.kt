package com.example.filterlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class itemAdapter(var data:List<Items>):RecyclerView.Adapter<itemAdapter.ViewHolder>() {
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        var imageView:ImageView = view.findViewById(R.id.imageView)
        var tittle:TextView = view.findViewById(R.id.txttittle)
        var amount:TextView = view.findViewById(R.id.txtamount)
        var category:TextView = view.findViewById(R.id.txtcategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.itemrecycler, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(data[position].image)
        holder.tittle.text = data[position].title
        holder.amount.text = data[position].amount.toString()
        holder.category.text = data[position].category
    }
    fun setFilteredList(data: List<Items>){
        this.data = data
        notifyDataSetChanged()
    }
}