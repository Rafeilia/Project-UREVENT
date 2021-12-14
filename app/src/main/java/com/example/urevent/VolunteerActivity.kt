package com.example.urevent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class VolunteerActivity : AppCompatActivity() {

    private lateinit var volunteerAdapter: VolunteerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volunteer)

        val listvolunteer: Array<String> = resources.getStringArray(R.array.list_volunteer)
        val deskripsivolunteer: Array<String> = resources.getStringArray(R.array.deskripsi_volunteer)
        val postervolunteer: IntArray = intArrayOf(R.drawable.volunteer1, R.drawable.volunteer2, R.drawable.volunteer3, R.drawable.volunteer4, R.drawable.volunteer5, R.drawable.volunteer6, R.drawable.volunteer7)
        val recyclerViewV: RecyclerView = findViewById(R.id.recyclerViewV)

        findViewById<ImageView>(R.id.imgBackbtn).setOnClickListener {
            intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

        volunteerAdapter = VolunteerAdapter(listvolunteer, deskripsivolunteer, postervolunteer)

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerViewV.layoutManager = layoutManager
        recyclerViewV.adapter = volunteerAdapter
    }
}