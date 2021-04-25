package com.example.timecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.*
import com.example.timecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var inputArray: Array<EditText>
    private lateinit var numberKeypad: Array<Pair<TextView, String>>
    private var hour: Int = 0
    private var min: Int = 0
    private var sec: Int = 0
    private val fragment: ResultFragment = ResultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        inputArray = arrayOf(binding.hour, binding.min, binding.sec)
        numberKeypad = arrayOf(
            Pair(binding.zero, "0"),
            Pair(binding.one, "1"),
            Pair(binding.two, "2"),
            Pair(binding.three, "3"),
            Pair(binding.four, "4"),
            Pair(binding.five, "5"),
            Pair(binding.six, "6"),
            Pair(binding.seven, "7"),
            Pair(binding.eight, "8"),
            Pair(binding.nine, "9")
        )

        setUp()
        inputListener()

        binding.clear.setOnClickListener {
            clearInput()
            resetInput()
        }

        binding.plus.setOnClickListener {
            calcTime()
            clearInput()
        }

        val fragmentManager: FragmentManager = supportFragmentManager

        binding.equal.setOnClickListener {
            calcTime()

            val fragmentTransaction = fragmentManager.beginTransaction()
            val bundle = Bundle()
            bundle.putInt("hour", hour)
            bundle.putInt("min", min)
            bundle.putInt("sec", sec)

            fragmentTransaction.replace(R.id.show, fragment.apply { arguments = bundle })
            fragmentTransaction.commit()
        }

        binding.back.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragment)
            fragmentTransaction.commit()

            clearInput()
            resetInput()
            noFocus()
        }
    }

    private fun setUp() {
        for (input in inputArray) {
            input.showSoftInputOnFocus = false
            input.isCursorVisible = false
        }
    }

    private fun inputListener() {
        for (input in inputArray) {
            input.setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    numberKeypadOnClick(input)
                    binding.clearEntry.setOnClickListener { input.setText("") }
                }
            }
        }
    }

    private fun numberKeypadOnClick(input: EditText) {
        for (key in numberKeypad) {
            key.first.setOnClickListener {
                if (input.text.toString().length < 5) {
                    input.setText("${input.text}${key.second}")
                } else {
                    Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun calcTime() {
        if (binding.hour.text.isNotEmpty()) {
            hour += binding.hour.text.toString().toInt()
        }
        if (binding.min.text.isNotEmpty()) {
            min += binding.min.text.toString().toInt()
        }
        if (binding.sec.text.isNotEmpty()) {
            sec += binding.sec.text.toString().toInt()
        }
    }

    private fun clearInput() {
        for (input in inputArray) {
            input.setText("")
        }
    }

    private fun resetInput() {
        hour = 0
        min = 0
        sec = 0
    }

    private fun noFocus() {
        for (input in inputArray) {
            input.clearFocus()
        }
    }
}

