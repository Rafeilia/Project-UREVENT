package com.example.urevent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.urevent.databinding.ActivityDaftarBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DaftarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDaftarBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar)
        binding = ActivityDaftarBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        Database - Binding
        binding.btnDaftar.setOnClickListener {
            val nama = binding.etNama.text.toString()
            val notelp = binding.etNoTelp.text.toString()
            val namakegiatan = binding.etKegiatan.text.toString()

            database =
                FirebaseDatabase.getInstance("https://urevent-app-e55d5-default-rtdb.asia-southeast1.firebasedatabase.app")
                    .getReference("Pendaftaran")
            val Pendaftaran = Pendaftaran(nama, notelp, namakegiatan)
            database.child(nama).setValue(Pendaftaran).addOnCanceledListener {

                binding.etNama.text.clear()
                binding.etNoTelp.text.clear()
                binding.etKegiatan.text.clear()

                Toast.makeText(this, "Udah Ke-Save", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {

                Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show()
            }

        }

//        LiveData dan ViewModel
        val nama = findViewById<EditText>(R.id.et_Nama)
        val notelp = findViewById<EditText>(R.id.et_NoTelp)
        val kegiatan = findViewById<EditText>(R.id.et_Kegiatan)

        val dataDaftar = DataDaftar()
        val daftarViewModel = DaftarViewModel(dataDaftar)
        val rvMain = findViewById<RecyclerView>(R.id.rv_daftar)
        rvMain.adapter = DaftarAdapter(daftarViewModel.getDaftar())
        rvMain.layoutManager = LinearLayoutManager(this)

        val buttonRefresh = findViewById<ImageView>(R.id.btnRefresh)
        buttonRefresh.setOnClickListener {
            val NAMA = nama.getText().toString()
            val NOTELP = notelp.getText().toString()
            val KEGIATAN = kegiatan.getText().toString()
            daftarViewModel.addDaftar(Pendaftaran(NAMA, NOTELP, KEGIATAN))
            rvMain.adapter = DaftarAdapter(daftarViewModel.getDaftar())
            rvMain.layoutManager = LinearLayoutManager(this)
        }

        findViewById<Button>(R.id.buttonKembali).setOnClickListener {
            intent = Intent(this, HomePage::class.java)
            startActivity(intent)
        }

    }
}

//private lateinit var sharedPref: SharedPreferences
//private val SharedKey = "sharedPref"
//
//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(R.layout.activity_main2)
//    findViewById<Button>(R.id.buttonkembali).setOnClickListener {
//        intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
//    }
//    p = findViewById(R.id.ETL)
//    l = findViewById(R.id.ETA)
//    sharedPref = getSharedPreferences(SharedKey, Context.MODE_PRIVATE)
//    var luasP = findViewById<TextView>(R.id.luasPersegi)
//    val btnLuas = findViewById<Button>(R.id.btnLuas)
//
//    btnLuas.setOnClickListener {
//        nilai = p.text.toString().toFloat() * l.text.toString().toFloat()
//        luasP.text = nilai.toString()
//        val editor = sharedPref.edit()
//        editor.putString(panjang, p.text.toString())
//        editor.putString(lebar, l.text.toString())
//        editor.putFloat(luas, nilai)
//        editor.apply()
//    }
//    val hasilPanjang = sharedPref.getString(panjang, "")
//    val hasilLebar = sharedPref.getString(lebar, "")
//    val hasilLuas = sharedPref.getFloat(luas, 0.0f)
//    luasP.text = hasilLuas.toString()
//    p.setText(hasilPanjang)
//    l.setText(hasilLebar)
//}