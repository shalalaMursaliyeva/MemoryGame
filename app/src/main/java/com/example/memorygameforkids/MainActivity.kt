package com.example.memorygameforkids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.memorygameforkids.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btEasy.setOnClickListener{
            var intent = Intent(this, EasyActivity ::class.java)
            startActivity(intent)
        }
        binding.btMedium.setOnClickListener{
            var intent = Intent(this, MediumActivity ::class.java)
            startActivity(intent)
        }
        binding.btHard.setOnClickListener{
            var intent = Intent(this, HardActivity ::class.java)
            startActivity(intent)
        }



    }
}