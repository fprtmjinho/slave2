package com.example.slave2.viewModel

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    private val _event: MutableLiveData<Event> = MutableLiveData()
    val event: LiveData<Event>
        get() = _event
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
    fun loginEmail(){
        _event.value = Event.emailLogin
    }
    fun loginPassword(){
        _event.value = Event.passwordLogin
    }
    sealed class Event {
        object emailLogin : Event()
        object passwordLogin : Event()
    }
}