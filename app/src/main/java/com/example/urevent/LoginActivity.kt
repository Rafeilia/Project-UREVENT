package com.example.urevent

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.OnCompleteListener
import android.content.SharedPreferences

class LoginActivity : AppCompatActivity() {
//    sharedpreferences
    private lateinit var activity: LoginActivity
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {

//        ScrollView - layout
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var auth: FirebaseAuth = FirebaseAuth.getInstance()

        var userEmail = findViewById<EditText>(R.id.editTextEmail)
        var userPassword = findViewById<EditText>(R.id.editTextPassword)

//        sharedPreferences = this.activity?.getSharedPreferences(
//            "sharedPreferences",
//            Context.MODE_PRIVATE
//        ) as SharedPreferences

        findViewById<TextView>(R.id.TVDontHaveAccount).setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnLogin).setOnClickListener {

//            sharedPreferences = this.activity?.getSharedPreferences(
//                "sharedPrefs",
//                Context.MODE_PRIVATE
//            ) as SharedPreferences

            auth.signInWithEmailAndPassword(userEmail.text.toString(), userPassword.editableText.toString())
                .addOnCompleteListener(OnCompleteListener<AuthResult?> { task ->
                    if (!task.isSuccessful) {
                        if (userPassword.length() < 8) {
                            userPassword.setError("Ulangi")
                        } else {
                            Toast.makeText(
                                this@LoginActivity, "Login gagal",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        intent = Intent(this, HomePage::class.java)
                        startActivity(intent)
                        finish()
                    }
                })
//            sharedPreferences = this.activity?.getSharedPreferences(
//                "sharedPrefs",
//                Context.MODE_PRIVATE
//            ) as SharedPreferences
        }
    }
}