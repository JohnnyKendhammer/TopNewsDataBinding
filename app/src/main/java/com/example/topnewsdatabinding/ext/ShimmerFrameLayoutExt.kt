package com.example.topnewsdatabinding.ext

import android.view.View
import com.facebook.shimmer.ShimmerFrameLayout

fun ShimmerFrameLayout.showLoader(show: Boolean = true) =
    when (show) {
        true -> {
            visibility = View.VISIBLE
            startShimmer()
        }
        false -> {
            visibility = View.GONE
            stopShimmer()
        }
    }