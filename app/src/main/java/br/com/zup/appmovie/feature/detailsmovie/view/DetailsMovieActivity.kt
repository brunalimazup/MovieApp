package br.com.zup.appmovie.feature.detailsmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.zup.appmovie.R
import br.com.zup.appmovie.feature.recentmovie.viewModel.RecentMovieViewModel
import br.com.zup.appmovie.model.DiscoveryResponse

class DetailsMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        title = "Details Movies"


        viewModel = ViewModelProviders.of(this).get(RecentMovieViewModel::class.java)
        viewModel.getRecentMovies().observe(
            this,
            Observer<DiscoveryResponse> { response ->
                if (response != null) {
                    (response.results)
                }
//        var id = intent.extras?.get("movieId") as String
//        Toast.makeText(this, id, Toast.LENGTH_SHORT).show()

            }
    }
