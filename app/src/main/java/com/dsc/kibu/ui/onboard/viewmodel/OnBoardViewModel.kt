package com.dsc.kibu.ui.onboard.viewmodel

import android.content.Intent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.dsc.kibu.core.EmptyResource
import com.dsc.kibu.core.toast
import com.dsc.kibu.data.model.UserData
import com.dsc.kibu.data.repository.OnboardRepository
import com.dsc.kibu.ui.home.MainActivity
import com.dsc.kibu.ui.onboard.fragment.LoginDirections
import com.dsc.kibu.ui.onboard.fragment.RegisterDirections

internal class OnBoardViewModel : ViewModel() {

    private val onboardRepository by lazy {
        OnboardRepository()
    }

    val loginResult by lazy {
        MutableLiveData<EmptyResource>()
    }
    val signUpResult by lazy {
        MutableLiveData<EmptyResource>()
    }

    var email: String? = null
    var password: String? = null


    fun login(view: View) {
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            view.context?.toast("Email prefix is required and password")
            return
        }

        loginResult.value = EmptyResource.loading()

        onboardRepository.signInWithNicknameAndPassword(email!!, password!!)
            .addOnSuccessListener {
                UserData.email = email!!
                loginResult.value = EmptyResource.success()
            }
            .addOnFailureListener {
                loginResult.value = EmptyResource.error(it)
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