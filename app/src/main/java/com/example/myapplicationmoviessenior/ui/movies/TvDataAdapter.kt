package com.example.myapplicationmoviessenior.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.Movies
import com.example.myapplicationmoviessenior.R
import com.example.myapplicationmoviessenior.databinding.ItemMovieBinding
import javax.inject.Inject

class TvDataAdapter @Inject constructor() :
    RecyclerView.Adapter<TvDataAdapter.ViewHolder>() {

    private val callback = DiffUtilTvItem()

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding) {
            val categories = differ.currentList[position]
            holder.binding.tvName.text = categories.originalName
            Glide.with(holder.binding.ivAvatar.context)
                .load(Movies.HIGH_IMG + categories.backdrop_path)
                .into(holder.binding.ivAvatar)

            holder.binding.ivAvatar.setOnClickListener { view ->
                val directions = MoviesFragmentDirections.actionMoviesFragmentToDetailsFragment(
                    categories.originalName.toString(),
                    categories.backdrop_path.toString(),
                    categories.overview.toString()
                )
                view.findNavController().navigate(directions)
            }
        }
    }

    class ViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = differ.currentList.size

    override fun getItemViewType(position: Int) = R.layout.item_movie

}