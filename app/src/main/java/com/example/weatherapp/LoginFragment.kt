package com.example.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.weatherapp.databinding.FragmentLoginBinding
import com.example.weatherapp.viewmodel.LoginViewModel

// View
class LoginFragment : Fragment() {

    private var binding: FragmentLoginBinding? = null
    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentBinding = FragmentLoginBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.loginFragment = this

        binding?.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = loginViewModel
            loginFragment = this@LoginFragment
        }
    }

    fun onClickLoginButton() {
        loginViewModel.onClick(binding!!.txtEmailAddress.text.toString(),
            binding!!.txtPassword.text.toString())
    }
}