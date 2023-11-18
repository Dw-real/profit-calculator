package com.example.profitcalcualtor.ui.reward

import com.example.profitcalcualtor.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.profitcalcualtor.databinding.ItemCompensationListBinding

class RewardAdapter(private val data: ArrayList<Pair<Int, Int>>) :
    RecyclerView.Adapter<RewardAdapter.CompensationViewHolder>() {

    var totalSum: Int = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompensationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCompensationListBinding.inflate(inflater, parent, false)
        return CompensationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RewardAdapter.CompensationViewHolder, position: Int) {
        holder.bind(data[position])
        holder.bindEditTextListeners(position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class CompensationViewHolder(private val binding: ItemCompensationListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Pair<Int, Int>) {
            val spinner = binding.itemList
            val items = spinner.context.resources.getStringArray(R.array.compensation_items).sorted().toTypedArray()
            val adapter = ArrayAdapter(spinner.context, android.R.layout.simple_spinner_item, items)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter

        }

        fun bindEditTextListeners(position: Int) {
            binding.numberEditText.setOnFocusChangeListener {_, _, -> updateTotalSum(position)}
            binding.priceEditText.setOnFocusChangeListener {_, _, -> updateTotalSum(position)}
        }

        private fun updateTotalSum(position: Int) {
            val number =  binding.numberEditText.text.toString().toIntOrNull() ?: 0
            val price =  binding.priceEditText.text.toString().toIntOrNull() ?: 0

            data[position] = Pair(number, price)

            totalSum = data.sumOf { it.first * it.second }
        }
    }
}