package com.example.urevent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.OnCompleteListener

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var auth: FirebaseAuth = FirebaseAuth.getInstance()

        var userEmail = findViewById<EditText>(R.id.editTextemail)
        var userPassword = findViewById<EditText>(R.id.editTextpassword)

        findViewById<TextView>(R.id.TVHaveAccount).setOnClickListener {
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnRegister).setOnClickListener {
            auth.createUserWithEmailAndPassword(
                userEmail.text.toString(),
                userPassword.editableText.toString()
            )
                .addOnCompleteListener(this@MainActivity,
                    OnCompleteListener<AuthResult?> { task ->
                        Log.d(
                            this@MainActivity::class.java.simpleName,
                            "New user registration: " + task.isSuccessful
                        )
                        if (!task.isSuccessful) {
                            Toast.makeText(
                                this@MainActivity,
                                "Authentication failed. " + task.exception,
                                Toast.LENGTH_LONG
                            ).show()
                        } else {
                            this@MainActivity.startActivity(
                                Intent(
                                    this@MainActivity,
                                    MainActivity::class.java
                                )
                            )
                            this@MainActivity.finish()
                        }
                    })
            intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

    }
}