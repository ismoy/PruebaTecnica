package com.ismoyb.pruebatecnica.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.ismoyb.pruebatecnica.R
import com.ismoyb.pruebatecnica.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private lateinit var binding:FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = arguments?.let { DetailsFragmentArgs.fromBundle(it).myData }
        Glide.with(requireContext())
            .load(data)
            .placeholder(R.drawable.default_image)
            .error(R.drawable.default_image)
            .into(binding.fullImage)

    }

}