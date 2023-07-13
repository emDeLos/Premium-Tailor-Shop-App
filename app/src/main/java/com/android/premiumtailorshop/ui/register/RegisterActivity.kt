package com.android.premiumtailorshop.ui.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.android.premiumtailorshop.common.moveToPage
import com.android.premiumtailorshop.databinding.ActivityRegisterBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel
    val database = Firebase.database.reference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        buttonAction()
        registerUserData()
    }

    private fun buttonAction(){
        binding.mBtnRegister.setOnClickListener {
            if (binding.etRegisterEmail.editText?.text.toString() != "" &&
                binding.etRegisterPassword.editText?.text.toString() != ""){

                viewModel.registerFirebaseAuth(binding.etRegisterEmail.editText?.text.toString(),
                    binding.etRegisterPassword.editText?.text.toString())

                clearAllField()
            } else {
                binding.tvRegisterError.visibility = View.VISIBLE
            }
        }
    }

    private fun clearAllField() {
        binding.etRegisterEmail.editText?.text?.clear()
        binding.etRegisterPassword.editText?.text?.clear()
    }

    private fun registerUserData(){
        viewModel.isCreateUserSuccessful.observe( this, Observer { isRegister ->
            if (isRegister) {
                Log.i("FIREBASE DATABASE", "Register User Successful")
                moveToPage(this, "login")
                finish()
            } else {
                Log.e("FIREBASE DATABASE", "Register User Failed")
                Toast.makeText(this, "REGISTER USER FAILED", Toast.LENGTH_LONG).show()
            }
        })
    }
}