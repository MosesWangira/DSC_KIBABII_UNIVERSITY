package com.example.dscmeetupkibabiiuniversity.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.dscmeetupkibabiiuniversity.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar!!.hide()

        val myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition)
        logo!!.startAnimation(myanim)
        dsc!!.startAnimation(myanim)


        val i = Intent(this, Register::class.java)
        //Async task
        val timer = object : Thread() {
            override fun run() {
                try {
                    sleep(5000)
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
