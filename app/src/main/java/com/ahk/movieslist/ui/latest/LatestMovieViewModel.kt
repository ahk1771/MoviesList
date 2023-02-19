package com.ahk.movieslist.ui.latest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.ahk.movieslist.remote.MovieInterface
import com.ahk.movieslist.remote.Request

class LatestMovieViewModel : ViewModel() {

    val list = Pager(PagingConfig(pageSize = 10)){
        LatestMoviePaging(Request.retrofitInterface())
    }.liveData.cachedIn(viewModelScope)
}