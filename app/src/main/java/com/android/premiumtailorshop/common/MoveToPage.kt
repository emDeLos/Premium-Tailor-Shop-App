package com.android.premiumtailorshop.common

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.android.premiumtailorshop.ui.login.LoginActivity
import com.android.premiumtailorshop.ui.main.MainActivity
import com.android.premiumtailorshop.ui.register.RegisterActivity

fun AppCompatActivity.moveToPage(mContext: Context, activityName: String) {
    when(activityName){
        "main" -> {
            startActivity(Intent(mContext, MainActivity::class.java))
        }
        "login" -> {
            startActivity(Intent(mContext, LoginActivity::class.java))
        }
        "register" -> {
            startActivity(Intent(mContext, RegisterActivity::class.java))
        }
    }
}