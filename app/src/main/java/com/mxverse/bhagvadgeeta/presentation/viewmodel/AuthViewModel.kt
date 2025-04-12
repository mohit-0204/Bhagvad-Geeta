package com.mxverse.bhagvadgeeta.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {

    private val _isLoggedIn = mutableStateOf(false)
    val isLoggedIn: State<Boolean> get() = _isLoggedIn

    init {
        _isLoggedIn.value = firebaseAuth.currentUser != null
    }

    fun logout() {
        firebaseAuth.signOut()
        _isLoggedIn.value = false
    }

    fun onLoginSuccess() {
        _isLoggedIn.value = true
    }
}
