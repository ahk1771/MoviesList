package com.ahk.movieslist.ui.latest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.ahk.movieslist.databinding.FragmentLatestMoviesBinding


class LatestMoviesFragment : Fragment() {

    lateinit var binding: FragmentLatestMoviesBinding

    val viewModel: LatestMovieViewModel by viewModels()

    val movieAdapter = LatestMoviePagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLatestMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setRecyclerView()

        viewModel.list.observe(viewLifecycleOwner){
            movieAdapter.submitData(lifecycle, it)
        }
    }

    private fun setRecyclerView() {
        binding.latestFragMovieList.apply {
            adapter = movieAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }
}