package com.misw.hogarorden.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.misw.hogarorden.ui.theme.*

import com.misw.hogarorden.Screen
import com.misw.hogarorden.ui.components.BottomNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigateToTaskDetail: () -> Unit,
    onNavigateBottomNav: (String) -> Unit
) {
    Scaffold(
        bottomBar = { BottomNavBar(currentRoute = Screen.Home.route, onNavigate = onNavigateBottomNav) },
        containerColor = BackgroundColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            // Header
            Text(
                text = "Mis tareas",
                style = AppTypography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = NeutralAction
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Miércoles, 24 Mayo • ", style = AppTypography.bodySmall, color = Secondary)
                Icon(Icons.Default.LocationOn, contentDescription = null, modifier = Modifier.size(12.dp), tint = Secondary)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Casa de los Rosales", style = AppTypography.bodySmall, color = Secondary)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Progress Card
            Card(
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, OutlineVariant),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Ritmo del día", style = AppTypography.titleMedium, fontWeight = FontWeight.Bold, color = NeutralAction)
                        val progressText = buildAnnotatedString {
                            append("1 de 3 completadas ")
                            withStyle(style = SpanStyle(color = Primary)) {
                                append("(33%)")
                            }
                        }
                        Text(text = progressText, style = AppTypography.bodySmall)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = { 0.33f },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(12.dp)
                            .clip(RoundedCornerShape(6.dp)),
                        color = Primary,
                        trackColor = BackgroundColor
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Alert Card
            Card(
                colors = CardDefaults.cardColors(containerColor = SurfaceLightRed),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, OutlineVariant),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.Schedule, contentDescription = null, tint = ErrorColor, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        "Lavar los platos vence en 2 horas",
                        color = ErrorColor,
                        style = AppTypography.bodyMedium,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Filters
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(
                    selected = true,
                    onClick = { },
                    label = { Text("Todas (3)", color = White) },
                    colors = FilterChipDefaults.filterChipColors(selectedContainerColor = Primary),
                    border = FilterChipDefaults.filterChipBorder(enabled = true, selected = true, borderColor = Primary),
                    shape = RoundedCornerShape(16.dp)
                )
                FilterChip(
                    selected = false,
                    onClick = { },
                    label = { Text("Cocina", color = Secondary) },
                    border = FilterChipDefaults.filterChipBorder(enabled = true, selected = false, borderColor = OutlineVariant),
                    colors = FilterChipDefaults.filterChipColors(containerColor = White),
                    shape = RoundedCornerShape(16.dp)
                )
                FilterChip(
                    selected = false,
                    onClick = { },
                    label = { Text("Zonas comunes", color = Secondary) },
                    border = FilterChipDefaults.filterChipBorder(enabled = true, selected = false, borderColor = OutlineVariant),
                    colors = FilterChipDefaults.filterChipColors(containerColor = White),
                    shape = RoundedCornerShape(16.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Pending Tasks Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("TAREAS PENDIENTES", style = AppTypography.labelMedium, color = Secondary)
                Text("2 restantes", style = AppTypography.bodyMedium, color = Secondary)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Task 1
            TaskItem(
                title = "Lavar los platos",
                subtitle = "Cocina • 8:00 pm",
                requiresPhoto = true,
                completed = false,
                onClick = onNavigateToTaskDetail
            )

            // Task 2
            TaskItem(
                title = "Sacar la basura",
                subtitle = "Exterior • 9:00 pm",
                requiresPhoto = false,
                completed = false,
                onClick = onNavigateToTaskDetail
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Completed Tasks Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("COMPLETADAS HOY", style = AppTypography.labelMedium, color = Secondary)
                Text("1", style = AppTypography.bodyMedium, color = Secondary)
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Task 3
            TaskItem(
                title = "Trapear la sala",
                subtitle = "Rubén • 11:30 am",
                requiresPhoto = false,
                completed = true,
                hasImage = true,
                onClick = {}
            )

            Spacer(modifier = Modifier.height(24.dp))

            // New Task Button
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Nueva tarea", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun TaskItem(
    title: String,
    subtitle: String,
    requiresPhoto: Boolean,
    completed: Boolean,
    hasImage: Boolean = false,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, OutlineVariant),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = if (completed) Icons.Filled.CheckCircle else Icons.Outlined.Circle,
                contentDescription = null,
                tint = if (completed) Secondary else OutlineVariant,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = AppTypography.titleMedium.copy(fontWeight = FontWeight.Medium),
                    color = if (completed) Secondary else NeutralAction,
                    textDecoration = if (completed) TextDecoration.LineThrough else TextDecoration.None
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = subtitle, style = AppTypography.bodySmall, color = Secondary)
                    if (requiresPhoto) {
                        Spacer(modifier = Modifier.width(8.dp))
                        Row(
                            modifier = Modifier
                                .background(SurfaceLightGreen, RoundedCornerShape(4.dp))
                                .padding(horizontal = 4.dp, vertical = 2.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Default.CameraAlt, contentDescription = null, tint = Primary, modifier = Modifier.size(10.dp))
                            Spacer(modifier = Modifier.width(2.dp))
                            Text("Requiere foto", color = Primary, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
            if (hasImage) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.LightGray, RoundedCornerShape(8.dp))
                )
            } else if (!completed) {
                Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Secondary)
            }
        }
    }
}

