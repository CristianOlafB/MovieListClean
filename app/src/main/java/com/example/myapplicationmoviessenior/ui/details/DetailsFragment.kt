package com.example.myapplicationmoviessenior.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.domain.model.Movies
import com.example.myapplicationmoviessenior.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    private val args: DetailsFragmentArgs by navArgs()

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setActionBarTitle(args.pageTitle)
        binding.tvName.text = args.pageTitle
        Glide.with(binding.imgImage)
            .load(Movies.HIGH_IMG + args.pageImg)
            .into(binding.imgImage)
        binding.tvDesc.text = args.pageDescription
    }

    private fun setActionBarTitle(title: String) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = title
    }

}