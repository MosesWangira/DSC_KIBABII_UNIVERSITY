package com.example.dscmeetupkibabiiuniversity.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dscmeetupkibabiiuniversity.R

class Profile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        supportActionBar!!.hide()
    }
}
