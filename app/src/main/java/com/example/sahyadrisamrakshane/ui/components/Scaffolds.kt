package com.example.sahyadrisamrakshane.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sahyadrisamrakshane.model.Screen
import com.example.sahyadrisamrakshane.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForestScaffold(
    title: String,
    onBack: (() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title, fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    if (onBack != null) {
                        TextButton(onClick = onBack) {
                            Text("‹", color = Color.White, fontSize = 28.sp)
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = ForestGreen, titleContentColor = Color.White)
            )
        },
        containerColor = Cream,
        content = content
    )
}

@Composable
fun MainScaffold(
    title: String,
    selected: Screen,
    onTab: (Screen) -> Unit,
    fab: @Composable (() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    ForestScaffold(title) { padding ->
        Scaffold(
            modifier = Modifier.padding(padding),
            containerColor = Cream,
            floatingActionButton = { fab?.invoke() },
            bottomBar = {
                BottomAppBar(containerColor = Color.White) {
                    NavItem("HM", "Home", selected == Screen.Dashboard) { onTab(Screen.Dashboard) }
                    NavItem("MR", "My Reports", selected == Screen.Reports) { onTab(Screen.Reports) }
                    NavItem("TP", "Tips", selected == Screen.Tips) { onTab(Screen.Tips) }
                    NavItem("OD", "Officer", selected == Screen.Officer) { onTab(Screen.Officer) }
                }
            },
            content = content
        )
    }
}

@Composable
fun RowScope.NavItem(code: String, label: String, active: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier.weight(1f).clickable(onClick = onClick).padding(6.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(28.dp).border(1.dp, if (active) ForestGreen else MediumGrey, RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(code, color = if (active) ForestGreen else MediumGrey, fontSize = 10.sp, fontWeight = FontWeight.Bold)
        }
        Text(label, color = if (active) ForestGreen else MediumGrey, fontSize = 11.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ReportStepScaffold(title: String, step: Int, onBack: () -> Unit, content: @Composable () -> Unit) {
    ForestScaffold(title, onBack) { padding ->
        ScreenColumn(padding) {
            Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                Text("Step $step/5", color = MediumGrey, fontWeight = FontWeight.Bold)
                Text("${step * 20}%", color = MediumGrey, fontWeight = FontWeight.Bold)
            }
            LinearProgressIndicator(
                progress = { step / 5f },
                modifier = Modifier.fillMaxWidth().height(8.dp),
                color = ForestGreen,
                trackColor = LightGreen
            )
            Spacer(modifier = Modifier.height(10.dp))
            content()
        }
    }
}

@Composable
fun ScreenColumn(padding: PaddingValues, content: @Composable ColumnScope.() -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        content = content
    )
}
