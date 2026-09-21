package com.misw.hogarorden.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.misw.hogarorden.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskDetailScreen(
    onNavigateBack: () -> Unit,
    onNavigateToPostpone: () -> Unit,
    onNavigateToConfirm: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Mis tareas", style = AppTypography.bodyLarge, fontWeight = FontWeight.Bold)
                        Text("Lavar los platos • Cocina", style = AppTypography.bodySmall, color = Secondary)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ChevronLeft, contentDescription = "Volver")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor,
                    navigationIconContentColor = NeutralAction,
                    titleContentColor = NeutralAction
                )
            )
        },
        containerColor = BackgroundColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Title
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Default.CleaningServices, contentDescription = null, tint = Primary)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Lavar los platos", style = AppTypography.titleLarge, color = NeutralAction)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Image placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.LightGray)
            ) {
                // Racha chip
                Surface(
                    color = Color.White,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(12.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(Icons.Default.LocalFireDepartment, contentDescription = null, tint = Accent, modifier = Modifier.size(14.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Racha: 4 días", style = AppTypography.bodySmall, color = Accent, fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Info Grid
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                InfoCard(
                    modifier = Modifier.weight(1f),
                    label = "ESPACIO",
                    icon = Icons.Default.LocationOn,
                    value = "Cocina"
                )
                InfoCard(
                    modifier = Modifier.weight(1f),
                    label = "FRECUENCIA",
                    icon = Icons.Default.Schedule,
                    value = "Diaria"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                InfoCard(
                    modifier = Modifier.weight(1f),
                    label = "ASIGNADA A",
                    icon = Icons.Default.Person,
                    value = "Rubén (tú)"
                )
                InfoCard(
                    modifier = Modifier.weight(1f),
                    label = "CIERRE",
                    icon = Icons.Default.CameraAlt,
                    value = "Requiere foto"
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Acuerdos
            Card(
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Handshake, contentDescription = null, tint = Accent, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("ACUERDOS DE CONVIVENCIA", style = AppTypography.labelLarge.copy(fontSize = 12.sp), color = Secondary)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Dejar el escurridor limpio y secar sartenes de teflón con paño suave.",
                        style = AppTypography.bodySmall,
                        color = NeutralAction
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Actions
            Button(
                onClick = onNavigateToConfirm,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Marcar como hecha", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(
                onClick = onNavigateToPostpone,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Accent),
                border = null, // In the mockup, it looks like a text button with icon
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(Icons.Default.Schedule, contentDescription = null, modifier = Modifier.size(20.dp), tint = Accent)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Posponer con aviso", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Accent)
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun InfoCard(modifier: Modifier = Modifier, label: String, icon: androidx.compose.ui.graphics.vector.ImageVector, value: String) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = White),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(label, style = AppTypography.labelLarge.copy(fontSize = 10.sp), color = Secondary)
            Spacer(modifier = Modifier.height(4.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, contentDescription = null, modifier = Modifier.size(14.dp), tint = NeutralAction)
                Spacer(modifier = Modifier.width(4.dp))
                Text(value, style = AppTypography.bodySmall, color = NeutralAction, fontWeight = FontWeight.Medium)
            }
        }
    }
}
