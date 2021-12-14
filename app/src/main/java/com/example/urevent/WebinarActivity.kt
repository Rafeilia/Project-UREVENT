package com.example.urevent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WebinarActivity : AppCompatActivity() {

    private lateinit var webinarAdapter: WebinarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webinar)

        val listwebinar: Array<String> = resources.getStringArray(R.array.list_webinar)
        val deskripsiwebinar: Array<String> = resources.getStringArray(R.array.deskripsi_webinar)
        val posterwebinar: IntArray = intArrayOf(R.drawable.webinar1, R.drawable.webinar2, R.drawable.webinar3, R.drawable.webinar4, R.drawable.webinar5, R.drawable.webinar6, R.drawable.webinar7)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        webinarAdapter = WebinarAdapter(listwebinar, deskripsiwebinar, posterwebinar)

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = webinarAdapter

        findViewById<ImageView>(R.id.imgBackbtn).setOnClickListener {
            intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }
    }
}