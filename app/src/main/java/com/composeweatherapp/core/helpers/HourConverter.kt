package com.composeweatherapp.core.helpers

object HourConverter {
    fun convertHour(hour: String) : String {
        return if(hour.toInt() <= 12) {
            "$hour AM"
        }else {
            "${hour.toInt() - 12} PM"
        }
    }
}