package com.misw.hogarorden.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.misw.hogarorden.R
import com.misw.hogarorden.Screen
import com.misw.hogarorden.ui.components.BottomNavBar
import com.misw.hogarorden.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoticesScreen(
    onNavigateBottomNav: (String) -> Unit,
    onNavigateToCreateNotice: () -> Unit
) {
    Scaffold(
        topBar = {
            Column(modifier = Modifier.background(White)) {
                TopAppBar(
                    title = {
                        Column {
                            Text("Avisos", style = AppTypography.titleLarge, fontWeight = FontWeight.Bold)
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.LocationOn, contentDescription = null, modifier = Modifier.size(12.dp), tint = Secondary)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Casa de los Rosales", style = AppTypography.labelMedium, color = Secondary)
                            }
                        }
                    },
                    navigationIcon = {
                        IconButton(
                            onClick = { /* Do nothing or navigate back if needed */ },
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
                        containerColor = White,
                        navigationIconContentColor = NeutralAction,
                        titleContentColor = NeutralAction
                    )
                )
                Divider(color = OutlineVariant, thickness = 1.dp)
            }
        },
        bottomBar = {
            BottomNavBar(currentRoute = Screen.Notices.route, onNavigate = onNavigateBottomNav)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onNavigateToCreateNotice,
                containerColor = Primary,
                contentColor = White,
                icon = { Icon(Icons.Default.Add, contentDescription = null) },
                text = { Text("Nuevo aviso", fontWeight = FontWeight.Medium) }
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = BackgroundColor
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentPadding = PaddingValues(bottom = 80.dp) // extra padding for FAB
        ) {
            item {
                Column(modifier = Modifier.padding(16.dp)) {
                    // Header section
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text("Avisos del Hogar", style = AppTypography.headlineMedium, fontWeight = FontWeight.Bold, color = NeutralAction)
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(modifier = Modifier.size(6.dp).background(Primary, CircleShape))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Casa de los Rosales · 3 avisos recientes", style = AppTypography.bodySmall, color = Secondary)
                            }
                        }
                        Button(
                            onClick = onNavigateToCreateNotice,
                            colors = ButtonDefaults.buttonColors(containerColor = Primary),
                            shape = RoundedCornerShape(12.dp),
                            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                        ) {
                            Icon(Icons.Default.Notes, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Nuevo", fontSize = 14.sp)
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Filters
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        item { FilterChip(selected = true, label = "Todos (4)", onClick = {}) }
                        item { FilterChip(selected = false, label = "Urgentes (1)", onClick = {}) }
                        item { FilterChip(selected = false, label = "Recordatorios", onClick = {}) }
                        item { FilterChip(selected = false, label = "Comunidad", onClick = {}) }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Turno por vencer card
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFFFDF5F2), // Light peach/orange background
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Box(
                                        modifier = Modifier
                                            .size(32.dp)
                                            .background(Color(0xFF8D6E63), RoundedCornerShape(8.dp)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(Icons.Default.HourglassBottom, contentDescription = null, tint = White, modifier = Modifier.size(16.dp))
                                    }
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("TURNO POR VENCER", style = AppTypography.labelMedium, color = Color(0xFF5D4037))
                                }
                                Surface(
                                    color = White,
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.dp, Color(0xFFE0E0E0))
                                ) {
                                    Text(
                                        "2 horas",
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                        style = AppTypography.labelSmall,
                                        color = Color(0xFFD32F2F)
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(12.dp))

                            Text("Lavar los platos", style = AppTypography.titleLarge, fontWeight = FontWeight.Bold, color = NeutralAction)
                            
                            Spacer(modifier = Modifier.height(4.dp))
                            
                            Text(
                                "Turno asignado a Rubén. Recuerda dejar el escurridor limpio y despejar el área del fregadero.",
                                style = AppTypography.bodyMedium,
                                color = Secondary
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Row(modifier = Modifier.fillMaxWidth()) {
                                Button(
                                    onClick = { },
                                    modifier = Modifier.weight(1f).height(44.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Primary),
                                    shape = RoundedCornerShape(12.dp)
                                ) {
                                    Text("Ver mi tarea", fontSize = 14.sp)
                                    Spacer(modifier = Modifier.width(4.dp))
                                    Icon(Icons.Default.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
                                }
                                Spacer(modifier = Modifier.width(8.dp))
                                OutlinedButton(
                                    onClick = { },
                                    modifier = Modifier.weight(1f).height(44.dp),
                                    shape = RoundedCornerShape(12.dp),
                                    border = BorderStroke(1.dp, OutlineVariant)
                                ) {
                                    Text("Posponer con aviso", color = NeutralAction, fontSize = 14.sp)
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("ACTIVIDAD Y NOTAS DE CONVIVENCIA", style = AppTypography.labelMedium, color = Secondary)
                        Text("Actualizado ahora", style = AppTypography.labelSmall, color = Secondary)
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    // Feed Items
                    FeedItemTaskCompleted()
                    Spacer(modifier = Modifier.height(16.dp))
                    FeedItemGeneralNote()
                    Spacer(modifier = Modifier.height(16.dp))
                    FeedItemNextTurn()
                    Spacer(modifier = Modifier.height(16.dp))
                    FeedItemHarmony()
                }
            }
        }
    }
}

@Composable
fun FilterChip(selected: Boolean, label: String, onClick: () -> Unit) {
    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(20.dp),
        color = if (selected) Primary else White,
        border = if (selected) null else BorderStroke(1.dp, OutlineVariant)
    ) {
        Text(
            text = label,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            style = AppTypography.labelMedium,
            color = if (selected) White else NeutralAction
        )
    }
}

@Composable
fun FeedItemTaskCompleted() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = White,
        shadowElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Row {
                    Box(
                        modifier = Modifier.size(40.dp).background(SurfaceLightGreen, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.Check, contentDescription = null, tint = Primary)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Brian", fontWeight = FontWeight.Bold, style = AppTypography.bodyMedium)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("completó su tarea", style = AppTypography.bodyMedium, color = Secondary)
                        }
                        Text("Hace 45 min", style = AppTypography.labelSmall, color = Secondary)
                    }
                }
                Box(modifier = Modifier.size(8.dp).background(Color(0xFF80CBC4), CircleShape))
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Text("Sacar la basura y separar reciclaje. Todo en orden en el patio exterior.", style = AppTypography.bodyMedium)
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Image attachment mock
            Surface(
                color = BackgroundColor,
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier.size(40.dp).background(Color.LightGray, RoundedCornerShape(8.dp))
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text("Comprobante_reciclaje.jpg", style = AppTypography.labelMedium, fontWeight = FontWeight.Bold)
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.CheckCircle, contentDescription = null, modifier = Modifier.size(12.dp), tint = Secondary)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Verificado", style = AppTypography.labelSmall, color = Secondary)
                            }
                        }
                    }
                    Icon(Icons.Default.Search, contentDescription = null, tint = Secondary)
                }
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = BackgroundColor,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.FavoriteBorder, contentDescription = null, modifier = Modifier.size(14.dp), tint = Secondary)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Reconocer", style = AppTypography.labelMedium, color = Secondary)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("1", style = AppTypography.labelMedium, fontWeight = FontWeight.Bold)
                    }
                }
                Text("Comedor & Cocina", style = AppTypography.labelSmall, color = Secondary)
            }
        }
    }
}

@Composable
fun FeedItemGeneralNote() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = White,
        shadowElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Row {
                    Box(
                        modifier = Modifier.size(40.dp).background(Color(0xFFFFCCBC), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("A", color = Color(0xFFD84315), fontWeight = FontWeight.Bold)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text("Ana R.", fontWeight = FontWeight.Bold, style = AppTypography.bodyMedium)
                            Spacer(modifier = Modifier.width(8.dp))
                            Surface(color = Color(0xFFECEFF1), shape = RoundedCornerShape(4.dp)) {
                                Text("Nota general", modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp), style = AppTypography.labelSmall, color = Secondary)
                            }
                        }
                        Text("Hoy, 10:15 am", style = AppTypography.labelSmall, color = Secondary)
                    }
                }
                Icon(Icons.Default.MoreVert, contentDescription = null, tint = Secondary)
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Text("Compré jabón lavavajillas y esponjas nuevas, están guardadas bajo el fregadero en el organizador verde. ¡Dejé el ticket en la pizarra!", style = AppTypography.bodyMedium)
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Row {
                Surface(
                    color = BackgroundColor,
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.ThumbUpOffAlt, contentDescription = null, modifier = Modifier.size(14.dp), tint = Secondary)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Agradecer (2)", style = AppTypography.labelMedium, color = Secondary)
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.ChatBubbleOutline, contentDescription = null, modifier = Modifier.size(14.dp), tint = Secondary)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Comentar", style = AppTypography.labelMedium, color = Secondary)
                }
            }
        }
    }
}

@Composable
fun FeedItemNextTurn() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = White,
        shadowElevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Row {
                    Box(
                        modifier = Modifier.size(40.dp).background(BackgroundColor, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(Icons.Default.SyncAlt, contentDescription = null, tint = Secondary)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("Próximo turno asignado", fontWeight = FontWeight.Bold, style = AppTypography.bodyMedium)
                        Text("Ayer", style = AppTypography.labelSmall, color = Secondary)
                    }
                }
                Surface(color = Color(0xFFECEFF1), shape = RoundedCornerShape(12.dp)) {
                    Text("Rotativo", modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), style = AppTypography.labelSmall, color = Secondary)
                }
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Text("El sábado te corresponde la limpieza profunda del refrigerador según el turno rotativo acordado.", style = AppTypography.bodyMedium)
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.CalendarToday, contentDescription = null, modifier = Modifier.size(14.dp), tint = Secondary)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Sábado, 10:00 am", style = AppTypography.labelMedium, color = Secondary)
                }
                Text("Añadir a mi agenda", style = AppTypography.labelMedium, fontWeight = FontWeight.Bold, color = Primary)
            }
        }
    }
}

@Composable
fun FeedItemHarmony() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = BackgroundColor
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier.size(48.dp).background(SurfaceLightGreen, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(Icons.Default.Eco, contentDescription = null, tint = Primary)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("Convivencia en armonía", fontWeight = FontWeight.Bold, style = AppTypography.bodyMedium)
                Text("Los 4 habitantes están al día con sus tareas comunitarias de la semana.", style = AppTypography.bodySmall, color = Secondary)
            }
        }
    }
}
