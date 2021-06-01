package com.example.findhairdresser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

    }

    fun kuafor(view: View) {
        val intent = Intent(this, kuaforGiris::class.java)
        startActivity(intent)

    }

    fun musteri(view: View) {
       val intent = Intent(this, musteriGiris::class.java)
        startActivity(intent)
    }

}