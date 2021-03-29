package com.example.timecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    //    fun replaceFragment(fragment: Fragment) {
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.show, fragment)
//        fragmentTransaction.commit()
//    }
    val fragment: ResultFragment = ResultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val zero = findViewById<TextView>(R.id.zero)
        val one = findViewById<TextView>(R.id.one)
        val two = findViewById<TextView>(R.id.two)
        val three = findViewById<TextView>(R.id.three)
        val four = findViewById<TextView>(R.id.four)
        val five = findViewById<TextView>(R.id.five)
        val six = findViewById<TextView>(R.id.six)
        val seven = findViewById<TextView>(R.id.seven)
        val eight = findViewById<TextView>(R.id.eight)
        val nine = findViewById<TextView>(R.id.nine)
        val clear = findViewById<TextView>(R.id.clear)
        val clearEntry = findViewById<TextView>(R.id.clear_entry)
        val plus = findViewById<TextView>(R.id.plus)
        val equal = findViewById<TextView>(R.id.equal)
        val hourView = findViewById<EditText>(R.id.hour)
        val minView = findViewById<EditText>(R.id.min)
        val secView = findViewById<EditText>(R.id.sec)
        val back = findViewById<TextView>(R.id.back)

        var hour: Int = 0
        var min: Int = 0
        var sec: Int = 0

        hourView.showSoftInputOnFocus = false
        hourView.isCursorVisible = false
        minView.showSoftInputOnFocus = false
        minView.isCursorVisible = false
        secView.showSoftInputOnFocus = false
        secView.isCursorVisible = false

        hourView.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                zero.setOnClickListener {
                    if (hourView.getText().toString().length < 5) {
                        hourView.setText("${hourView.getText()}0")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                one.setOnClickListener {
                    if (hourView.getText().toString().length < 5) {
                        hourView.setText("${hourView.getText()}1")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                two.setOnClickListener {
                    if (hourView.getText().toString().length < 5) {
                        hourView.setText("${hourView.getText()}2")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                three.setOnClickListener {
                    if (hourView.getText().toString().length < 5) {
                        hourView.setText("${hourView.getText()}3")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                four.setOnClickListener {
                    if (hourView.getText().toString().length < 5) {
                        hourView.setText("${hourView.getText()}4")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                five.setOnClickListener {
                    if (hourView.getText().toString().length < 5) {
                        hourView.setText("${hourView.getText()}5")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                six.setOnClickListener {
                    if (hourView.getText().toString().length < 5) {
                        hourView.setText("${hourView.getText()}6")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                seven.setOnClickListener {
                    if (hourView.getText().toString().length < 5) {
                        hourView.setText("${hourView.getText()}7")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                eight.setOnClickListener {
                    if (hourView.getText().toString().length < 5) {
                        hourView.setText("${hourView.getText()}8")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                nine.setOnClickListener {
                    if (hourView.getText().toString().length < 5) {
                        hourView.setText("${hourView.getText()}9")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                clearEntry.setOnClickListener {
                    hourView.setText("")
                }
            }
        }

        minView.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                zero.setOnClickListener {
                    if (minView.getText().toString().length < 5) {
                        minView.setText("${minView.getText()}0")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                one.setOnClickListener {
                    if (minView.getText().toString().length < 5) {
                        minView.setText("${minView.getText()}1")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                two.setOnClickListener {
                    if (minView.getText().toString().length < 5) {
                        minView.setText("${minView.getText()}2")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                three.setOnClickListener {
                    if (minView.getText().toString().length < 5) {
                        minView.setText("${minView.getText()}3")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                four.setOnClickListener {
                    if (minView.getText().toString().length < 5) {
                        minView.setText("${minView.getText()}4")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                five.setOnClickListener {
                    if (minView.getText().toString().length < 5) {
                        minView.setText("${minView.getText()}5")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                six.setOnClickListener {
                    if (minView.getText().toString().length < 5) {
                        minView.setText("${minView.getText()}6")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                seven.setOnClickListener {
                    if (minView.getText().toString().length < 5) {
                        minView.setText("${minView.getText()}7")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                eight.setOnClickListener {
                    if (minView.getText().toString().length < 5) {
                        minView.setText("${minView.getText()}8")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                nine.setOnClickListener {
                    if (minView.getText().toString().length < 5) {
                        minView.setText("${minView.getText()}9")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                clearEntry.setOnClickListener {
                    minView.setText("")
                }
            }
        }

        secView.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                zero.setOnClickListener {
                    if (secView.getText().toString().length < 5) {
                        secView.setText("${secView.getText()}0")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                one.setOnClickListener {
                    if (secView.getText().toString().length < 5) {
                        secView.setText("${secView.getText()}1")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                two.setOnClickListener {
                    if (secView.getText().toString().length < 5) {
                        secView.setText("${secView.getText()}2")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                three.setOnClickListener {
                    if (secView.getText().toString().length < 5) {
                        secView.setText("${secView.getText()}3")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                four.setOnClickListener {
                    if (secView.getText().toString().length < 5) {
                        secView.setText("${secView.getText()}4")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                five.setOnClickListener {
                    if (secView.getText().toString().length < 5) {
                        secView.setText("${secView.getText()}5")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                six.setOnClickListener {
                    if (secView.getText().toString().length < 5) {
                        secView.setText("${secView.getText()}6")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                seven.setOnClickListener {
                    if (secView.getText().toString().length < 5) {
                        secView.setText("${secView.getText()}7")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                eight.setOnClickListener {
                    if (secView.getText().toString().length < 5) {
                        secView.setText("${secView.getText()}8")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                nine.setOnClickListener {
                    if (secView.getText().toString().length < 5) {
                        secView.setText("${secView.getText()}9")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                clearEntry.setOnClickListener {
                    secView.setText("")
                }
            }
        }

        clear.setOnClickListener {
            hourView.setText("")
            minView.setText("")
            secView.setText("")
            hour = 0
            min = 0
            sec = 0
        }

        plus.setOnClickListener {
            if (hourView.getText().toString().isNotEmpty()) {
                hour += hourView.getText().toString().toInt()
            }
            if (minView.getText().toString().isNotEmpty()) {
                min += minView.getText().toString().toInt()

            }
            if (secView.getText().toString().isNotEmpty()) {
                sec += secView.getText().toString().toInt()

            }
            hourView.setText("")
            minView.setText("")
            secView.setText("")
        }

        equal.setOnClickListener {
            if (hourView.getText().toString().isNotEmpty()) {
                hour += hourView.getText().toString().toInt()
            }
            if (minView.getText().toString().isNotEmpty()) {
                min += minView.getText().toString().toInt()
            }
            if (secView.getText().toString().isNotEmpty()) {
                sec += secView.getText().toString().toInt()
            }

            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()

            val bundle = Bundle()
            bundle.putInt("hour", hour)
            bundle.putInt("min", min)
            bundle.putInt("sec", sec)
            fragmentTransaction.replace(R.id.show, fragment.apply { arguments = bundle })
            fragmentTransaction.commit()
        }

        back.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragment)
            fragmentTransaction.commit()

            hourView.setText("")
            minView.setText("")
            secView.setText("")
            hour = 0
            min = 0
            sec = 0
        }
    }
}