package com.example.sahyadrisamrakshane.model

enum class Screen {
    Login, Dashboard, Reports, Tips, Officer,
    Type, Photo, ConfirmPhoto, Location, Details, Review, Confirmation, Status
}

data class IncidentType(
    val id: String,
    val code: String,
    val title: String,
    val detail: String
)

data class ReportDraft(
    val type: String = "fire",
    val photoTaken: Boolean = false,
    val latitude: Double = 13.1234,
    val longitude: Double = 75.5678,
    val accuracy: Int = 15,
    val address: String = "",
    val description: String = "",
    val anonymous: Boolean = false
)

data class IncidentReport(
    val id: String,
    val type: String,
    val title: String,
    val address: String,
    val description: String,
    val status: String,
    val synced: Boolean,
    val createdAt: Long,
    val latitude: Double,
    val longitude: Double,
    val accuracy: Int,
    val anonymous: Boolean
)
