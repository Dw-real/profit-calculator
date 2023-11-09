package com.example.profitcalcualtor.ui.compensation

import android.view.LayoutInflater
import android.view.ViewGroup
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

    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class CompensationViewHolder(private val binding: ItemCompensationListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            
        }
    }
}