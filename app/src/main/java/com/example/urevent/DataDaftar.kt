package com.example.urevent

class DataDaftar {
    var ListDaftar = mutableListOf<Pendaftaran>()
    init {
        ListDaftar.add(Pendaftaran("Burhan", "08914045391", "Webinar A"))
    }
    fun getDaftar() = ListDaftar
    fun addDaftar(newDaftar: Pendaftaran){
        ListDaftar.add(newDaftar)
        getDaftar()
    }
}