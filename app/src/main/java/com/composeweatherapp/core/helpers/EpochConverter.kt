package com.composeweatherapp.core.helpers

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

object EpochConverter {
    @SuppressLint("SimpleDateFormat")
    fun readTimestamp(timestamp: Long): String {
        val formatter = SimpleDateFormat("hh:mm")
        val calendar: Calendar = Calendar.getInstance()
        calendar.timeInMillis = timestamp * 1000L
        return formatter.format(calendar.time)
    }
}