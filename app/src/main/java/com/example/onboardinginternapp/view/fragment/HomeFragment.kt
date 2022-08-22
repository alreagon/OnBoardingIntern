package com.example.onboardinginternapp.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onboardinginternapp.R
import com.example.onboardinginternapp.databinding.FragmentHomeBinding
import com.example.onboardinginternapp.model.Movie
import com.example.onboardinginternapp.view.adapter.HomeAdapter
import com.example.onboardinginternapp.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.movie.observe(viewLifecycleOwner) { setMovieData(it) }

        viewModel.isLoading.observe(viewLifecycleOwner) { showLoading(it) }

    }

    @SuppressLint("SetTextI18n")
    private fun setMovieData(movie: List<Movie>) {
        binding.apply {
            val homeAdapter = HomeAdapter(movie)
            rvMovies.setHasFixedSize(true)
            rvMovies.layoutManager = LinearLayoutManager(activity)
            rvMovies.adapter = homeAdapter
            homeAdapter.setOnItemClickCallback(object :
                HomeAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Movie) {
                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(data))}
            })
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}