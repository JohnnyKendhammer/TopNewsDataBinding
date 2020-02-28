package com.example.topnewsdatabinding.ext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun ViewGroup.inflate(layoutId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)

fun <T : ViewDataBinding> ViewGroup.bind(layoutId: Int, attachToParent: Boolean = false): T =
    DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, this, attachToParent)