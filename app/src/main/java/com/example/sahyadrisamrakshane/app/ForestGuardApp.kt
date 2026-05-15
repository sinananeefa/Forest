package com.example.sahyadrisamrakshane.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.sahyadrisamrakshane.data.incidentType
import com.example.sahyadrisamrakshane.data.initialReports
import com.example.sahyadrisamrakshane.model.IncidentReport
import com.example.sahyadrisamrakshane.model.ReportDraft
import com.example.sahyadrisamrakshane.model.Screen
import com.example.sahyadrisamrakshane.ui.components.ForestFab
import com.example.sahyadrisamrakshane.ui.components.ForestScaffold
import com.example.sahyadrisamrakshane.ui.components.MainScaffold
import com.example.sahyadrisamrakshane.ui.components.ReportStepScaffold
import com.example.sahyadrisamrakshane.ui.screens.*
import com.example.sahyadrisamrakshane.ui.theme.*
import kotlin.random.Random

@Composable
fun ForestGuardApp() {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = ForestGreen,
            secondary = MediumGreen,
            background = Cream,
            surface = Cream,
            onPrimary = Color.White,
            onSecondary = Color.White,
            onBackground = DarkText,
            onSurface = DarkText
        )
    ) {
        var screen by remember { mutableStateOf(Screen.Login) }
        var userName by remember { mutableStateOf("Citizen") }
        var draft by remember { mutableStateOf(ReportDraft()) }
        var selectedReportId by remember { mutableStateOf("FG-2026-001234") }
        val reports = remember { mutableStateListOf(*initialReports().toTypedArray()) }

        fun openReport(reportId: String) {
            selectedReportId = reportId
            screen = Screen.Status
        }

        Surface(modifier = Modifier.fillMaxSize(), color = Cream) {
            when (screen) {
                Screen.Login -> LoginScreen(
                    onLogin = { name ->
                        userName = name
                        screen = Screen.Dashboard
                    }
                )
                Screen.Dashboard -> MainScaffold(
                    title = "Forest Guard",
                    selected = Screen.Dashboard,
                    onTab = { screen = it },
                    fab = {
                        ForestFab {
                            draft = ReportDraft()
                            screen = Screen.Type
                        }

                    }
                ) { padding ->
                    DashboardScreen(userName, reports, padding, ::openReport)
                }
                Screen.Reports -> MainScaffold("My Reports", Screen.Reports, { screen = it }) { padding ->
                    ReportsScreen(reports, padding, ::openReport)
                }
                Screen.Tips -> MainScaffold("Safety Tips", Screen.Tips, { screen = it }) { padding ->
                    TipsScreen(padding)
                }
                Screen.Officer -> MainScaffold("Forest Officer", Screen.Officer, { screen = it }) { padding ->
                    OfficerScreen(reports, padding, ::openReport)
                }
                Screen.Type -> ReportStepScaffold("Report Incident", 1, { screen = Screen.Dashboard }) {
                    TypeScreen(draft, onDraft = { draft = it }, onNext = { screen = Screen.Photo })
                }
                Screen.Photo -> ReportStepScaffold("Take Photo", 2, { screen = Screen.Type }) {
                    PhotoScreen {
                        draft = draft.copy(photoTaken = true)
                        screen = Screen.ConfirmPhoto
                    }
                }
                Screen.ConfirmPhoto -> ReportStepScaffold("Confirm Photo", 3, { screen = Screen.Photo }) {
                    ConfirmPhotoScreen(draft, onNext = { screen = Screen.Location }, onRetake = { screen = Screen.Photo })
                }
                Screen.Location -> ReportStepScaffold("Location", 4, { screen = Screen.ConfirmPhoto }) {
                    LocationScreen(
                        draft = draft,
                        onDraft = { draft = it },
                        onNext = { screen = Screen.Details }
                    )
                }
                Screen.Details -> ReportStepScaffold("Details", 5, { screen = Screen.Location }) {
                    DetailsScreen(draft, onDraft = { draft = it }, onReview = { screen = Screen.Review })
                }
                Screen.Review -> ForestScaffold("Review Report", onBack = { screen = Screen.Details }) { padding ->
                    ReviewScreen(
                        draft = draft,
                        padding = padding,
                        onEditType = { screen = Screen.Type },
                        onEditPhoto = { screen = Screen.Photo },
                        onEditLocation = { screen = Screen.Location },
                        onEditDetails = { screen = Screen.Details },
                        onSubmit = {
                            val meta = incidentType(draft.type)
                            val id = "FG-2026-${Random.nextInt(100000, 999999)}"
                            reports.add(
                                0,
                                IncidentReport(
                                    id = id,
                                    type = draft.type,
                                    title = meta.title,
                                    address = draft.address,
                                    description = draft.description,
                                    status = "reported",
                                    synced = true,
                                    createdAt = System.currentTimeMillis(),
                                    latitude = draft.latitude,
                                    longitude = draft.longitude,
                                    accuracy = draft.accuracy,
                                    anonymous = draft.anonymous
                                )
                            )
                            selectedReportId = id
                            draft = ReportDraft()
                            screen = Screen.Confirmation
                        }
                    )
                }
                Screen.Confirmation -> ConfirmationScreen(
                    reportId = selectedReportId,
                    onTrack = { screen = Screen.Status },
                    onHome = { screen = Screen.Dashboard }
                )
                Screen.Status -> ForestScaffold("My Reports", onBack = { screen = Screen.Reports }) { padding ->
                    StatusScreen(
                        report = reports.firstOrNull { it.id == selectedReportId } ?: reports.first(),
                        padding = padding
                    )
                }
            }
        }
    }
}
