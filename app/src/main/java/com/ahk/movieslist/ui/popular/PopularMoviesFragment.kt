package com.ahk.movieslist.ui.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.ahk.movieslist.R
import com.ahk.movieslist.databinding.FragmentPopularMoviesBinding

class PopularMoviesFragment : Fragment() {

    lateinit var binding: FragmentPopularMoviesBinding

    val viewModel: PopularMovieViewModel by viewModels()

    val movieAdapter = PopularMoviePagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setRecyclerView()

        viewModel.list.observe(viewLifecycleOwner){
            movieAdapter.submitData(lifecycle, it)
        }
    }

    private fun setRecyclerView() {
        binding.popularFragMovieList.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }
}