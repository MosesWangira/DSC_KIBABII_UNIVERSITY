package com.dsc.kibu.data.repository

import com.google.firebase.auth.FirebaseAuth

internal class OnboardRepository {

    private val firebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    private fun String.getEmail() = "$this@gmail.com"

    private val dbUsersFolderName = "users"

    /* Register */
    fun createUserWithNicknameAndPassword(nickname: String, password: String) =
        firebaseAuth.createUserWithEmailAndPassword(nickname.getEmail(), password)

    /* Login */
    fun signInWithNicknameAndPassword(nickname: String, password: String) =
        firebaseAuth.signInWithEmailAndPassword(nickname.getEmail(), password)

    /* Sign out */
    fun signOut() = firebaseAuth.signOut()

    /* User */
    fun getCurrentUser() = firebaseAuth.currentUser

}