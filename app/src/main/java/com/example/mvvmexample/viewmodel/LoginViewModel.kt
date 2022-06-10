package com.example.mvvmexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.LoginUser

// ViewModel
class LoginViewModel : ViewModel() {
    private val _emailAddress = MutableLiveData<String>()

    private val _password = MutableLiveData<String>()

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
        _emailAddress.value = "---"
        _password.value = "---"
        _userMutableLiveData.value = LoginUser(_emailAddress.value!!, _password.value!!)
    }

    private fun checkLogin(user: LoginUser) : Boolean {
        return user.isPasswordLengthGreaterThan5 &&
                user.isEmailValid
    }

}