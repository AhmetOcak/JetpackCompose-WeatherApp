package com.composeweatherapp.core.helpers

object HourConverter {
    fun convertHour(hour: String) : String {
        return if(hour.toInt() in 1..11) {
            "$hour AM"
        }else {
            when (hour) {
                "00" -> {
                    "12 AM"
                }
                "12" -> {
                    "12 PM"
                }
                else -> {
                    "0${hour.toInt() - 12} PM"
                }
            }
        }
    }
}