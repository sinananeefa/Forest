package com.example.sahyadrisamrakshane.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sahyadrisamrakshane.data.incidentType
import com.example.sahyadrisamrakshane.model.IncidentReport
import com.example.sahyadrisamrakshane.model.ReportDraft
import com.example.sahyadrisamrakshane.ui.theme.*
import com.example.sahyadrisamrakshane.util.format4
import com.example.sahyadrisamrakshane.util.timeAgo
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ForestCard(modifier: Modifier = Modifier, content: @Composable ColumnScope.() -> Unit) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = PaleGreen),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp), content = content)
    }
}

@Composable
fun ReportCard(report: IncidentReport, onOpen: (String) -> Unit) {
    ForestCard {
        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CodeTile(incidentType(report.type).code)
            Column(modifier = Modifier.weight(1f)) {
                Text(report.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("ID: ${report.id}", color = MediumGrey)
                StatusBadge(report)
                Text("${timeAgo(report.createdAt)} · ${report.address}", color = MediumGrey)
                TextButton(onClick = { onOpen(report.id) }, contentPadding = PaddingValues(0.dp)) {
                    Text("View Details", color = ForestGreen, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun StatusBadge(report: IncidentReport) {
    val label: String
    val color: Color
    when {
        !report.synced || report.status == "pending" -> {
            label = "Pending Sync"
            color = EarthBrown
        }
        report.status == "verified" -> {
            label = "Verified"
            color = SuccessGreen
        }
        report.status == "dispatched" -> {
            label = "Team Dispatched"
            color = MediumGreen
        }
        report.status == "resolved" -> {
            label = "Resolved"
            color = SuccessGreen
        }
        else -> {
            label = "Reported"
            color = MediumGreen
        }
    }
    Box(
        modifier = Modifier.background(color, RoundedCornerShape(999.dp)).padding(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Text(label, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun StatBox(label: String, value: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(Color.White.copy(alpha = 0.65f), RoundedCornerShape(8.dp)).padding(12.dp)
    ) {
        Text(value.toString(), color = ForestGreen, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(label, fontSize = 12.sp)
    }
}

@Composable
fun CodeTile(code: String) {
    Box(
        modifier = Modifier.size(52.dp).background(ForestGreen, RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Text(code, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}

@Composable
fun CoordinateCard(draft: ReportDraft) {
    ForestCard {
        Text("Latitude: ${draft.latitude.format4()} N", fontFamily = FontFamily.Monospace)
        Text("Longitude: ${draft.longitude.format4()} E", fontFamily = FontFamily.Monospace)
        Text("Accuracy: +/- ${draft.accuracy}m", fontFamily = FontFamily.Monospace)
        Text("Time: ${SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(Date())}", fontFamily = FontFamily.Monospace)
    }
}

@Composable
fun SummaryCard(label: String, value: String, onEdit: () -> Unit) {
    ForestCard {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.weight(1f)) {
                Text(label.uppercase(), color = MediumGrey, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Text(value, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            TextButton(onClick = onEdit) {
                Text("Edit", color = ForestGreen, fontWeight = FontWeight.Bold)
            }
        }
    }
}
