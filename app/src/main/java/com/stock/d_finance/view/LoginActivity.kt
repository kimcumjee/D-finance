package com.stock.d_finance.view

import com.stock.ant.base.BaseActivity
import com.stock.d_finance.R
import com.stock.d_finance.databinding.ActivityLoginBinding
import com.stock.d_finance.viewModel.LoginViewModel

class LoginActivity : BaseActivity<ActivityLoginBinding, LoginViewModel>(){

    override lateinit var binding: ActivityLoginBinding
    override val viewModel = LoginViewModel()
    override val layoutRes: Int
        get() = R.layout.activity_login

    override fun init() {

    }

    override fun observerViewModel() {

    }

}


