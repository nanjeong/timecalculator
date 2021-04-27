package com.example.timecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.timecalculator.databinding.ResultFragmentBinding

class ResultFragment : Fragment() {

    private lateinit var binding: ResultFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.result_fragment, container, false)
        val bundle = arguments

        var hour = bundle?.getInt("hour") ?: 0
        var min = bundle?.getInt("min") ?: 0
        var sec = bundle?.getInt("sec") ?: 0

        calc(hour, min, sec).let {
            hour = it.first
            min = it.second
            sec = it.third
        }

        binding.apply {
            resultTime = if (hour < 10) {
                ResultTime(String.format("%02d : %02d : %02d", hour, min, sec))
            } else {
                ResultTime(String.format("%d : %02d : %02d", hour, min, sec))
            }
        }
        return binding.root
    }

    private fun calc(h: Int, m: Int, s: Int): Triple<Int, Int, Int> {
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
}