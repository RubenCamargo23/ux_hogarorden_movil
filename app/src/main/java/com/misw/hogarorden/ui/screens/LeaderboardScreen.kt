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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.misw.hogarorden.Screen
import com.misw.hogarorden.ui.components.BottomNavBar
import com.misw.hogarorden.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaderboardScreen(
    onNavigateBack: () -> Unit,
    onNavigateBottomNav: (String) -> Unit
) {
    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(BackgroundColor)) {
                TopAppBar(
                    title = {
                        Column {
                            Text("Puntuación y Logros", style = AppTypography.titleLarge, fontWeight = FontWeight.Bold)
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.LocationOn, contentDescription = null, modifier = Modifier.size(12.dp), tint = Secondary)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Casa de los Rosales", style = AppTypography.labelMedium, color = Secondary)
                            }
                        }
                    },
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
            BottomNavBar(currentRoute = Screen.Leaderboard.route, onNavigate = onNavigateBottomNav)
        },
        containerColor = BackgroundColor
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Tarjeta de Puntuación
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
                        Text("TU PUNTUACIÓN", style = AppTypography.labelMedium, color = Secondary)
                        Surface(
                            color = BackgroundColor,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                "\uD83D\uDD25 Racha activa: 6 días",
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                style = AppTypography.labelSmall,
                                color = NeutralAction
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text("240", style = AppTypography.displayLarge, color = Primary, lineHeight = 64.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("pts", style = AppTypography.headlineSmall, color = Primary, modifier = Modifier.padding(bottom = 12.dp))
                    }
                    
                    Text("2º lugar en el piso", style = AppTypography.bodyMedium, color = NeutralAction)
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Meta semanal del piso (85%)", style = AppTypography.labelMedium, color = NeutralAction)
                        Text("85%", style = AppTypography.labelMedium, fontWeight = FontWeight.Bold, color = Primary)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = 0.85f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp)
                            .clip(RoundedCornerShape(4.dp)),
                        color = Primary,
                        trackColor = BackgroundColor
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Tabla de posiciones
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Tabla de posiciones", style = AppTypography.titleMedium, fontWeight = FontWeight.Bold, color = NeutralAction)
                Text("Esta semana", style = AppTypography.labelSmall, color = Secondary)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Rank 1
            RankItem(rank = 1, name = "Mateo C.", points = 280, isCurrentUser = false, hasCrown = true)
            Spacer(modifier = Modifier.height(12.dp))
            // Rank 2 (User)
            RankItem(rank = 2, name = "Rubén", points = 240, isCurrentUser = true, hasCrown = false)
            Spacer(modifier = Modifier.height(12.dp))
            // Rank 3
            RankItem(rank = 3, name = "Ana R.", points = 180, isCurrentUser = false, hasCrown = false)

            Spacer(modifier = Modifier.height(32.dp))
            
            // Muro de reconocimientos
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Muro de reconocimientos", style = AppTypography.titleMedium, fontWeight = FontWeight.Bold, color = NeutralAction)
                Text("Recientes", style = AppTypography.labelSmall, color = Secondary)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Tarjeta de reconocimiento
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
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier.size(24.dp).background(BackgroundColor, CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(16.dp), tint = Secondary)
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Mensaje de Brian", style = AppTypography.labelMedium, color = Secondary)
                        }
                        Text("Hace 2 horas", style = AppTypography.labelSmall, color = Secondary)
                    }
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    Text("\"Gracias por dejar la cocina reluciente\"", style = AppTypography.bodyMedium, color = NeutralAction)
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Divider(color = OutlineVariant, thickness = 1.dp)
                    
                    Spacer(modifier = Modifier.height(12.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Para Rubén", style = AppTypography.labelMedium, color = Secondary)
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.FavoriteBorder, contentDescription = null, modifier = Modifier.size(16.dp), tint = NeutralAction)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("1", style = AppTypography.labelMedium, color = NeutralAction)
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.FavoriteBorder, contentDescription = null, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Dar reconocimiento a un compañero", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun RankItem(rank: Int, name: String, points: Int, isCurrentUser: Boolean, hasCrown: Boolean) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        color = if (isCurrentUser) SurfaceLightGreen else White,
        border = BorderStroke(1.dp, if (isCurrentUser) Primary else OutlineVariant)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(32.dp).background(if (isCurrentUser) Primary else BackgroundColor, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("$rank", style = AppTypography.labelMedium, fontWeight = FontWeight.Bold, color = if (isCurrentUser) White else NeutralAction)
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(name, style = AppTypography.titleSmall, fontWeight = FontWeight.Bold, color = if (isCurrentUser) Primary else NeutralAction)
                
                if (hasCrown) {
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("\uD83D\uDC51", fontSize = 14.sp)
                }
                if (isCurrentUser) {
                    Spacer(modifier = Modifier.width(8.dp))
                    Surface(color = Color(0xFFB2DFDB), shape = RoundedCornerShape(8.dp)) {
                        Text("Tú", modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp), style = AppTypography.labelSmall, color = Primary)
                    }
                }
            }
            Row(verticalAlignment = Alignment.Bottom) {
                Text("$points", style = AppTypography.titleMedium, fontWeight = FontWeight.Bold, color = if (isCurrentUser) Primary else NeutralAction)
                Spacer(modifier = Modifier.width(4.dp))
                Text("pts", style = AppTypography.labelSmall, color = if (isCurrentUser) Primary else Secondary, modifier = Modifier.padding(bottom = 2.dp))
            }
        }
    }
}
