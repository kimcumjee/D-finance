package com.stock.d_finance.view

import com.stock.ant.base.BaseActivity
import com.stock.d_finance.R
import com.stock.d_finance.databinding.ActivityMainBinding
import com.stock.d_finance.viewModel.MainViewModel

class MainActivity() : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override lateinit var binding: ActivityMainBinding
    override val viewModel = MainViewModel()
    override val layoutRes: Int
        get() = R.layout.activity_main
    override fun init() {
        viewModel.oil()
    }

    override fun observerViewModel() {

    }
}