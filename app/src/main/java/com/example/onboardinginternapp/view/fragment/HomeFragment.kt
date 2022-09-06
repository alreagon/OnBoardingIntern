package com.example.onboardinginternapp.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.onboardinginternapp.R
import com.example.onboardinginternapp.databinding.FragmentHomeBinding
import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieResponse
import com.example.onboardinginternapp.utils.Resource
import com.example.onboardinginternapp.utils.Status
import com.example.onboardinginternapp.utils.errorToast
import com.example.onboardinginternapp.view.adapter.HomeAdapter
import com.example.onboardinginternapp.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModel()
    private var list = ArrayList<Movie>()
    private lateinit var recyclerView: RecyclerView
    private var homeAdapter = HomeAdapter()

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

//        homeViewModel.movie.observe(viewLifecycleOwner) { setMovieData(it) }
        // ngamatin data, kalo ada update dia jalan
        setupRecycler()
        buttonCategoryAll()
        homeViewModel.isLoading.observe(viewLifecycleOwner) { showLoading(it) }

    }

    private fun setupRecycler() {
        homeAdapter.setOnItemClickCallback(object : HomeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: MovieResponse) {
//                Toast.makeText(this@HomeFragment,"pencet ke detail", Toast.LENGTH_SHORT).show()
                homeViewModel._movie.postValue(
                    Resource.error(
                        "Kamu mencet detail",
                        null
                    )
                )
//                findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(data.id))
            }
        })
        recyclerView = binding.rvMovies
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = homeAdapter
        binding.progressBar.visibility = View.GONE
    }

    private fun buttonCategoryAll() {

        homeViewModel.getMovie()
        homeViewModel.movie.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { listMovie ->
                        list.clear()
                        homeAdapter.submitData(listMovie.take(40))
                    }
                    binding.progressBar.visibility = View.GONE
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast(requireContext()).errorToast(
                        it.message.toString(),
                        requireContext()
                    )
                }
            }
        }
    }


//    @SuppressLint("SetTextI18n")
//    private fun setMovieData(movie: List<Movie>) {
//        binding.apply {
//            val homeAdapter = HomeAdapter(movie)
//            rvMovies.setHasFixedSize(true)
//            rvMovies.layoutManager = LinearLayoutManager(activity)
//            rvMovies.adapter = homeAdapter
//            homeAdapter.setOnItemClickCallback(object :
//                HomeAdapter.OnItemClickCallback {
//                override fun onItemClicked(data: Movie) {
//                    findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(data))}
//            })
//        }
//    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}