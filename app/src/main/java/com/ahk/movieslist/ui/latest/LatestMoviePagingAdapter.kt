package com.ahk.movieslist.ui.latest

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ahk.movieslist.BR
import com.ahk.movieslist.data.Movie
import com.ahk.movieslist.databinding.MovieCardBinding


import com.ahk.movieslist.utils.Constants

class LatestMoviePagingAdapter: PagingDataAdapter<Movie, LatestMoviePagingAdapter.MyViewHolder>(
    DIFF_UTIL) {


    companion object{
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Movie>(){
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class MyViewHolder(val viewDataBinding: MovieCardBinding): RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.setVariable(BR.movie,getItem(position))
        holder.viewDataBinding.setVariable(BR.images,Constants)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MovieCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

}