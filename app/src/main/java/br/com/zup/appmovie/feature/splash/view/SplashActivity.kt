package br.com.zup.appmovie.feature.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.zup.appmovie.R
import br.com.zup.appmovie.feature.menu.view.MenuActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed(Runnable {

            val i = Intent(this@SplashActivity, MenuActivity::class.java)
            startActivity(i)
            finish()

        }, 5000)
    }
}
