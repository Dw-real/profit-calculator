package com.example.profitcalcualtor.ui.compensation

import com.example.profitcalcualtor.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.profitcalcualtor.databinding.ItemCompensationListBinding

class CompensationAdapter(private val data: ArrayList<String>) :
    RecyclerView.Adapter<CompensationAdapter.CompensationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompensationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCompensationListBinding.inflate(inflater, parent, false)
        return CompensationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompensationAdapter.CompensationViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class CompensationViewHolder(private val binding: ItemCompensationListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            val spinner = binding.itemList
            val items = spinner.context.resources.getStringArray(R.array.compensation_items).sorted().toTypedArray()
            val adapter = ArrayAdapter(spinner.context, android.R.layout.simple_spinner_item, items)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }
}