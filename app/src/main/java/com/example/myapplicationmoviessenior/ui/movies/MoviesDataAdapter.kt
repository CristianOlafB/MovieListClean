package com.example.myapplicationmoviessenior.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.Movies.Companion.HIGH_IMG
import com.example.myapplicationmoviessenior.R
import com.example.myapplicationmoviessenior.databinding.ItemMovieBinding
import javax.inject.Inject

class MoviesDataAdapter @Inject constructor() :
    RecyclerView.Adapter<MoviesDataAdapter.ViewHolder>() {

    private val callback = DiffUtilMovieItem()

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
            holder.binding.tvName.text = categories.title
            Glide.with(holder.binding.ivAvatar.context)
                .load(HIGH_IMG + categories.backdrop_path)
                .into(holder.binding.ivAvatar)

            holder.binding.ivAvatar.setOnClickListener { view ->
                val directions = MoviesFragmentDirections.actionMoviesFragmentToDetailsFragment(
                    categories.title.toString(),
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