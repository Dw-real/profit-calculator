package com.example.profitcalcualtor.ui.compensation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.profitcalcualtor.databinding.FragmentCompensationBinding

class CompensationFragment : Fragment() {

    private var _binding: FragmentCompensationBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val CompensationViewModel =
            ViewModelProvider(this).get(CompensationViewModel::class.java)

        _binding = FragmentCompensationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}