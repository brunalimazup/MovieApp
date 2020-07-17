package br.com.zup.appmovie.feature.detailsmovie.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.zup.appmovie.data.repository.MovieRepository
import br.com.zup.appmovie.model.MovieDetails

class DetailsMovieViewModel (application: Application) : AndroidViewModel(application) {
    private val repository = MovieRepository()

    fun getDetailsMovies(id: String): MutableLiveData<MovieDetails> {
        return repository.getDetailsMovies(id)
    }
}