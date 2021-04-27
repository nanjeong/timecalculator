package com.example.timecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = arguments

        var hour = bundle?.getInt("hour") ?: 0
        var min = bundle?.getInt("min") ?: 0
        var sec = bundle?.getInt("sec") ?: 0

        val overSec = sec / 60
        val remainSec = sec % 60
        sec = remainSec
        min += overSec

        val overMin = min / 60
        val remainMin = min % 60
        min = remainMin
        hour += overMin

        binding.apply {
            resultTime = if (hour < 10) {
                ResultTime(String.format("%02d : %02d : %02d", hour, min, sec))
            } else {
                ResultTime(String.format("%d : %02d : %02d", hour, min, sec))
            }
        }


    }
}