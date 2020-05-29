package br.com.zup.appmovie.feature.recentmovie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.appmovie.R
import br.com.zup.appmovie.model.Movie
import kotlinx.android.synthetic.main.recent_movies_item.view.*

class RecentMovieListAdapter(
    private val context: Context,
    private val movies: List<Movie>
) : RecyclerView.Adapter<RecentMovieListAdapter.RecentMovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentMovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recent_movies_item, parent, false)
        return RecentMovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: RecentMovieViewHolder, position: Int) {
        val recentMovie = movies[position]
        holder.populateView(recentMovie)
    }

    class RecentMovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var id: String
        fun populateView(movies: Movie) {
            itemView.text_view_recent_movie.text = movies.originalTitle
        }

    }
}