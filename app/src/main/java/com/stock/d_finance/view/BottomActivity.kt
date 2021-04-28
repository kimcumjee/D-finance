package com.stock.d_finance.view


import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.stock.d_finance.R
import com.stock.d_finance.base.BaseActivity
import com.stock.d_finance.databinding.ActivityBottomBinding
import com.stock.d_finance.viewModel.BottomViewModel

class BottomActivity : BaseActivity<ActivityBottomBinding, BottomViewModel>() {
    override lateinit var binding: ActivityBottomBinding
    override val viewModel = BottomViewModel()
    override val layoutRes: Int
        get() = R.layout.activity_bottom

    override fun init() {
        val actionBar = supportActionBar
        actionBar?.hide()

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)
    }

    override fun observerViewModel() {

    }
}