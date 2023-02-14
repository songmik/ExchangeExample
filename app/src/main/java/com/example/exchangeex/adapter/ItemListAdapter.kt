package com.example.exchangeex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exchangeex.api.model.ExchangeResponse
import com.example.exchangeex.databinding.ItemListBinding

class ItemListAdapter(var exchangeList: ArrayList<ExchangeResponse>) : RecyclerView.Adapter< ItemListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding : ItemListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(exchangeList: ArrayList<ExchangeResponse>, position: Int) {
            binding.getNationNameTV.text = exchangeList[adapterPosition].CUR_NM
            binding.getCodeNameTV.text = exchangeList[adapterPosition].CUR_UNIT
            binding.getMoneyTV.text = exchangeList[adapterPosition].TTB
            binding.sendMoneyTV.text = exchangeList[adapterPosition].TTS
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(exchangeList, position)
    }

    override fun getItemCount(): Int {
        return exchangeList.size
    }
}