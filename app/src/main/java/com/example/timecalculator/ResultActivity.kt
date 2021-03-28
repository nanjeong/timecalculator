package com.example.timecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = findViewById<TextView>(R.id.result)

        var hour: Int = intent.getIntExtra("hour", 0)
        var min: Int = intent.getIntExtra("min", 0)
        var sec: Int = intent.getIntExtra("sec", 0)

        val overSec = sec / 60
        val remainSec = sec % 60
        sec = remainSec
        min += overSec

        val overMin = min / 60
        val remainMin = min % 60
        min = remainMin
        hour += overMin

        result.setText(String.format("%d : %02d : %02d", hour, min, sec))
    }
}