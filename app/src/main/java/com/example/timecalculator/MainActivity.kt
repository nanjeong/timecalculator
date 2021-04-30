package com.example.timecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.timecalculator.databinding.ActivityMainBinding

const val RESULT_VISIBILITY = "result_visibility"
const val HOUR = "hour"
const val MIN = "min"
const val SEC = "sec"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var inputArray: Array<EditText>
    private lateinit var numberKeypad: Array<Pair<TextView, String>>
    private var h: Int = 0
    private var m: Int = 0
    private var s: Int = 0
    private var flag: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if (savedInstanceState != null) {
            flag = savedInstanceState.getInt(RESULT_VISIBILITY)
            h = savedInstanceState.getInt(HOUR)
            m = savedInstanceState.getInt(MIN)
            s = savedInstanceState.getInt(SEC)
            if (flag == 1) {
                showResult()
            }
        }

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

        binding.equal.setOnClickListener {
            calcTime()
            calcResult(h, m, s).let {
                h = it.first
                m = it.second
                s = it.third
            }
            flag = 1
            showResult()
        }

        binding.back.setOnClickListener {
            flag = 0
            binding.apply {
                result.visibility = View.GONE
                show.visibility = View.VISIBLE
            }
            clearInput()
            resetInput()
            noFocus()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(RESULT_VISIBILITY, flag)
        outState.putInt(HOUR, h)
        outState.putInt(MIN, m)
        outState.putInt(SEC, s)
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
            h += binding.hour.text.toString().toInt()
        }
        if (binding.min.text.isNotEmpty()) {
            m += binding.min.text.toString().toInt()
        }
        if (binding.sec.text.isNotEmpty()) {
            s += binding.sec.text.toString().toInt()
        }
    }

    private fun clearInput() {
        for (input in inputArray) {
            input.setText("")
        }
    }

    private fun resetInput() {
        h = 0
        m = 0
        s = 0
    }

    private fun noFocus() {
        for (input in inputArray) {
            input.clearFocus()
        }
    }

    private fun calcResult(h: Int, m: Int, s: Int): Triple<Int, Int, Int> {
        var hour = h
        var min = m
        var sec = s

        over60(min, sec).let {
            min = it.first
            sec = it.second
        }
        over60(hour, min).let {
            hour = it.first
            min = it.second
        }
        return Triple(hour, min, sec)
    }

    private fun over60(biggerUnit: Int, smallerUnit: Int): Pair<Int, Int> {
        val over = smallerUnit / 60
        val remain = smallerUnit % 60

        return Pair(biggerUnit+over, remain)
    }

    private fun showResult() {
        binding.apply {
            show.visibility = View.GONE
            result.visibility = View.VISIBLE
            resultTime = if (h < 10) {
                String.format("%02d : %02d : %02d", h, m, s)
            } else {
                String.format("%d : %02d : %02d", h, m, s)
            }
        }
    }
}

