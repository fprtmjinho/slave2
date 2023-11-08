package com.example.slave2.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.slave2.model.User

class LoginViewModel:ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    init {
        email.value = ""
        password.value = ""
    }

    fun onEmailChanged(text: CharSequence?) {
        email.value = text.toString()
    }
    fun onPasswordChanged(text: CharSequence?) {
        password.value = text.toString()
    }
}