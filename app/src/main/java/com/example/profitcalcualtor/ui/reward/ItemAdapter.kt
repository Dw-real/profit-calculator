package com.example.profitcalcualtor.ui.reward

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.annotation.LayoutRes
import com.example.profitcalcualtor.databinding.ItemCompensationListBinding

class ItemAdapter(context: Context, @LayoutRes private val resId: Int, private val itemList: List<String>)
    : ArrayAdapter<String>(context, resId, itemList) {

    // 드롭다운하지 않은 상태의 Spinner 항목의 뷰
    override fun getView(position: Int, converView: View?, parent: ViewGroup): View {
        val binding = ItemCompensationListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return binding.root
    }

    // 드롭다운된 항목들 리스트의 뷰
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemCompensationListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return binding.root
    }

    override fun getCount() = itemList.size
}
