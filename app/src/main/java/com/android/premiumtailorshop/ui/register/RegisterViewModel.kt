package com.android.premiumtailorshop.ui.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel: ViewModel() {

    private val firebaseAuth = FirebaseAuth.getInstance()
//    val fDatabase = Firebase.database("https://premium-tailor-shop-project-default-rtdb.asia-southeast1.firebasedatabase.app/").reference

    var isCreateUserSuccessful = MutableLiveData<Boolean>()

    fun registerFirebaseAuth(email: String, password: String){
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                isCreateUserSuccessful.postValue(true)
            } else {
                isCreateUserSuccessful.postValue(false)
            }
        }
    }
}