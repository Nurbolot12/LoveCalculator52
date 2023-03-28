package com.example.lovecalculator52

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lovecalculator52.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            requestBtn.setOnClickListener {
                LoveService().api.getPercentage(
                    firstName.text.toString(),
                    secondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        val intent = Intent(this@MainActivity, MainActivity2::class.java)
                        intent.putExtra("first", response.body()?.firstfName)
                        intent.putExtra("second", response.body()?.secondsName)
                        intent.putExtra("result", response.body()?.result)
                        intent.putExtra("percentage", response.body()?.percentage)
                        startActivity(intent)
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("MainActivity", "onFailure: ${t.message}")
                    }

                })
            }
        }
    }

}