package com.example.profitcalcualtor.ui.reward

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.profitcalcualtor.databinding.FragmentRewardBinding

class RewardFragment : Fragment() {

    private var _binding: FragmentRewardBinding? = null

    private val binding get() = _binding!!

    // RecyclerView에 사용할 어댑터 객체와 데이터를 담을 ArrayList 선언
    private lateinit var rewardAdapter: RewardAdapter
    private val compensationList: ArrayList<Pair<Int, Int>> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRewardBinding.inflate(inflater, container, false)

        val addBtn = binding.addBtn
        //val totalPrice = binding.totalPrice

        rewardAdapter = RewardAdapter(compensationList)

        // RecyclerView 설정
        binding.listCompensation.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = rewardAdapter
        }

        // 보상 목록 추가
        addBtn.setOnClickListener {
            compensationList.add(Pair(0,0))
            rewardAdapter.notifyItemInserted(compensationList.size - 1)
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}