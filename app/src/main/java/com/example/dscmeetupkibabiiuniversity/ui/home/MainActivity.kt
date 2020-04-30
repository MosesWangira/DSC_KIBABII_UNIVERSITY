package com.example.dscmeetupkibabiiuniversity.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.dscmeetupkibabiiuniversity.BuildConfig
import com.example.dscmeetupkibabiiuniversity.R
import kotlinx.android.synthetic.main.activity_main.*


internal class MainActivity : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        setContentView(R.layout.test)

        version_text.text = "v${BuildConfig.VERSION_NAME}"

        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()
        bottom_nav.setupWithNavController(navController = navController)
    }
}