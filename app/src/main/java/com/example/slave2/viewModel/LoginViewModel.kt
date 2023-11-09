package com.example.slave2.viewModel

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.slave2.model.User
import java.util.regex.Pattern

class LoginViewModel:ViewModel() {
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])[!-~₩]{8,100}$"
    val pattern = Pattern.compile(pwPattern)

    val _event: MutableLiveData<Event> = MutableLiveData()
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
    fun back(){
        _event.value = Event.back
    }
    fun cencel(){
        _event.value = Event.cencel
    }
    fun visibility(){
        if(password.value!=null && password.value.toString()!=""){
            _event.value = Event.visibility
        }else{
            _event.value = Event.invisibility
        }
    }
    sealed class Event {
        data object emailLogin : Event()
        data object passwordLogin : Event()
        data object back : Event()
        data object cencel : Event()
        data object visibility : Event()
        data object invisibility : Event()
    }
}