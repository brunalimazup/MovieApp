package br.com.zup.appmovie.feature.detailsmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.zup.appmovie.R

class DetailsMovieActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_movie)
        title = "Details Movies"
        var id = intent.extras?.get("movieId") as String
        Toast.makeText(this, id, Toast.LENGTH_SHORT).show()

    }
}
