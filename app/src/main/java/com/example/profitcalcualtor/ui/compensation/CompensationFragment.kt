package com.example.profitcalcualtor.ui.compensation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.profitcalcualtor.databinding.FragmentCompensationBinding

class CompensationFragment : Fragment() {

    private var _binding: FragmentCompensationBinding? = null

    private val binding get() = _binding!!

    // RecyclerView에 사용할 어댑터 객체와 데이터를 담을 ArrayList 선언
    private lateinit var compensationAdapter: CompensationAdapter
    private val compensationList: ArrayList<String> = ArrayList()

    private var num = 0

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCompensationBinding.inflate(inflater, container, false)

        val addBtn = binding.addBtn

        compensationAdapter = CompensationAdapter(compensationList)

        // RecyclerView 설정
        binding.listCompensation.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = compensationAdapter
        }

        // 보상 목록 추가
        addBtn.setOnClickListener {
            num++
            compensationList.add("List ${num}")
            compensationAdapter.notifyItemInserted(compensationList.size - 1)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}