package com.stock.d_finance.view

import android.content.Intent
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.project.simplecode.spaIntent
import com.stock.ant.base.BaseActivity
import com.stock.d_finance.R
import com.stock.d_finance.databinding.ActivityLoginBinding
import com.stock.d_finance.viewModel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(){

    override lateinit var binding: ActivityLoginBinding
    override val viewModel = LoginViewModel()
    override val layoutRes: Int
        get() = R.layout.activity_login
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var googleSignInClient: GoogleSignInClient

    private val RC_SIGN_IN = 99
    override fun init() {
        val loginBtn = findViewById<SignInButton>(R.id.google_login_btn)
        loginBtn.setOnClickListener {
            spaIntent(MainActivity::class.java)
        }
//        loginBtn.setOnClickListener { signIn() }
//
//        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()
//
//        googleSignInClient = GoogleSignIn.getClient(this, gso)
//
//        firebaseAuth = FirebaseAuth.getInstance()
//        viewModel.onActivityResult(99,-1,intent,RC_SIGN_IN)
    }

    override fun observerViewModel() {
        with(viewModel){
            btn.observe(this@LoginActivity, androidx.lifecycle.Observer {

            })
        }
    }
//    //현재 로그인 되어 있는지 확인
//    public override fun onStart() {
//        super.onStart()
//        val account = GoogleSignIn.getLastSignedInAccount(this)
//        if (account !== null) {
//            toMainActivity(firebaseAuth.currentUser)
//        }
//    }
//
//    // LoginActivity 로 이동
//    private fun toMainActivity(user: FirebaseUser?) {
//        if (user != null) {
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }
//    }
//
//    //google login view 호출
//    private fun signIn() {
//        val signInIntent = googleSignInClient.signInIntent
//        startActivityForResult(signInIntent, RC_SIGN_IN)
//
//    }


}


