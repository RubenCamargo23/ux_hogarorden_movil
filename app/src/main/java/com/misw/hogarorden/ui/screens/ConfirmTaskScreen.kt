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
import androidx.compose.material.icons.outlined.Notifications
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.misw.hogarorden.R
import com.misw.hogarorden.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmTaskScreen(
    onNavigateBack: () -> Unit,
    onConfirmTask: () -> Unit,
    onNavigateToNotices: () -> Unit
) {
    var comment by remember { mutableStateOf("") }
    var notifyOthers by remember { mutableStateOf(true) }
    var showSuccessDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Column {
                            Text("Confirmar Tarea", style = AppTypography.titleLarge, fontWeight = FontWeight.Bold)
                            Text("Lavar los platos • Cocina", style = AppTypography.bodySmall, color = Secondary)
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
                HorizontalDivider(color = OutlineVariant)
            }
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
            Spacer(modifier = Modifier.height(24.dp))

            // Evidence Image Card
            Card(
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, OutlineVariant),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .clip(RoundedCornerShape(12.dp))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.lavar_platos_confirmar_tarea_evidencia_image),
                            contentDescription = "Evidencia de la tarea",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                        // Top chip
                        Surface(
                            color = White,
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier.padding(12.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Primary, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Fregadero limpio", style = AppTypography.bodySmall, color = NeutralAction, fontWeight = FontWeight.Bold)
                            }
                        }

                        // Bottom buttons
                        Row(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .fillMaxWidth()
                                .padding(12.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            Button(
                                onClick = { },
                                modifier = Modifier.weight(1f).height(44.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = White, contentColor = NeutralAction),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Icon(Icons.Default.PhotoCamera, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Volver a tomar", style = AppTypography.labelMedium)
                            }
                            Button(
                                onClick = { },
                                modifier = Modifier.weight(1f).height(44.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = White, contentColor = NeutralAction),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Icon(Icons.Default.FlipCameraIos, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Cambiar foto", style = AppTypography.labelMedium)
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 4.dp).padding(bottom = 4.dp)
                    ) {
                        Icon(Icons.Default.CheckCircleOutline, contentDescription = null, tint = Primary, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Evidencia lista para notificar al hogar", style = AppTypography.bodyMedium, color = NeutralAction)
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Comment field Card
            Card(
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, OutlineVariant),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                    Text("Comentario para el hogar (opcional)", style = AppTypography.titleSmall, color = NeutralAction)
                    Spacer(modifier = Modifier.height(12.dp))

                    TextField(
                        value = comment,
                        onValueChange = { comment = it },
                        placeholder = { Text("Añade algún detalle si es necesario...", color = Secondary) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.colors(
                            unfocusedContainerColor = BackgroundColor,
                            focusedContainerColor = BackgroundColor,
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Switch and Reward Card
            Card(
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, OutlineVariant),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Icon(Icons.Outlined.Notifications, contentDescription = null, tint = NeutralAction, modifier = Modifier.size(20.dp))
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "Avisar a Brian y Ana al completar", 
                                style = AppTypography.titleMedium, 
                                color = NeutralAction, 
                                maxLines = 1,
                                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Switch(
                            checked = notifyOthers,
                            onCheckedChange = { notifyOthers = it },
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = White,
                                checkedTrackColor = Primary,
                                uncheckedThumbColor = White,
                                uncheckedTrackColor = OutlineVariant,
                                uncheckedBorderColor = Color.Transparent
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Surface(
                            color = SurfaceLightGreen,
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(16.dp)
                                        .background(Primary, CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(Icons.Default.Star, contentDescription = null, tint = White, modifier = Modifier.size(10.dp))
                                }
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("+10 puntos al confirmar", style = AppTypography.labelLarge.copy(fontSize = 11.sp), color = Primary)
                            }
                        }
                        Text("Recompensa activa", style = AppTypography.bodySmall, color = NeutralAction)
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Actions
            Button(
                onClick = { showSuccessDialog = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.Check, contentDescription = null, modifier = Modifier.size(20.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Confirmar y Enviar", fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }

            Spacer(modifier = Modifier.height(12.dp))

            TextButton(
                onClick = onNavigateBack,
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("Cancelar", color = Secondary, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }

    if (showSuccessDialog) {
        Dialog(
            onDismissRequest = { showSuccessDialog = false },
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(24.dp),
                color = White,
                shadowElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Check Icon
                    Box(
                        modifier = Modifier
                            .size(64.dp)
                            .background(SurfaceLightGreen, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Check,
                            contentDescription = "Success",
                            tint = Primary,
                            modifier = Modifier.size(32.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text("¡Genial, Rubén!", style = AppTypography.headlineSmall, fontWeight = FontWeight.Bold, color = NeutralAction)
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Text(
                        "Tu evidencia de 'Lavar los platos' fue validada y enviada a Casa de los Rosales.",
                        style = AppTypography.bodyMedium,
                        color = Secondary,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Rewards Card
                    Surface(
                        color = SurfaceLightGreen,
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(Icons.Default.Stars, contentDescription = null, tint = Primary, modifier = Modifier.size(16.dp))
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("+10 puntos ganados", color = Primary, style = AppTypography.labelMedium)
                            }
                            Surface(
                                color = White,
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(
                                    "Racha: 5 días \uD83D\uDD25",
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                    style = AppTypography.labelSmall,
                                    color = Primary
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Avatars Note
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        // Dummy avatars
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(Color(0xFFB2DFDB), CircleShape)
                                .border(1.dp, White, CircleShape),
                            contentAlignment = Alignment.Center
                        ) { Text("B", color = Primary, style = AppTypography.labelSmall) }
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .offset(x = (-8).dp)
                                .background(Primary, CircleShape)
                                .border(1.dp, White, CircleShape),
                            contentAlignment = Alignment.Center
                        ) { Text("A", color = White, style = AppTypography.labelSmall) }
                        
                        Text("Brian y Ana recibieron el aviso", style = AppTypography.bodySmall, color = Secondary)
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(Icons.Default.CheckCircle, contentDescription = null, tint = Primary, modifier = Modifier.size(14.dp))
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = {
                            showSuccessDialog = false
                            onConfirmTask()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Primary),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Volver a Mis Tareas", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    TextButton(
                        onClick = {
                            showSuccessDialog = false
                            onNavigateToNotices()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text("Ver en Avisos del Hogar", color = Primary, fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    }
                }
            }
        }
    }
}
