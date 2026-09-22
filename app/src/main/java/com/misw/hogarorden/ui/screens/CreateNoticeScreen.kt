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
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.misw.hogarorden.Screen
import com.misw.hogarorden.ui.components.BottomNavBar
import com.misw.hogarorden.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateNoticeScreen(
    onNavigateBack: () -> Unit,
    onNavigateBottomNav: (String) -> Unit,
    onPublish: () -> Unit
) {
    var title by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var notifyImmediate by remember { mutableStateOf(true) }
    var pinToBoard by remember { mutableStateOf(false) }

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
                        containerColor = White,
                        navigationIconContentColor = NeutralAction,
                        titleContentColor = NeutralAction
                    )
                )
                Divider(color = OutlineVariant, thickness = 1.dp)
            }
        },
        bottomBar = {
            BottomNavBar(currentRoute = Screen.Notices.route, onNavigate = onNavigateBottomNav) // Remains on Notices tab active
        },
        containerColor = White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Tipo de aviso
            Text("Tipo de aviso", style = AppTypography.labelMedium, color = Secondary)
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Surface(
                    color = SurfaceLightGreen,
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, Primary)
                ) {
                    Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Campaign, contentDescription = null, tint = Primary, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Nota rápida", style = AppTypography.labelMedium, color = Primary)
                    }
                }
                Surface(
                    color = White,
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, OutlineVariant)
                ) {
                    Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.ShoppingBag, contentDescription = null, tint = Secondary, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Insumos / Compra", style = AppTypography.labelMedium, color = NeutralAction)
                    }
                }
                Surface(
                    color = White,
                    shape = RoundedCornerShape(20.dp),
                    border = BorderStroke(1.dp, OutlineVariant)
                ) {
                    Row(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp), verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(6.dp).background(Color(0xFFD32F2F), CircleShape))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Urgente", style = AppTypography.labelMedium, color = NeutralAction)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Título
            Text("Título o asunto breve", style = AppTypography.labelMedium, color = Secondary)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Ej. Detergente en cocina o café listo...", color = OutlineVariant) },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = OutlineVariant,
                    focusedBorderColor = Primary
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Mensaje
            Text("Mensaje para la casa", style = AppTypography.labelMedium, color = Secondary)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
                value = message,
                onValueChange = { if (it.length <= 250) message = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                placeholder = { Text("Escribe aquí los detalles para tus compañeros de piso...", color = OutlineVariant) },
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = OutlineVariant,
                    focusedBorderColor = Primary
                )
            )
            Text(
                "${message.length} / 250",
                style = AppTypography.labelSmall,
                color = Secondary,
                modifier = Modifier.align(Alignment.End).padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Adjuntar foto
            Text("Adjuntar foto o comprobante", style = AppTypography.labelMedium, color = Secondary)
            Spacer(modifier = Modifier.height(8.dp))
            val dashEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(White)
            ) {
                // Custom dashed border
                Box(modifier = Modifier.fillMaxSize().padding(1.dp)) // padding to show full border
                // We'll use a standard border with no dash since Compose Modifier.border doesn't support PathEffect natively in a simple way
                // A canvas drawing is better, but a solid outlined box works for now with OutlineVariant
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = White,
                    shape = RoundedCornerShape(12.dp),
                    border = BorderStroke(1.dp, OutlineVariant)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier.size(40.dp).background(BackgroundColor, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.PhotoCamera, contentDescription = null, tint = Primary)
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Row {
                            Text("Adjuntar foto o recibo", style = AppTypography.bodyMedium, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("(Opcional)", style = AppTypography.bodyMedium, color = Secondary)
                        }
                        Text("JPG o PNG hasta 10MB", style = AppTypography.labelSmall, color = Secondary)
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Surface(color = BackgroundColor, shape = RoundedCornerShape(8.dp)) {
                                Text("Tomar foto", modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), style = AppTypography.labelMedium, fontWeight = FontWeight.Bold)
                            }
                            Surface(color = BackgroundColor, shape = RoundedCornerShape(8.dp)) {
                                Text("Galería", modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp), style = AppTypography.labelMedium, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Opciones de Difusión
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                color = White,
                border = BorderStroke(1.dp, OutlineVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("OPCIONES DE DIFUSIÓN", style = AppTypography.labelMedium, fontWeight = FontWeight.Bold, color = NeutralAction)
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Notificar de inmediato", style = AppTypography.bodyMedium, fontWeight = FontWeight.Bold)
                            Text("Envía un aviso instantáneo a todos los compañeros", style = AppTypography.bodySmall, color = Secondary)
                        }
                        Switch(
                            checked = notifyImmediate,
                            onCheckedChange = { notifyImmediate = it },
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
                            Text("Fijar en el tablón (24h)", style = AppTypography.bodyMedium, fontWeight = FontWeight.Bold)
                            Text("Mantener en la parte superior de la vista de avisos", style = AppTypography.bodySmall, color = Secondary)
                        }
                        Switch(
                            checked = pinToBoard,
                            onCheckedChange = { pinToBoard = it },
                            colors = SwitchDefaults.colors(checkedThumbColor = White, checkedTrackColor = Primary)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = onPublish,
                modifier = Modifier.fillMaxWidth().height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.WarningAmber, contentDescription = null, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Publicar aviso en el hogar", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                "Visible para los 4 integrantes de Casa de los Rosales",
                style = AppTypography.labelSmall,
                color = Secondary,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}
