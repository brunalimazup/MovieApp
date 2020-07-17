package br.com.zup.appmovie.feature.recentmovie.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.appmovie.R
import br.com.zup.appmovie.feature.detailsmovie.view.DetailsMovieActivity
import br.com.zup.appmovie.feature.interfaces.RecyclerViewClickListener
import br.com.zup.appmovie.feature.recentmovie.adapter.RecentMovieListAdapter
import br.com.zup.appmovie.feature.recentmovie.viewModel.RecentMovieViewModel
import br.com.zup.appmovie.model.DiscoveryResponse
import br.com.zup.appmovie.model.Movie
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.activity_recent_movie.*
import kotlinx.android.synthetic.main.recent_movies_item.*

class RecentMovieActivity : AppCompatActivity(), RecyclerViewClickListener {
    private lateinit var viewModel: RecentMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_movie)
        title = "Recent Movies"
        viewModel = ViewModelProviders.of(this).get(RecentMovieViewModel::class.java)
        viewModel.getRecentMovies().observe(this,
            Observer<DiscoveryResponse> { response ->
                if (response != null) {
                    createListAdapter(response.results)
                }
            })
    }

    fun createListAdapter(movies: List<Movie>) {
        val adapter = RecentMovieListAdapter(this, movies, this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onclick(id: String) {
        val intent = Intent(this, DetailsMovieActivity::class.java)
        intent.putExtra("movieId",id )
        startActivity(intent)
    }
}
