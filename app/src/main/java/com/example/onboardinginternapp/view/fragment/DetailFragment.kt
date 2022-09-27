package com.example.onboardinginternapp.view.fragment

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.onboardinginternapp.R
import com.example.onboardinginternapp.databinding.FragmentDetailBinding
import com.example.onboardinginternapp.utils.Status
import com.example.onboardinginternapp.utils.errorToast
import com.example.onboardinginternapp.view.adapter.HomeAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val args: DetailFragmentArgs by navArgs()
//    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        showDetailMovie()
    }


//    @SuppressLint("SetTextI18n")
//    private fun showDetailMovie() {
//        detailViewModel.DetailMovie(args.idDetailMovie)
//        detailViewModel.getDetailMovie.observe(viewLifecycleOwner) {
//            when (it.status) {
//                Status.LOADING -> {
//
//                }
//                Status.ERROR -> {
//                    Toast(requireContext()).errorToast(it.message.toString(), requireContext())
//                }
//                Status.SUCCESS -> {
//                    it.data?.let {
//                        binding.apply {
//                            Glide.with(requireView())
//                                .load(it.backdropPath)
////                                .centerCrop()
//                                .listener(object : RequestListener<Drawable> {
//                                    override fun onLoadFailed(
//                                        e: GlideException?,
//                                        model: Any?,
//                                        target: Target<Drawable>?,
//                                        isFirstResource: Boolean
//                                    ): Boolean {
//                                        ivBackdrop.setImageResource(R.drawable.netflixlogo)
//                                        return true
//                                    }
//
//                                    override fun onResourceReady(
//                                        resource: Drawable?,
//                                        model: Any?,
//                                        target: Target<Drawable>?,
//                                        dataSource: DataSource?,
//                                        isFirstResource: Boolean
//                                    ): Boolean {
//                                        return false
//                                    }
//                                })
//                                .into(ivBackdrop)
//                            Glide.with(requireView())
//                                .load(it.posterPath)
////                                .centerCrop()
//                                .listener(object : RequestListener<Drawable> {
//                                    override fun onLoadFailed(
//                                        e: GlideException?,
//                                        model: Any?,
//                                        target: Target<Drawable>?,
//                                        isFirstResource: Boolean
//                                    ): Boolean {
//                                        ivPoster.setImageResource(R.drawable.netflixlogo)
//                                        return true
//                                    }
//
//                                    override fun onResourceReady(
//                                        resource: Drawable?,
//                                        model: Any?,
//                                        target: Target<Drawable>?,
//                                        dataSource: DataSource?,
//                                        isFirstResource: Boolean
//                                    ): Boolean {
//                                        return false
//                                    }
//                                })
//                                .into(ivPoster)
//                            tvTitle.text = it.title
//                            tvOverview.text = it.overview
//                            tvReleaseDate.text = it.releaseDate
//                            tvAverageRating.text = it.voteAverage.toString()
//                            tvRateCount.text = it.voteCount.toString()
//                            tvPopularity.text = it.popularity.toString()
//                        }
//                    }
//                }
//            }
//        }
//    }


//    private fun showDetailMovie() {
//        binding.apply {
//            Glide.with(requireView())
//                .load(HomeAdapter.posterBaseUrl + args.movie.backdropPath)
//                .into(ivBackdrop)
//            Glide.with(requireView())
//                .load(HomeAdapter.posterBaseUrl + args.movie.posterPath)
//                .into(ivPoster)
//            tvTitle.text = args.movie.title
//            tvOverview.text = args.movie.overview
//            tvReleaseDate.text = args.movie.releaseDate
//            tvAverageRating.text = args.movie.voteAverage.toString()
//            tvRateCount.text = args.movie.voteCount.toString()
//            tvPopularity.text = args.movie.popularity.toString()
//        }
//    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}