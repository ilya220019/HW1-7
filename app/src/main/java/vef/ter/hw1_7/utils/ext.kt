package vef.ter.hw1_7.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import vef.ter.hw1_7.R

fun ImageView.loadImage(url: String?) {
    Glide.with(this).load(url).placeholder(R.drawable.ic_launcher_background).into(this)
}