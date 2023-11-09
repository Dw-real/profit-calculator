package com.example.profitcalcualtor.ui.compensation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.profitcalcualtor.databinding.FragmentCompensationBinding
import com.example.profitcalcualtor.databinding.ItemCompensationListBinding

class CompensationFragment : Fragment() {

    private var _binding: FragmentCompensationBinding? = null

    private val binding get() = _binding!!

    // RecyclerView에 사용할 어댑터 객체와 데이터를 담을 ArrayList 선언
    private lateinit var compensationAdapter: CompensationAdapter
    private val compensationList: ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompensationBinding.inflate(inflater, container, false)

        val addBtn = binding.addBtn
        val deleteBtn = binding.deleteBtn

        compensationAdapter = CompensationAdapter(compensationList)

        // RecyclerView 설정
        binding.listCompensation.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = compensationAdapter
        }

        // 보상 목록 추가
        addBtn.setOnClickListener {
            compensationList.add("hi")
            compensationAdapter.notifyDataSetChanged()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}