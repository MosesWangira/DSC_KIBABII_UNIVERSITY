package com.example.dscmeetupkibabiiuniversity.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.dscmeetupkibabiiuniversity.R
import com.example.dscmeetupkibabiiuniversity.ui.onboard.activity.Onboarding
import kotlinx.android.synthetic.main.activity_splash_screen.*

internal class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar!!.hide()

        val myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition)
        logo!!.startAnimation(myanim)
        dsc!!.startAnimation(myanim)


        val i = Intent(this, Onboarding::class.java)
        //Async task
        val timer = object : Thread() {
            override fun run() {
                try {
                    sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(i)
                    finish()
                }
            }
        }
        timer.start()
    }
}

