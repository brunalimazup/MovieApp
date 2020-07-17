package br.com.zup.appmovie.feature.detailsmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.zup.appmovie.R
import br.com.zup.appmovie.feature.detailsmovie.viewModel.DetailsMovieViewModel
import br.com.zup.appmovie.feature.interfaces.RecyclerViewClickListener
import br.com.zup.appmovie.model.MovieDetails
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details_movie.*

class DetailsMovieActivity : AppCompatActivity(), RecyclerViewClickListener {
    private lateinit var viewModel: DetailsMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        val id = intent.extras?.get("movieId") as String
        title = "Details Movies"
        viewModel = ViewModelProviders.of(this).get(DetailsMovieViewModel::class.java)
        viewModel.getDetailsMovies(id).observe(this,
            Observer<MovieDetails> { response ->
                if (response != null) {
                    var imageUrl = "https://image.tmdb.org/t/p/w185"
                    Picasso.get().load("$imageUrl${response.posterPath}").into(photo_details_movie)
                    txt_title.text = response.originalTitle
                    txt_description.text = response.overview
                    txt_note.text = response.voteAverage
                }
            })
    }

    override fun onclick(id: String) {

    }
}
