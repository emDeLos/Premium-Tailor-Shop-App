package com.android.premiumtailorshop.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.premiumtailorshop.common.moveToPage
import com.android.premiumtailorshop.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        buttonActions()
        loginData()
    }

    private fun buttonActions() {
        binding.loginButton.setOnClickListener {
            viewModel.checkFireAuth(
                binding.etLoginEmail.editText?.text.toString(),
                binding.etLoginPassword.editText?.text.toString())
        }
        binding.signUpButton.setOnClickListener {
            moveToPage(this, "register")
        }
    }

    private fun loginData() {
        viewModel.isLoginSuccessful.observe(this, Observer { isLogin ->
            if (isLogin) {
                Log.i("FIREBASE AUTH", "Login Successful")
                moveToPage(this, "main")
                finish()
            } else {
                Log.e("FIREBASE AUTH", "Login Failed")
                Toast.makeText(this, "LOGIN FAILED", Toast.LENGTH_LONG).show()
            }
        })
    }
}