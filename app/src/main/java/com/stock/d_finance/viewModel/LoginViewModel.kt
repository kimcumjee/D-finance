package com.stock.d_finance.viewModel

import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.stock.ant.base.BaseViewModel
import com.stock.d_finance.widget.SingleLiveEvent


class LoginViewModel : BaseViewModel() {

    fun firebaseAuthWithGoogle(acct: GoogleSignInAccount, firebaseAuth: FirebaseAuth) {
        Log.d("LoginActivity", "firebaseAuthWithGoogle:" + acct.id!!)

        val credential = GoogleAuthProvider.getCredential(acct.idToken, null)
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.w("LoginActivity", "firebaseAuthWithGoogle 성공", task.exception)
                    val user = firebaseAuth.currentUser
                    Log.d("account", "account : ${user!!.email}")

                } else {
                    Log.w("LoginActivity", "firebaseAuthWithGoogle 실패", task.exception)
                    Log.e("로그인", "로그인에 실패했습니다.")
                }
            }
    }

}