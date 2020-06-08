package br.com.zup.appmovie.feature.menu.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.zup.appmovie.R
import br.com.zup.appmovie.feature.favoritemovie.view.FavoriteMovieActivity
import br.com.zup.appmovie.feature.recentmovie.view.RecentMovieActivity
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setTitle("Options Menu")

        configureButton()
    }

    private fun configureButton() {
        btnRecentMovies.setOnClickListener {
            val intent = Intent(this, RecentMovieActivity::class.java)
            startActivity(intent)

            btnFavoriteMovies.setOnClickListener {
                val intent = Intent(this, FavoriteMovieActivity::class.java)
                startActivity(intent)
            }

        }
    }
}
