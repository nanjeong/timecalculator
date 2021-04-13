package com.example.timecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.*
import com.example.timecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val fragment: ResultFragment = ResultFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var hour: Int = 0
        var min: Int = 0
        var sec: Int = 0

        binding.hour.showSoftInputOnFocus = false
        binding.hour.isCursorVisible = false
        binding.min.showSoftInputOnFocus = false
        binding.min.isCursorVisible = false
        binding.sec.showSoftInputOnFocus = false
        binding.sec.isCursorVisible = false

        binding.hour.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.zero.setOnClickListener {
                    if (binding.hour.getText().toString().length < 5) {
                        binding.hour.setText("${binding.hour.getText()}0")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.one.setOnClickListener {
                    if (binding.hour.getText().toString().length < 5) {
                        binding.hour.setText("${binding.hour.getText()}1")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.two.setOnClickListener {
                    if (binding.hour.getText().toString().length < 5) {
                        binding.hour.setText("${binding.hour.getText()}2")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.three.setOnClickListener {
                    if (binding.hour.getText().toString().length < 5) {
                        binding.hour.setText("${binding.hour.getText()}3")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.four.setOnClickListener {
                    if (binding.hour.getText().toString().length < 5) {
                        binding.hour.setText("${binding.hour.getText()}4")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.five.setOnClickListener {
                    if (binding.hour.getText().toString().length < 5) {
                        binding.hour.setText("${binding.hour.getText()}5")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.six.setOnClickListener {
                    if (binding.hour.getText().toString().length < 5) {
                        binding.hour.setText("${binding.hour.getText()}6")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.seven.setOnClickListener {
                    if (binding.hour.getText().toString().length < 5) {
                        binding.hour.setText("${binding.hour.getText()}7")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.eight.setOnClickListener {
                    if (binding.hour.getText().toString().length < 5) {
                        binding.hour.setText("${binding.hour.getText()}8")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.nine.setOnClickListener {
                    if (binding.hour.getText().toString().length < 5) {
                        binding.hour.setText("${binding.hour.getText()}9")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.clearEntry.setOnClickListener {
                    binding.hour.setText("")
                }
            }
        }

        binding.min.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.zero.setOnClickListener {
                    if (binding.min.getText().toString().length < 5) {
                        binding.min.setText("${binding.min.getText()}0")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.one.setOnClickListener {
                    if (binding.min.getText().toString().length < 5) {
                        binding.min.setText("${binding.min.getText()}1")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.two.setOnClickListener {
                    if (binding.min.getText().toString().length < 5) {
                        binding.min.setText("${binding.min.getText()}2")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.three.setOnClickListener {
                    if (binding.min.getText().toString().length < 5) {
                        binding.min.setText("${binding.min.getText()}3")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.four.setOnClickListener {
                    if (binding.min.getText().toString().length < 5) {
                        binding.min.setText("${binding.min.getText()}4")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.five.setOnClickListener {
                    if (binding.min.getText().toString().length < 5) {
                        binding.min.setText("${binding.min.getText()}5")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.six.setOnClickListener {
                    if (binding.min.getText().toString().length < 5) {
                        binding.min.setText("${binding.min.getText()}6")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.seven.setOnClickListener {
                    if (binding.min.getText().toString().length < 5) {
                        binding.min.setText("${binding.min.getText()}7")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.eight.setOnClickListener {
                    if (binding.min.getText().toString().length < 5) {
                        binding.min.setText("${binding.min.getText()}8")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.nine.setOnClickListener {
                    if (binding.min.getText().toString().length < 5) {
                        binding.min.setText("${binding.min.getText()}9")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.clearEntry.setOnClickListener {
                    binding.min.setText("")
                }
            }
        }

        binding.sec.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                binding.zero.setOnClickListener {
                    if (binding.sec.getText().toString().length < 5) {
                        binding.sec.setText("${binding.sec.getText()}0")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.one.setOnClickListener {
                    if (binding.sec.getText().toString().length < 5) {
                        binding.sec.setText("${binding.sec.getText()}1")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.two.setOnClickListener {
                    if (binding.sec.getText().toString().length < 5) {
                        binding.sec.setText("${binding.sec.getText()}2")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.three.setOnClickListener {
                    if (binding.sec.getText().toString().length < 5) {
                        binding.sec.setText("${binding.sec.getText()}3")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.four.setOnClickListener {
                    if (binding.sec.getText().toString().length < 5) {
                        binding.sec.setText("${binding.sec.getText()}4")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.five.setOnClickListener {
                    if (binding.sec.getText().toString().length < 5) {
                        binding.sec.setText("${binding.sec.getText()}5")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.six.setOnClickListener {
                    if (binding.sec.getText().toString().length < 5) {
                        binding.sec.setText("${binding.sec.getText()}6")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.seven.setOnClickListener {
                    if (binding.sec.getText().toString().length < 5) {
                        binding.sec.setText("${binding.sec.getText()}7")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.eight.setOnClickListener {
                    if (binding.sec.getText().toString().length < 5) {
                        binding.sec.setText("${binding.sec.getText()}8")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.nine.setOnClickListener {
                    if (binding.sec.getText().toString().length < 5) {
                        binding.sec.setText("${binding.sec.getText()}9")
                    } else {
                        Toast.makeText(this, "5자리까지 입력할 수 있습니다.", Toast.LENGTH_SHORT).show()
                    }
                }
                binding.clearEntry.setOnClickListener {
                    binding.sec.setText("")
                }
            }
        }

        binding.clear.setOnClickListener {
            binding.hour.setText("")
            binding.min.setText("")
            binding.sec.setText("")
            hour = 0
            min = 0
            sec = 0
        }

        binding.plus.setOnClickListener {
            if (binding.hour.getText().toString().isNotEmpty()) {
                hour += binding.hour.getText().toString().toInt()
            }
            if (binding.min.getText().toString().isNotEmpty()) {
                min += binding.min.getText().toString().toInt()

            }
            if (binding.sec.getText().toString().isNotEmpty()) {
                sec += binding.sec.getText().toString().toInt()

            }
            binding.hour.setText("")
            binding.min.setText("")
            binding.sec.setText("")
        }

        binding.equal.setOnClickListener {
            if (binding.hour.getText().toString().isNotEmpty()) {
                hour += binding.hour.getText().toString().toInt()
            }
            if (binding.min.getText().toString().isNotEmpty()) {
                min += binding.min.getText().toString().toInt()
            }
            if (binding.sec.getText().toString().isNotEmpty()) {
                sec += binding.sec.getText().toString().toInt()
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

        binding.back.setOnClickListener {
            val fragmentManager: FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.remove(fragment)
            fragmentTransaction.commit()

            binding.hour.setText("")
            binding.min.setText("")
            binding.sec.setText("")
            hour = 0
            min = 0
            sec = 0

            binding.hour.clearFocus()
            binding.min.clearFocus()
            binding.sec.clearFocus()
        }
    }
}