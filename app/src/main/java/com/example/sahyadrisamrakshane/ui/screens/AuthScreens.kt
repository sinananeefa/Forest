package com.example.sahyadrisamrakshane.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sahyadrisamrakshane.ui.components.*
import com.example.sahyadrisamrakshane.ui.theme.*

@Composable
fun LoginScreen(onLogin: (String) -> Unit) {
    var email by remember { mutableStateOf("citizen@forestguard.local") }
    var password by remember { mutableStateOf("forest123") }

    ForestScaffold("Forest Guard") { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ForestMark()
            Text("ForestGuard", fontSize = 32.sp, fontWeight = FontWeight.Bold)
            Text("Login to protect our Western Ghats", color = MediumGrey)
            Spacer(Modifier.height(28.dp))
            ForestTextField("Email address", email, { email = it }, keyboardType = KeyboardType.Email)
            Spacer(Modifier.height(12.dp))
            ForestTextField(
                label = "Password",
                value = password,
                onValue = { password = it },
                password = true
            )
            Spacer(Modifier.height(18.dp))
            PrimaryButton(
                text = "Sign In",
                onClick = { onLogin(email.substringBefore("@").ifBlank { "Citizen" }) }
            )
            Spacer(Modifier.height(14.dp))
            DividerText("OR")
            Spacer(Modifier.height(14.dp))
            SecondaryButton(
                text = "Sign in with Google",
                onClick = { onLogin("Forest Friend") }
            )
            TextButton(onClick = { onLogin("Forest Friend") }) {
                Text("Do not have an account? Sign Up", color = ForestGreen, fontWeight = FontWeight.Bold)
            }
        }
    }
}
