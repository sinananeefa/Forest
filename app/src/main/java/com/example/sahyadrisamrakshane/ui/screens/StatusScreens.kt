package com.example.sahyadrisamrakshane.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sahyadrisamrakshane.model.IncidentReport
import com.example.sahyadrisamrakshane.model.ReportDraft
import com.example.sahyadrisamrakshane.ui.components.*
import com.example.sahyadrisamrakshane.ui.theme.*

@Composable
fun StatusScreen(report: IncidentReport, padding: PaddingValues) {
    val stage = when (report.status) {
        "verified" -> 1
        "dispatched" -> 2
        "resolved" -> 3
        else -> 0
    }
    val steps = listOf(
        "Reported" to "Received by forest department",
        "Verified" to "Incident confirmed",
        "Team Dispatched" to "Forest rangers en route",
        "Resolved" to "Response completed"
    )

    ScreenColumn(padding) {
        Text("Status: ${report.id}", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        ReportCard(report, onOpen = {})
        SectionTitle("Status Timeline")
        steps.forEachIndexed { index, item ->
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                val done = index < stage
                val current = index == stage
                Box(
                    modifier = Modifier
                        .size(34.dp)
                        .background(
                            color = when {
                                done -> SuccessGreen
                                current -> EarthBrown
                                else -> Color.White
                            },
                            shape = CircleShape
                        )
                        .border(3.dp, if (done || current) Color.Transparent else LightGreen, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(if (done) "✓" else if (current) "•" else "", color = Color.White, fontWeight = FontWeight.Bold)
                }
                Column {
                    Text(item.first, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(if (index <= stage) item.second else "Waiting for update", color = MediumGrey)
                }
            }
        }
        SectionTitle("Latest Update")
        ForestCard {
            Text(if (report.synced) "Response desk is reviewing the incident details." else "Saved locally. It will sync automatically when connectivity returns.")
            Text("Updated 2 minutes ago", color = MediumGrey)
        }
        SectionTitle("Incident Location")
        MapPreview()
        Spacer(Modifier.height(12.dp))
        CoordinateCard(
            ReportDraft(
                latitude = report.latitude,
                longitude = report.longitude,
                accuracy = report.accuracy
            )
        )
        Spacer(Modifier.height(12.dp))
        SecondaryButton(
            text = "Contact Forest Dept",
            onClick = {}
        )
    }
}
