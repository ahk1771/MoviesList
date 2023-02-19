package com.ahk.movieslist.ui.latest

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ahk.movieslist.data.Movie
import com.ahk.movieslist.remote.MovieInterface
import com.ahk.movieslist.utils.Constants
import java.lang.Exception

class LatestMoviePaging(val movieInterface: MovieInterface) : PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1)?:anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        val page = params.key?:1

        return try{

            val data = movieInterface.getLatestMovies(Constants.API_KEY, page)

            LoadResult.Page(
                data = data.body()?.results!!,
                prevKey = if(page==1) null else page-1,
                nextKey = if(data.body()?.results!!.isEmpty()) null else page+1
            )
        }
        catch (e:Exception){
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }
}