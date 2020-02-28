package com.example.topnewsdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.topnewsdatabinding.adapter.NewsAdapter
import com.example.topnewsdatabinding.ext.showLoader
import com.example.topnewsdatabinding.network.models.Article
import com.example.topnewsdatabinding.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.news_item_loader.*

class MainActivity : AppCompatActivity() {
    private val newsViewModel: NewsViewModel by viewModels()
    private var newsAdapter: NewsAdapter? = null
    private val articleClicked: (Article) -> Unit = {
        Toast.makeText(this, it.author, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvNews.apply {
            newsAdapter = NewsAdapter(articleClicked)
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
            itemAnimator = DefaultItemAnimator()
        }
    }

    override fun onResume() {
        super.onResume()
        setUpObserver()
    }

    private fun setUpObserver() {
        newsViewModel.newsLiveData.observe(this, Observer {
            val adapterItemCount = newsAdapter?.itemCount?.minus(1) ?: -1
            val insertIndex = if (adapterItemCount < 0) 0 else adapterItemCount
            listLoaderMask.showLoader(show = false)
            newsAdapter?.submitList(it.articles)
            newsAdapter?.notifyItemRangeInserted(insertIndex, it.articles.size)
        })
    }
}
