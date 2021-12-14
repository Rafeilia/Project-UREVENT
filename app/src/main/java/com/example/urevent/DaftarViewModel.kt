package com.example.urevent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DaftarViewModel(val DataDaftar: DataDaftar): ViewModel() {
    var mhs = MutableLiveData<List<Pendaftaran>>()

    fun getDaftar(): LiveData<List<Pendaftaran>>{
        mhs.value = DataDaftar.getDaftar()
        return mhs
    }

    fun addDaftar(newMhs: Pendaftaran){
        DataDaftar.addDaftar(newMhs)
        mhs.value = DataDaftar.getDaftar()
    }
}