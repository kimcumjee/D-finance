package com.stock.d_finance.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.stock.d_finance.R
import com.stock.d_finance.viewModel.BottomViewModel
import com.stock.d_finance.viewModel.NewsViewModel

class NewsFragment : Fragment() {

    private lateinit var newsViewModel: BottomViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newsViewModel =
            ViewModelProvider(this).get(BottomViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_news, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        newsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }
}