package com.example.topnewsdatabinding.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("loadImg")
fun ImageView.loadImg(imageUrl: String?) = Picasso.get().load(imageUrl).into(this)