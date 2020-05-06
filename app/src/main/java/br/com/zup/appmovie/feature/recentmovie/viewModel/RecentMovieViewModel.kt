package br.com.zup.appmovie.feature.recentmovie.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import br.com.zup.appmovie.data.repository.MovieRepository
import br.com.zup.appmovie.model.RecentMovies

class RecentMovieViewModel (application: Application) : AndroidViewModel(application){
    private val repository = MovieRepository()

    fun getMovieById(id: String) : LiveData<RecentMovies>{
        return repository.getMovieById(id)
    }
}