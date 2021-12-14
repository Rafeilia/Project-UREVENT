package com.example.urevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.FragmentManager

class BlankFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_blank)

        findViewById<Button>(R.id.btnAll).setOnClickListener{
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragment_main,Fragment1())
                commit()
            }
        }

        findViewById<Button>(R.id.btnUnread).setOnClickListener{
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.fragment_main,Fragment2())
                commit()
            }
        }
    }

}