package com.example.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weatherapp.LoginUser

// ViewModel
class LoginViewModel : ViewModel() {
    private val _emailAddress = MutableLiveData<String>("")
    val emailAddress: LiveData<String> = _emailAddress
    private val _password = MutableLiveData<String>("")
    val password: LiveData<String> = _password
    private val _userMutableLiveData = MutableLiveData<LoginUser>()
    val userMutableLiveData : MutableLiveData<LoginUser> = _userMutableLiveData

    init {
        reset()
    }

    fun onClick(email: String, pass: String) {
        _emailAddress.value = email
        _password.value = pass
        val loginUser = LoginUser(_emailAddress.value!!, _password.value!!)
        if (checkLogin(loginUser)) {
            _userMutableLiveData.value = loginUser
        } else {
            reset()
        }
    }

    private fun reset() {
        _emailAddress.value = ""
        _password.value = ""
    }

    private fun checkLogin(user: LoginUser) : Boolean {
        return user.isPasswordLengthGreaterThan5 &&
                user.isEmailValid
    }

}