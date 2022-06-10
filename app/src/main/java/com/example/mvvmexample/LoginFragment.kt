package com.example.mvvmexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.mvvmexample.databinding.FragmentLoginBinding
import com.example.mvvmexample.viewmodel.LoginViewModel

// View
class LoginFragment : Fragment() {

    private var _binding : FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val loginViewModel: LoginViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginViewModel.userMutableLiveData.observe(viewLifecycleOwner) {
            binding.lblEmailAnswer.text = it.strEmailAddress
            binding.lblPasswordAnswer.text = it.strPassword
        }

        binding.btnLogin.setOnClickListener{ onClickLoginButton() }
    }

    private fun onClickLoginButton() {
        loginViewModel.onClick(binding.txtEmailAddress.text.toString(),
            binding.txtPassword.text.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}