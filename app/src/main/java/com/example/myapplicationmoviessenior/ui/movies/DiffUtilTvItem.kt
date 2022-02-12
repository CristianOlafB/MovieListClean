package com.example.myapplicationmoviessenior.ui.movies

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.Tv

class DiffUtilTvItem() : DiffUtil.ItemCallback<Tv>() {
    override fun areItemsTheSame(oldItem: Tv, newItem: Tv): Boolean {
        return oldItem.originalName == newItem.originalName
    }

    override fun areContentsTheSame(oldItem: Tv, newItem: Tv): Boolean {
        return oldItem == newItem
    }
}