package br.com.zup.appmovie.feature.movie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import br.com.zup.appmovie.R
import br.com.zup.appmovie.feature.movie.viewModel.RecentMovieViewModel

class RecentMovieActivity : AppCompatActivity() {
    private lateinit var viewModel: RecentMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_movie)

        viewModel = ViewModelProviders.of(this).get(RecentMovieViewModel::class.java)
    }
}
