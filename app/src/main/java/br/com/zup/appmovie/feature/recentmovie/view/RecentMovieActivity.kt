package br.com.zup.appmovie.feature.recentmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.lifecycle.ViewModelProviders
import br.com.zup.appmovie.R
import br.com.zup.appmovie.feature.recentmovie.viewModel.RecentMovieViewModel
import kotlinx.android.synthetic.main.activity_recent_movie.*

class RecentMovieActivity : AppCompatActivity() {
    private lateinit var viewModel: RecentMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recent_movie)

        viewModel = ViewModelProviders.of(this).get(RecentMovieViewModel::class.java)
    }





}
