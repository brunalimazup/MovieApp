package br.com.zup.appmovie.feature.recentmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.zup.appmovie.R
import br.com.zup.appmovie.feature.interfaces.RecyclerViewClickListener
import br.com.zup.appmovie.feature.recentmovie.adapter.RecentMovieListAdapter
import br.com.zup.appmovie.feature.recentmovie.viewModel.RecentMovieViewModel
import br.com.zup.appmovie.model.DiscoveryResponse
import br.com.zup.appmovie.model.Movie
import kotlinx.android.synthetic.main.activity_recent_movie.*

class RecentMovieActivity : AppCompatActivity(), RecyclerViewClickListener {
    private lateinit var viewModel: RecentMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_movie)
        setTitle("Recent Movies")
        viewModel = ViewModelProviders.of(this).get(RecentMovieViewModel::class.java)
        viewModel.getRecentMovies().observe(this,
            Observer<DiscoveryResponse> { response ->
                if (response != null) {
                    createListAdapter(response.results)
                }
            })
    }

    fun createListAdapter(movies: List<Movie>) {
        val adapter = RecentMovieListAdapter(this, movies)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


    override fun onclick(id: Int) {

    }


}
