package com.example.sahyadrisamrakshane.data

import com.example.sahyadrisamrakshane.model.IncidentReport
import com.example.sahyadrisamrakshane.model.IncidentType

val incidentTypes = listOf(
    IncidentType("fire", "FI", "Forest Fire", "Rapid flames, smoke, or burnt vegetation"),
    IncidentType("landslide", "LS", "Landslide", "Earth, rock, or road collapse"),
    IncidentType("cutting", "CT", "Illegal Cutting", "Unauthorized felling or timber transport"),
    IncidentType("wildlife", "WL", "Wildlife Sighting", "Injured, displaced, or unsafe animal encounter")
)

fun incidentType(typeId: String): IncidentType = incidentTypes.firstOrNull { it.id == typeId } ?: incidentTypes.first()

fun initialReports(): List<IncidentReport> = listOf(
    IncidentReport(
        id = "FG-2026-001234",
        type = "fire",
        title = "Forest Fire",
        address = "Kumara Peak Trail",
        description = "Smoke seen rising from the south ridge.",
        status = "verified",
        synced = true,
        createdAt = System.currentTimeMillis() - 7_200_000,
        latitude = 13.1234,
        longitude = 75.5678,
        accuracy = 15,
        anonymous = false
    ),
    IncidentReport(
        id = "FG-2026-001233",
        type = "landslide",
        title = "Landslide",
        address = "Hill Ghat Road",
        description = "Loose stones blocking part of the road.",
        status = "pending",
        synced = false,
        createdAt = System.currentTimeMillis() - 1_800_000,
        latitude = 12.7157,
        longitude = 75.6843,
        accuracy = 22,
        anonymous = false
    )
)
