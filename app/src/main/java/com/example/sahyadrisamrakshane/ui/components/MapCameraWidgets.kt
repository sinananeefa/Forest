package com.example.sahyadrisamrakshane.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sahyadrisamrakshane.ui.theme.*

@Composable
fun CameraPreview(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth().height(240.dp).background(
            brush = Brush.linearGradient(listOf(ForestGreen, MediumGreen, WarningOrange)),
            shape = RoundedCornerShape(8.dp)
        ),
        contentAlignment = Alignment.Center
    ) {
        Text("Camera preview simulation", color = Color.White, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun PhotoPreview(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxWidth().height(240.dp).background(
            brush = Brush.verticalGradient(listOf(LightGreen, PaleGreen, ForestGreen)),
            shape = RoundedCornerShape(8.dp)
        )
    ) {
        Text(
            "Evidence preview",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)
        )
    }
}

@Composable
fun MapPreview(modifier: Modifier = Modifier, markers: List<String> = emptyList()) {
    Box(
        modifier = modifier.fillMaxWidth().height(240.dp).background(PaleGreen, RoundedCornerShape(8.dp)).border(1.dp, LightGreen, RoundedCornerShape(8.dp))
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val grid = 34.dp.toPx()
            var x = 0f
            while (x < size.width) {
                drawLine(ForestGreen.copy(alpha = 0.12f), Offset(x, 0f), Offset(x, size.height))
                x += grid
            }
            var y = 0f
            while (y < size.height) {
                drawLine(ForestGreen.copy(alpha = 0.12f), Offset(0f, y), Offset(size.width, y))
                y += grid
            }
            val path = Path().apply {
                moveTo(size.width * 0.12f, size.height * 0.58f)
                cubicTo(size.width * 0.34f, size.height * 0.3f, size.width * 0.54f, size.height * 0.78f, size.width * 0.88f, size.height * 0.42f)
            }
            drawPath(path, EarthBrown.copy(alpha = 0.55f), style = Stroke(width = 14f))
            drawCircle(ErrorRed, radius = 18f, center = Offset(size.width * 0.52f, size.height * 0.42f))
            drawCircle(Color.White, radius = 7f, center = Offset(size.width * 0.52f, size.height * 0.42f))
        }
        markers.forEachIndexed { index, marker ->
            Box(
                modifier = Modifier
                    .align(if (index % 2 == 0) Alignment.TopStart else Alignment.CenterEnd)
                    .padding((20 + index * 16).dp)
                    .background(ForestGreen, RoundedCornerShape(999.dp))
                    .padding(horizontal = 10.dp, vertical = 8.dp)
            ) {
                Text(marker, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 12.sp)
            }
        }
    }
}
