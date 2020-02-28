package com.example.topnewsdatabinding.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import com.example.topnewsdatabinding.R
import com.example.topnewsdatabinding.adapter.utils.DataBoundListAdapter
import com.example.topnewsdatabinding.databinding.NewsItemBinding
import com.example.topnewsdatabinding.ext.bind
import com.example.topnewsdatabinding.network.models.Article

class NewsAdapter(private val articleClicked: (item: Article) -> Unit = {}) : DataBoundListAdapter<Article>(
    diffCallback = object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
            oldItem.content == newItem.content

    }
) {
    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding =
        parent.bind(R.layout.news_item)

    override fun bind(binding: ViewDataBinding, item: Article) {
        when (binding) {
            is NewsItemBinding -> binding.article = item
        }
        with(binding.root) {
            tag = item
            setOnClickListener { articleClicked.invoke(item) }
        }
    }
}