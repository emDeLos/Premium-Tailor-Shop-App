package com.android.premiumtailorshop.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel: ViewModel() {
    var isLoginSuccessful = MutableLiveData<Boolean>()
    private val firebaseAuth = FirebaseAuth.getInstance()

    fun checkFireAuth(email: String, password: String){
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                isLoginSuccessful.postValue(true)
            } else {
                isLoginSuccessful.postValue(false)
            }
        }
    }
}