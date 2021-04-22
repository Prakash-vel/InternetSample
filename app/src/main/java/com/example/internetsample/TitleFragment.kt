package com.example.internetsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.internetsample.databinding.FragmentTitleBinding


class TitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding= FragmentTitleBinding.inflate(inflater)
        val viewModel= ViewModelProviders.of(this).get(MainViewModel::class.java)


        val adapter=QuotesAdapter()
        binding.quoteView.adapter=adapter
        viewModel.properties.observe(viewLifecycleOwner, Observer {
            if(it != null){
                adapter.submitList(it)
            }

        })
        return binding.root

    }

}