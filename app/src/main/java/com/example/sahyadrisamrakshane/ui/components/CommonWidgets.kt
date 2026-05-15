package com.example.sahyadrisamrakshane.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sahyadrisamrakshane.ui.theme.*

@Composable
fun ForestMark() {
    Box(
        modifier = Modifier.size(76.dp).background(ForestGreen, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(54.dp)) {
            val path = Path().apply {
                moveTo(size.width / 2, 0f)
                cubicTo(size.width * 0.2f, size.height * 0.32f, 0f, size.height * 0.55f, size.width * 0.24f, size.height * 0.62f)
                cubicTo(size.width * 0.36f, size.height * 0.68f, size.width * 0.45f, size.height * 0.5f, size.width / 2, size.height * 0.38f)
                cubicTo(size.width * 0.55f, size.height * 0.5f, size.width * 0.64f, size.height * 0.68f, size.width * 0.76f, size.height * 0.62f)
                cubicTo(size.width, size.height * 0.55f, size.width * 0.8f, size.height * 0.32f, size.width / 2, 0f)
                close()
            }
            drawPath(path, Cream)
            drawLine(Cream, Offset(size.width / 2, size.height * 0.38f), Offset(size.width / 2, size.height), strokeWidth = 8f)
        }
    }
}

@Composable
fun DividerText(text: String) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Box(Modifier.weight(1f).height(1.dp).background(LightGreen))
        Text(text, color = MediumGrey, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Box(Modifier.weight(1f).height(1.dp).background(LightGreen))
    }
}

@Composable
fun SectionTitle(title: String) {
    Spacer(Modifier.height(8.dp))
    Text(title.uppercase(), color = ForestGreen, fontSize = 16.sp, fontWeight = FontWeight.Bold)
}
