package com.example.sahyadrisamrakshane.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sahyadrisamrakshane.data.incidentType
import com.example.sahyadrisamrakshane.model.IncidentReport
import com.example.sahyadrisamrakshane.ui.components.*
import com.example.sahyadrisamrakshane.ui.theme.*

@Composable
fun DashboardScreen(
    userName: String,
    reports: List<IncidentReport>,
    padding: PaddingValues,
    onOpen: (String) -> Unit
) {
    val active = reports.count { it.status != "resolved" }
    val verified = reports.count { it.status == "verified" }
    val dispatched = reports.count { it.status == "dispatched" }

    ScreenColumn(padding) {
        Text("Welcome, $userName!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Western Ghats Region", color = MediumGrey)
        Spacer(Modifier.height(16.dp))
        ForestCard {
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth()) {
                StatBox("Active", active, Modifier.weight(1f))
                StatBox("Verified", verified, Modifier.weight(1f))
                StatBox("Dispatched", dispatched, Modifier.weight(1f))
            }
        }
        SectionTitle("Recent Activity")
        reports.sortedByDescending { it.createdAt }.take(4).forEach {
            ReportCard(it, onOpen)
        }
    }
}

@Composable
fun ReportsScreen(reports: List<IncidentReport>, padding: PaddingValues, onOpen: (String) -> Unit) {
    ScreenColumn(padding) {
        Text("My Reports", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Track status updates and locally queued submissions.", color = MediumGrey)
        Spacer(Modifier.height(16.dp))
        reports.forEach { ReportCard(it, onOpen) }
    }
}

@Composable
fun TipsScreen(padding: PaddingValues) {
    val tips = listOf(
        Triple("FI", "Fire Safety", "Move cross-wind, stay on clear paths, avoid smoke valleys, and report flame direction."),
        Triple("WL", "Wildlife Encounters", "Keep distance, do not feed animals, avoid flash, and leave a clear escape route."),
        Triple("LS", "Landslide Readiness", "Watch cracks, fresh mud, tilted trees, blocked drains, and stream changes."),
        Triple("CT", "Illegal Cutting", "Note vehicle direction, number of people, and avoid direct confrontation.")
    )

    ScreenColumn(padding) {
        Text("Eco Safety Tips", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Quick field guidance for safer reporting.", color = MediumGrey)
        Spacer(Modifier.height(16.dp))
        tips.forEach { tip ->
            ForestCard {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    CodeTile(tip.first)
                    Column {
                        Text(tip.second, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(tip.third, color = DarkText)
                    }
                }
            }
        }
    }
}

@Composable
fun OfficerScreen(reports: List<IncidentReport>, padding: PaddingValues, onOpen: (String) -> Unit) {
    ScreenColumn(padding) {
        Text("Officer Dashboard", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Incident map, evidence, and response controls.", color = MediumGrey)
        Spacer(Modifier.height(16.dp))
        MapPreview(modifier = Modifier.height(320.dp), markers = reports.map { incidentType(it.type).code })
        SectionTitle("Incoming Reports")
        reports.forEach { ReportCard(it, onOpen) }
    }
}
