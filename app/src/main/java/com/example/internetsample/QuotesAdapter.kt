package com.example.internetsample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.internetsample.databinding.FragmentTitleBinding

import com.example.internetsample.databinding.ListItemQuoteBinding


class QuotesAdapter: ListAdapter<QuotesProperty,QuotesAdapter.ViewHolder>(DiffUtilCallBack()) {
    class ViewHolder(private val binding: ListItemQuoteBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(quotesProperty: QuotesProperty){
            binding.quoteProperty=quotesProperty
            binding.authorName.text=quotesProperty.author


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemQuoteBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item: QuotesProperty=getItem(position)
       return holder.bind(item)
    }

}

class DiffUtilCallBack:DiffUtil.ItemCallback<QuotesProperty>() {
    override fun areItemsTheSame(oldItem: QuotesProperty, newItem: QuotesProperty): Boolean {
       return oldItem.qoute==newItem.qoute
    }

    override fun areContentsTheSame(oldItem: QuotesProperty, newItem: QuotesProperty): Boolean {
        return oldItem==newItem
    }

}
