package com.aos.composemovieapp.view.util

import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object Date {

    fun getYesterday(): String {
        val calendar = Calendar.getInstance()
        calendar.add(Calendar.DATE, -1) // ✅ 어제로 이동
        val dateFormat = SimpleDateFormat("yyyyMMdd", Locale.getDefault()) // ✅ "yyyyMMdd" 포맷 적용
        return dateFormat.format(calendar.time) // ✅ 어제 날짜 반환
    }
}