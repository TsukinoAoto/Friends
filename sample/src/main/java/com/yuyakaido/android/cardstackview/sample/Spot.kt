package com.yuyakaido.android.cardstackview.sample


import android.graphics.Bitmap


data class Spot(
    val name: String,
    val city: String,
    val url: Bitmap? = null,
    val id:String
) {
    companion object {
        private var counter = 0L
    }
}

