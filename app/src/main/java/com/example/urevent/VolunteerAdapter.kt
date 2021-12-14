package com.example.urevent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VolunteerAdapter(private var list_volunteer: Array<String>, private var deskripsi_volunteer: Array<String>, private var posterV: IntArray) :

//    RecyclerView
    RecyclerView.Adapter<VolunteerAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageViewV : ImageView = itemView.findViewById(R.id.imageView_v)
        var nametextV: TextView = itemView.findViewById(R.id.name_text_v)
        var desctextV: TextView = itemView.findViewById(R.id.desc_text_v)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemsView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_volunteer, parent, false)
        return MyViewHolder(itemsView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.imageViewV.setImageResource(posterV[position])
        holder.nametextV.text = list_volunteer[position]
        holder.desctextV.text = deskripsi_volunteer[position]
    }
    override fun getItemCount(): Int {
        return posterV.size
    }
}