package com.dsc.kibu.ui.onboard.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dsc.kibu.R

internal class Onboarding : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_activity)

        supportActionBar!!.hide()
    }
}
