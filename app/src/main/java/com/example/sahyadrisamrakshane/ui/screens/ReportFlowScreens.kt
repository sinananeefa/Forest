package com.example.sahyadrisamrakshane.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.sahyadrisamrakshane.data.incidentType
import com.example.sahyadrisamrakshane.data.incidentTypes
import com.example.sahyadrisamrakshane.model.ReportDraft
import com.example.sahyadrisamrakshane.ui.components.*
import com.example.sahyadrisamrakshane.ui.theme.*
import com.example.sahyadrisamrakshane.util.format4
import kotlin.random.Random

@Composable
fun TypeScreen(draft: ReportDraft, onDraft: (ReportDraft) -> Unit, onNext: () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("What did you see?", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Select the incident type so authorities can route it quickly.", color = MediumGrey)
        Spacer(Modifier.height(16.dp))
        incidentTypes.forEach { type ->
            val selected = draft.type == type.id
            ForestCard(
                modifier = Modifier
                    .border(
                        width = if (selected) 2.dp else 1.dp,
                        color = if (selected) ForestGreen else LightGreen,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable { onDraft(draft.copy(type = type.id)) }
            ) {
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
                    CodeTile(type.code)
                    Column {
                        Text(type.title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                        Text(type.detail, color = MediumGrey)
                    }
                }
            }
        }
        Spacer(Modifier.height(8.dp))
        PrimaryButton("Next: Take Photo", onClick = onNext)
    }
}

@Composable
fun PhotoScreen(onCapture: () -> Unit) {
    val context = LocalContext.current
    var capturedBitmap by remember { mutableStateOf<Bitmap?>(null) }
    var showSourcePicker by remember { mutableStateOf(false) }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        if (bitmap != null) {
            capturedBitmap = bitmap
            onCapture() // marks photo captured in your flow
        } else {
            Toast.makeText(context, "Camera closed without photo", Toast.LENGTH_SHORT).show()
        }
    }

    val cameraPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { granted ->
        if (granted) {
            cameraLauncher.launch(null)
        } else {
            Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Take a clear photo", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Capture visible evidence while staying at a safe distance.", color = MediumGrey)
        Spacer(Modifier.height(16.dp))

        if (capturedBitmap != null) {
            Image(
                bitmap = capturedBitmap!!.asImageBitmap(),
                contentDescription = "Captured evidence photo",
                modifier = Modifier.fillMaxWidth().height(240.dp).background(Color.Black, RoundedCornerShape(8.dp))
            )
            Spacer(Modifier.height(12.dp))
            SecondaryButton(
                text = "Retake Photo",
                onClick = { showSourcePicker = true }
            )
        } else {
            CameraPreview()
            Spacer(Modifier.height(16.dp))
            PrimaryButton(
                text = "Capture Photo",
                onClick = {
                    val granted = ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.CAMERA
                    ) == PackageManager.PERMISSION_GRANTED

                    if (granted) {
                        cameraLauncher.launch(null)
                    } else {
                        cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
                    }
                }
            )
        }

        Spacer(Modifier.height(12.dp))
        SecondaryButton(
            text = "Upload from Gallery",
            onClick = {
                Toast.makeText(context, "Gallery feature coming soon", Toast.LENGTH_SHORT).show()
            }
        )
    }

    if (showSourcePicker) {
        AlertDialog(
            onDismissRequest = { showSourcePicker = false },
            title = { Text("Choose Photo Source") },
            text = { Text("Use camera to capture incident evidence.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        showSourcePicker = false
                        val granted = ContextCompat.checkSelfPermission(
                            context,
                            Manifest.permission.CAMERA
                        ) == PackageManager.PERMISSION_GRANTED

                        if (granted) {
                            cameraLauncher.launch(null)
                        } else {
                            cameraPermissionLauncher.launch(Manifest.permission.CAMERA)
                        }
                    }
                ) {
                    Text("Camera")
                }
            },
            dismissButton = {
                TextButton(onClick = { showSourcePicker = false }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
fun ConfirmPhotoScreen(draft: ReportDraft, onNext: () -> Unit, onRetake: () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Photo looks good?", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Evidence is stamped with location and time before submission.", color = MediumGrey)
        Spacer(Modifier.height(16.dp))
        PhotoPreview()
        Spacer(Modifier.height(12.dp))
        CoordinateCard(draft)
        Spacer(Modifier.height(16.dp))
        PrimaryButton("This Looks Good", onClick = onNext)
        Spacer(Modifier.height(12.dp))
        SecondaryButton("Retake Photo", onClick = onRetake)
    }
}

@Composable
fun LocationScreen(draft: ReportDraft, onDraft: (ReportDraft) -> Unit, onNext: () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Your location", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Auto-captured coordinates can be refreshed before submission.", color = MediumGrey)
        Spacer(Modifier.height(16.dp))
        MapPreview()
        Spacer(Modifier.height(12.dp))
        CoordinateCard(draft)
        Spacer(Modifier.height(16.dp))
        PrimaryButton("Location Confirmed", onClick = onNext)
        Spacer(Modifier.height(12.dp))
        SecondaryButton("Refresh Location", onClick = {
            onDraft(
                draft.copy(
                    latitude = draft.latitude + Random.nextDouble(-0.0005, 0.0005),
                    longitude = draft.longitude + Random.nextDouble(-0.0005, 0.0005),
                    accuracy = Random.nextInt(10, 28)
                )
            )
        })
    }
}

@Composable
fun DetailsScreen(draft: ReportDraft, onDraft: (ReportDraft) -> Unit, onReview: () -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text("Add location details", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Short, practical details help response teams find the spot.", color = MediumGrey)
        Spacer(Modifier.height(16.dp))
        ForestTextField(
            label = "Nearby landmark or address",
            value = draft.address,
            onValue = { onDraft(draft.copy(address = it)) }
        )
        Spacer(Modifier.height(12.dp))
        ForestTextField(
            label = "Description",
            value = draft.description,
            onValue = { if (it.length <= 500) onDraft(draft.copy(description = it)) },
            minLines = 4
        )
        Text("${draft.description.length}/500", color = MediumGrey, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = draft.anonymous,
                onCheckedChange = { onDraft(draft.copy(anonymous = it)) },
                colors = CheckboxDefaults.colors(checkedColor = ForestGreen)
            )
            Column {
                Text("Report anonymously", fontWeight = FontWeight.Bold)
                Text("Do not show my contact to responders.", color = MediumGrey, fontSize = 12.sp)
            }
        }
        Spacer(Modifier.height(12.dp))
        PrimaryButton("Review Report", enabled = draft.address.isNotBlank() && draft.description.isNotBlank(), onClick = onReview)
    }
}

@Composable
fun ReviewScreen(
    draft: ReportDraft,
    padding: PaddingValues,
    onEditType: () -> Unit,
    onEditPhoto: () -> Unit,
    onEditLocation: () -> Unit,
    onEditDetails: () -> Unit,
    onSubmit: () -> Unit
) {
    val meta = incidentType(draft.type)
    ScreenColumn(padding) {
        Text("Review your report", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text("Confirm all details before sending to forest authorities.", color = MediumGrey)
        Spacer(Modifier.height(16.dp))
        SummaryCard("Incident Type", "${meta.code} ${meta.title}", onEditType)
        SummaryCard("Photo", if (draft.photoTaken) "Evidence photo attached" else "No photo captured", onEditPhoto)
        SummaryCard("Location", "${draft.latitude.format4()} N, ${draft.longitude.format4()} E, +/- ${draft.accuracy}m", onEditLocation)
        SummaryCard("Description", draft.description, onEditDetails)
        SummaryCard("Reporter", if (draft.anonymous) "Anonymous report" else "Contact visible to officers", onEditDetails)
        Spacer(Modifier.height(8.dp))
        PrimaryButton("Submit Report", onClick = onSubmit)
        Spacer(Modifier.height(12.dp))
        SecondaryButton("Back to Edit", onClick = onEditDetails)
        Text(
            "Report will be sent to authorities and cached locally.",
            color = MediumGrey,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(top = 12.dp)
        )
    }
}

@Composable
fun ConfirmationScreen(reportId: String, onTrack: () -> Unit, onHome: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Cream)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(28.dp))
        Box(
            modifier = Modifier.size(72.dp).background(SuccessGreen, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("✓", color = Color.White, fontSize = 38.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(Modifier.height(18.dp))
        Text("Report Submitted Successfully", fontSize = 30.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
        Text("Your report has been sent to the forest department queue.", color = MediumGrey, textAlign = TextAlign.Center)
        Spacer(Modifier.height(16.dp))
        ForestCard {
            Text("TRACKING ID", color = MediumGrey, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Text(reportId, fontFamily = FontFamily.Monospace, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = ForestGreen, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                SecondaryButton("Copy", modifier = Modifier.weight(1f), onClick = {})
                SecondaryButton("Share", modifier = Modifier.weight(1f), onClick = {})
            }
        }
        Spacer(Modifier.height(12.dp))
        ForestCard {
            Text("Next Steps", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text("✓ Report queued")
            Text("✓ Rangers alerted")
            Text("• Status update coming soon")
            Text("• Notification when verified")
        }
        Spacer(Modifier.height(16.dp))
        PrimaryButton("Track Report in App", onClick = onTrack)
        Spacer(Modifier.height(12.dp))
        SecondaryButton("Back to Home", onClick = onHome)
        Spacer(Modifier.height(18.dp))
        Text("Thank you for protecting the Western Ghats.", color = MediumGrey, textAlign = TextAlign.Center)
    }
}
