package com.example.urevent

import android.view.LayoutInflater
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

class DaftarAdapter(val daftar: LiveData<List<Pendaftaran>>) :
    RecyclerView.Adapter<DaftarAdapter.MhsViewHolder>() {
    inner class MhsViewHolder(items: View) : RecyclerView.ViewHolder(items)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MhsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.data_daftar, parent, false)
        return MhsViewHolder(layoutInflater)
    }

    override fun getItemCount(): Int {
        return daftar.value?.size ?: 0
    }

    override fun onBindViewHolder(holder: MhsViewHolder, position: Int) {
        holder.itemView.apply {
            val tvNama = findViewById<TextView>(R.id.tv_nama)
            val tvNIM = findViewById<TextView>(R.id.tv_notelp)
            val tvKelas = findViewById<TextView>(R.id.tv_kegiatan)
            tvNama.text = daftar.value?.get(position)?.nama ?: ""
            tvNIM.text = daftar.value?.get(position)?.notelp ?: ""
            tvKelas.text = daftar.value?.get(position)?.namakegiatan ?: ""
        }
    }
}