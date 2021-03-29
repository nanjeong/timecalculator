package com.example.timecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.result_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = view.findViewById<TextView>(R.id.result)
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

        if (hour < 10) {
            result.text = String.format("%02d : %02d : %02d", hour, min, sec)
        } else {
            result.text = String.format("%d : %02d : %02d", hour, min, sec)
        }

    }
}