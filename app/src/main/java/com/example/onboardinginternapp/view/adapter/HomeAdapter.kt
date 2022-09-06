package com.example.onboardinginternapp.view.adapter

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.onboardinginternapp.R
import com.example.onboardinginternapp.databinding.ItemMovieBinding
import com.example.onboardinginternapp.data.remote.model.Movie
import com.example.onboardinginternapp.data.remote.model.MovieResponse


class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private var list = ArrayList<MovieResponse>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    companion object {
        const val posterBaseUrl = "https://image.tmdb.org/t/p/w500"
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MovieResponse)
    }

    class ViewHolder(var binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun submitData(data: List<MovieResponse>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movieResponse = list[position]

        val results = movieResponse.results

        val poster = posterBaseUrl + results[0].posterPath
        val title = results[0].title
        val releaseDate = results[0].releaseDate
        val averageRating = results[0].voteAverage.toString()

//        val poster = posterBaseUrl + movieResponse.posterPath
//        val title = movieResponse.title
//        val releaseDate = movieResponse.releaseDate
//        val averageRating = movieResponse.voteAverage.toString()


        holder.binding.apply {
            Glide.with(holder.itemView.context)
                .load(poster)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        holder.binding.ivPoster.setImageResource(R.drawable.netflixlogo)
                        return true
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }
                })
                .into(holder.binding.ivPoster)
            tvTitle.text = title
            tvReleaseDate.text = releaseDate
            tvAverageRating.text = averageRating
            ivCard.setOnClickListener {
                onItemClickCallback.onItemClicked(movieResponse)
            }

        }
    }

    override fun getItemCount() = list.size

}


//class HomeAdapter(private val listMovie: List<Movie>) :
//    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
//    private lateinit var onItemClickCallback: OnItemClickCallback
//
//    companion object {
//        const val posterBaseUrl = "https://image.tmdb.org/t/p/w500"
//    }
//
//    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
//        this.onItemClickCallback = onItemClickCallback
//    }
//
//    interface OnItemClickCallback {
//        fun onItemClicked(data: Movie)
//    }
//
//    class ViewHolder(var binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        // dipanggil ketika layout belum ready
//        // gk bisa set vaue disini
//        // biasanya buat perhitungan data yg mau ditampilin di view, nanti di BindViewHoldernya tinggal ditampilin
//        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        // ketika semuanya sudah ready, baru dipanggil
//        val movieResponse = listMovie[position]
//        val poster = posterBaseUrl + movieResponse.posterPath
//        val title = movieResponse.title
//        val releaseDate = movieResponse.releaseDate
//        val averageRating = movieResponse.voteAverage.toString()
//
//        Log.d("adapter", "onBindViewHolder: $poster")
//        holder.binding.apply {
//            Glide.with(holder.itemView.context).load(poster).into(ivPoster)
//            tvTitle.text = title
//            tvReleaseDate.text = releaseDate
//            tvAverageRating.text = averageRating
//            tvReadMore.setOnClickListener {
//                onItemClickCallback.onItemClicked(listMovie[holder.adapterPosition])
//            }
//        }
//    }
//
//    override fun getItemCount() = listMovie.size
//}