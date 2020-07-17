package br.com.zup.appmovie.feature.recentmovie.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import br.com.zup.appmovie.data.repository.MovieRepository
import br.com.zup.appmovie.model.DiscoveryResponse

class RecentMovieViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = MovieRepository()

    fun getRecentMovies(): LiveData<DiscoveryResponse> {
        return repository.getRecentMovies()
    }

}