package com.example.mvvmexample

import android.util.Patterns

// Model
class LoginUser(val strEmailAddress: String, val strPassword: String) {

    val isEmailValid: Boolean = Patterns.EMAIL_ADDRESS.matcher(strEmailAddress).matches()
    val isPasswordLengthGreaterThan5: Boolean = strPassword.length > 5
}