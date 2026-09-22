package com.misw.hogarorden.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.misw.hogarorden.R
import com.misw.hogarorden.Screen
import com.misw.hogarorden.ui.components.BottomNavBar
import com.misw.hogarorden.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onNavigateBack: () -> Unit,
    onNavigateBottomNav: (String) -> Unit,
    onLogout: () -> Unit
) {
    var softReminders by remember { mutableStateOf(true) }
    var homeNotifications by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(BackgroundColor)) {
                TopAppBar(
                    title = { Text("Mi Perfil", style = AppTypography.titleLarge, fontWeight = FontWeight.Bold) },
                    navigationIcon = {
                        IconButton(
                            onClick = onNavigateBack,
                            modifier = Modifier
                                .padding(start = 16.dp, end = 8.dp)
                                .size(40.dp)
                                .background(White, CircleShape)
                                .border(1.dp, OutlineVariant, CircleShape)
                        ) {
                            Icon(Icons.Default.ChevronLeft, contentDescription = "Volver", tint = NeutralAction)
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = BackgroundColor,
                        navigationIconContentColor = NeutralAction,
                        titleContentColor = NeutralAction
                    )
                )
                Divider(color = OutlineVariant, thickness = 1.dp)
            }
        },
        bottomBar = {
            BottomNavBar(currentRoute = Screen.Profile.route, onNavigate = onNavigateBottomNav)
        },
        containerColor = BackgroundColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Main Card
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                color = White,
                border = BorderStroke(1.dp, OutlineVariant)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Avatar
                    Box {
                        Image(
                            painter = painterResource(id = R.drawable.profile),
                            contentDescription = "Foto de perfil",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(80.dp)
                                .clip(CircleShape)
                                .border(2.dp, White, CircleShape)
                        )
                        Box(
                            modifier = Modifier
                                .align(Alignment.BottomEnd)
                                .offset(x = (-4).dp, y = (-4).dp)
                                .size(16.dp)
                                .background(Primary, CircleShape)
                                .border(2.dp, White, CircleShape)
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Text("Rubén Darío", style = AppTypography.titleLarge, fontWeight = FontWeight.Bold, color = NeutralAction)
                    Text("ruben@ejemplo.com", style = AppTypography.bodyMedium, color = Secondary)
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Surface(
                        color = SurfaceLightGreen,
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                            Box(modifier = Modifier.size(6.dp).background(Primary, CircleShape))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Conviviente · Casa de los Rosales", style = AppTypography.labelMedium, color = Primary)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Metrics Row
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                MetricCard(modifier = Modifier.weight(1f), value = "240", label = "pts", valueColor = Primary)
                MetricCard(modifier = Modifier.weight(1f), value = "Nivel 4", label = "armonía", valueColor = NeutralAction)
                MetricCard(modifier = Modifier.weight(1f), value = "98%", label = "a tiempo", valueColor = Primary)
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Hogar Actual
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                color = White,
                border = BorderStroke(1.dp, OutlineVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
                        Column {
                            Text("HOGAR ACTUAL", style = AppTypography.labelSmall, color = Secondary)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text("Casa de los Rosales", style = AppTypography.titleSmall, fontWeight = FontWeight.Bold, color = NeutralAction)
                        }
                        // Overlapping Avatars
                        Row {
                            AvatarDummy(color = Color(0xFFB2DFDB), text = "B", offset = 0)
                            AvatarDummy(color = Color(0xFFFFCCBC), text = "A", offset = -8)
                            AvatarDummy(color = Color(0xFFC5CAE9), text = "M", offset = -16)
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Divider(color = OutlineVariant, thickness = 1.dp)
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Row {
                            Text("Código: ", style = AppTypography.bodyMedium, color = Secondary)
                            Text("ROSALES-784", style = AppTypography.bodyMedium, fontWeight = FontWeight.Bold, color = Primary)
                        }
                        Surface(
                            shape = RoundedCornerShape(8.dp),
                            border = BorderStroke(1.dp, OutlineVariant)
                        ) {
                            Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.ContentCopy, contentDescription = null, modifier = Modifier.size(14.dp), tint = Primary)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Copiar", style = AppTypography.labelMedium, color = Primary)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Preferencias
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                color = White,
                border = BorderStroke(1.dp, OutlineVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("PREFERENCIAS DE TAREAS", style = AppTypography.labelSmall, fontWeight = FontWeight.Bold, color = NeutralAction)
                        Text("Turnos y afinidad", style = AppTypography.labelSmall, color = Secondary)
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        PreferenceChip(icon = Icons.Default.Restaurant, label = "Cocina")
                        PreferenceChip(icon = Icons.Default.Inventory, label = "Organización")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        PreferenceChip(icon = Icons.Default.ShoppingBasket, label = "Despensa")
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Ajustes
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                color = White,
                border = BorderStroke(1.dp, OutlineVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Recordatorios suaves", style = AppTypography.bodyMedium, fontWeight = FontWeight.Bold)
                            Text("Alertas no invasivas de tareas pendientes", style = AppTypography.bodySmall, color = Secondary)
                        }
                        Switch(
                            checked = softReminders,
                            onCheckedChange = { softReminders = it },
                            colors = SwitchDefaults.colors(checkedThumbColor = White, checkedTrackColor = Primary)
                        )
                    }
                    
                    Divider(modifier = Modifier.padding(vertical = 12.dp), color = OutlineVariant)
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Notificaciones del hogar", style = AppTypography.bodyMedium, fontWeight = FontWeight.Bold)
                            Text("Avisos comunitarios y notas generales", style = AppTypography.bodySmall, color = Secondary)
                        }
                        Switch(
                            checked = homeNotifications,
                            onCheckedChange = { homeNotifications = it },
                            colors = SwitchDefaults.colors(checkedThumbColor = White, checkedTrackColor = Primary)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Logout
            Button(
                onClick = onLogout,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFDECEA)),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.Logout, contentDescription = null, tint = Color(0xFFD32F2F), modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Cerrar sesión", fontSize = 16.sp, fontWeight = FontWeight.Medium, color = Color(0xFFD32F2F))
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun MetricCard(modifier: Modifier = Modifier, value: String, label: String, valueColor: Color) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        color = White,
        border = BorderStroke(1.dp, OutlineVariant)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(value, style = AppTypography.titleMedium, fontWeight = FontWeight.Bold, color = valueColor)
            Spacer(modifier = Modifier.height(4.dp))
            Text(label, style = AppTypography.labelSmall, color = Secondary)
        }
    }
}

@Composable
fun AvatarDummy(color: Color, text: String, offset: Int) {
    Box(
        modifier = Modifier
            .offset(x = offset.dp)
            .size(28.dp)
            .background(color, CircleShape)
            .border(1.dp, White, CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(text, style = AppTypography.labelSmall, fontWeight = FontWeight.Bold, color = NeutralAction)
    }
}

@Composable
fun PreferenceChip(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String) {
    Surface(
        color = BackgroundColor,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, OutlineVariant)
    ) {
        Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = null, modifier = Modifier.size(16.dp), tint = Primary)
            Spacer(modifier = Modifier.width(6.dp))
            Text(label, style = AppTypography.labelMedium, color = NeutralAction)
        }
    }
}
