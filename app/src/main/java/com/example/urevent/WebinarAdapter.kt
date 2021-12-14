package com.example.urevent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WebinarAdapter(private var list_webinar: Array<String>, private var deskripsi_webinar: Array<String>, private var poster: IntArray) :

//    RecyclerView
    RecyclerView.Adapter<WebinarAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView : ImageView = itemView.findViewById(R.id.imageView)
        var nametext: TextView = itemView.findViewById(R.id.name_text)
        var desctext: TextView = itemView.findViewById(R.id.desc_text)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_webinar, parent, false)
        return MyViewHolder(itemsView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageView.setImageResource(poster[position])
        holder.nametext.text = list_webinar[position]
        holder.desctext.text = deskripsi_webinar[position]
    }
    override fun getItemCount(): Int {
        return poster.size
    }

}