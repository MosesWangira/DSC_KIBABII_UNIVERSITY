package com.example.dscmeetupkibabiiuniversity.ui.onboard.viewmodel

import android.content.Intent
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.dscmeetupkibabiiuniversity.ui.home.MainActivity
import com.example.dscmeetupkibabiiuniversity.ui.onboard.fragment.LoginDirections
import com.example.dscmeetupkibabiiuniversity.ui.onboard.fragment.RegisterDirections

internal class OnBoardViewModel : ViewModel() {


    fun login(view: View) {

        Intent(view.context, MainActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun register(view: View) {

        Intent(view.context, MainActivity::class.java).also {
            view.context.startActivity(it)
        }
    }

    fun goToLogin(view: View) {
        val action = RegisterDirections.actionRegisterToLogin()
        Navigation.findNavController(view).navigate(action)
    }

    fun goToRegister(view: View) {
        val action = LoginDirections.actionToRegister()
        Navigation.findNavController(view).navigate(action)
    }

    fun forgotPass(view: View) {
        val action = LoginDirections.actionToForgotPass()
        Navigation.findNavController(view).navigate(action)
    }

    fun reportIssue(view: View) {
        val action = LoginDirections.actionReportIssue()
        Navigation.findNavController(view).navigate(action)
    }
}