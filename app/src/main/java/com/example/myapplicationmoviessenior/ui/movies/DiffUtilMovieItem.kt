package com.example.myapplicationmoviessenior.ui.movies

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.Movies

class DiffUtilMovieItem : DiffUtil.ItemCallback<Movies>() {
    override fun areItemsTheSame(oldItem: Movies, newItem: Movies): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Movies, newItem: Movies): Boolean {
        return oldItem == newItem
    }
}