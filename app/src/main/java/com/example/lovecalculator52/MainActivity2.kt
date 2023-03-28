package com.example.lovecalculator52

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculator52.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    @Suppress("CAST_NEVER_SUCCEEDS")
        private lateinit var binding: ActivityMain2Binding
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMain2Binding.inflate(layoutInflater)
            setContentView(binding.root)
            getData()
        }

        private fun getData() {
            val firstName = intent.getStringExtra("first")
            val secondName = intent.getStringExtra("second")
            val result = intent.getStringExtra("result")
            val percentage = intent.getStringExtra("percentage")
            binding.tvFirstName.text=firstName
            binding.tvSecondName.text=secondName
            binding.tvPercentage.text=percentage
            binding.tvResult.text=result

        }
}