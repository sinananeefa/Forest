package com.example.sahyadrisamrakshane.util

import kotlin.math.roundToInt

fun Double.format4(): String = ((this * 10000.0).roundToInt() / 10000.0).toString()

fun timeAgo(timestamp: Long): String {
    val minutes = ((System.currentTimeMillis() - timestamp) / 60000).coerceAtLeast(1)
    if (minutes < 60) return "$minutes minutes ago"
    val hours = minutes / 60
    if (hours < 24) return "$hours hours ago"
    return "${hours / 24} days ago"
}
