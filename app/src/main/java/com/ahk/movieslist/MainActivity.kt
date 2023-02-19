package com.ahk.movieslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ahk.movieslist.databinding.ActivityMainBinding
import com.ahk.movieslist.remote.MovieInterface
import com.ahk.movieslist.remote.Request
import com.ahk.movieslist.ui.latest.LatestMoviesFragment
import com.ahk.movieslist.ui.popular.PopularMoviesFragment
import com.ahk.movieslist.utils.Constants
import okhttp3.ResponseBody
import retrofit2.Call

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        switchFragment(PopularMoviesFragment())

        binding.mainBottomNav.setOnItemSelectedListener {

            when(it.itemId){

                R.id.menu_popular -> switchFragment(PopularMoviesFragment())

                R.id.menu_latest -> switchFragment(LatestMoviesFragment())

                else -> {}
            }

            true
        }


    }

    private fun switchFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_frameLayout, fragment)
        fragmentTransaction.commit()
    }
}