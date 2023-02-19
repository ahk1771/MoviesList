package com.ahk.movieslist.ui.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.ahk.movieslist.remote.Request

class PopularMovieViewModel : ViewModel() {

    val list = Pager(PagingConfig(pageSize = 10)){
        PopularMoviePaging(Request.retrofitInterface())
    }.liveData.cachedIn(viewModelScope)
}