package com.example.urevent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomePage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        findViewById<ImageView>(R.id.btnNotif).setOnClickListener {
            intent = Intent(this, BlankFragment::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnLogout).setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.imgWebinar).setOnClickListener {
            intent = Intent(this, WebinarActivity::class.java)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.TVWebinar).setOnClickListener {
            intent = Intent(this, WebinarActivity::class.java)
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.imgVolunteer).setOnClickListener {
            intent = Intent(this, VolunteerActivity::class.java)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.TVVolunteer).setOnClickListener {
            intent = Intent(this, VolunteerActivity::class.java)
            startActivity(intent)
        }
        findViewById<ImageView>(R.id.imgPublikasi).setOnClickListener {
            intent = Intent(this, DaftarActivity::class.java)
            startActivity(intent)
        }
        findViewById<TextView>(R.id.TVPublikasi).setOnClickListener {
            intent = Intent(this, DaftarActivity::class.java)
            startActivity(intent)
        }
    }

}