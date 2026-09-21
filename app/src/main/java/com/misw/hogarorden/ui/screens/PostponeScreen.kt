package com.misw.hogarorden.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.misw.hogarorden.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PostponeScreen(
    onNavigateBack: () -> Unit,
    onConfirmPostpone: () -> Unit
) {
    var selectedOption by remember { mutableStateOf(0) }
    var message by remember { mutableStateOf("Estoy saliendo tarde del trabajo, la lavo apenas llegue a las 10 pm.") }

    Scaffold(
        topBar = {
            Column {
                TopAppBar(
                    title = {
                        Column {
                            Text("Posponer Tarea", style = AppTypography.bodyLarge, fontWeight = FontWeight.Bold)
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
            Spacer(modifier = Modifier.height(16.dp))

            // Limit card
            Card(
                colors = CardDefaults.cardColors(containerColor = White),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, OutlineVariant),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .background(Color(0xFFE8F5F3), RoundedCornerShape(8.dp))
                                .border(1.dp, OutlineVariant, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.Schedule, contentDescription = null, tint = Primary, modifier = Modifier.size(16.dp))
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column {
                            Text("LÍMITE PROGRAMADO", style = AppTypography.labelLarge.copy(fontSize = 10.sp), color = Secondary)
                            Text("Hoy, 8:00 pm", style = AppTypography.bodyMedium, color = NeutralAction, fontWeight = FontWeight.Bold)
                        }
                    }
                    Surface(
                        color = Color(0xFFFDF2F2),
                        shape = RoundedCornerShape(8.dp),
                        border = BorderStroke(1.dp, Color(0xFFFAD2D2))
                    ) {
                        Text(
                            "Pendiente",
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                            color = Accent,
                            style = AppTypography.labelLarge.copy(fontSize = 10.sp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                "Avisar a tus compañeros de piso evita confusiones y mantiene la armonía del hogar sin penalizaciones de puntos.",
                style = AppTypography.bodySmall,
                color = Secondary
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text("¿CUÁNDO PODRÁS HACERLA?", style = AppTypography.labelLarge.copy(fontSize = 12.sp), color = Secondary)
            Spacer(modifier = Modifier.height(8.dp))

            // Options
            PostponeOption(
                title = "En 2 horas",
                subtitle = "Hoy a las 10:00 pm",
                selected = selectedOption == 0,
                isSuggested = true,
                onClick = { selectedOption = 0 }
            )
            PostponeOption(
                title = "Mañana por la mañana",
                subtitle = "9:00 am antes de salir",
                selected = selectedOption == 1,
                onClick = { selectedOption = 1 }
            )
            PostponeOption(
                title = "Mañana por la tarde",
                subtitle = "3:00 pm",
                selected = selectedOption == 2,
                onClick = { selectedOption = 2 }
            )
            
            // Custom option (Dashed border)
            val dashPathEffect = PathEffect.dashPath(floatArrayOf(15f, 15f), 0f)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .drawBehind {
                        drawRoundRect(
                            color = OutlineVariant,
                            style = Stroke(width = 1.dp.toPx(), pathEffect = dashPathEffect),
                            cornerRadius = CornerRadius(8.dp.toPx())
                        )
                    }
                    .clickable { /* open picker */ }
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.RadioButtonUnchecked, contentDescription = null, tint = OutlineVariant)
                        Spacer(modifier = Modifier.width(16.dp))
                        Text("Definir otra hora personalizada...", style = AppTypography.bodyMedium, color = NeutralAction)
                    }
                    Icon(Icons.Default.ChevronRight, contentDescription = null, tint = Secondary)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("MENSAJE PARA LA CASA (OPCIONAL)", style = AppTypography.labelLarge.copy(fontSize = 12.sp), color = Secondary)
                Text("64 / 150", style = AppTypography.bodySmall.copy(fontSize = 10.sp), color = Secondary)
            }
            Spacer(modifier = Modifier.height(8.dp))

            // Message box with chips inside
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(White, RoundedCornerShape(12.dp))
                    .border(1.dp, OutlineVariant, RoundedCornerShape(12.dp))
                    .padding(12.dp)
            ) {
                BasicTextField(
                    value = message,
                    onValueChange = { message = it },
                    textStyle = AppTypography.bodyMedium.copy(color = NeutralAction),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    MessageChip("💼 Trabajo")
                    MessageChip("🤒 Salud")
                    MessageChip("📚 Estudio")
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Notification Card
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFDF2F2)),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color(0xFFFAD2D2)),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Icon(Icons.Default.NotificationsActive, contentDescription = null, tint = Accent, modifier = Modifier.size(20.dp))
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text("Se notificará a Casa de los Rosales", style = AppTypography.bodyMedium, fontWeight = FontWeight.Bold, color = Accent)
                        Spacer(modifier = Modifier.height(4.dp))
                        val annotatedText = buildAnnotatedString {
                            append("Brian y Ana verán el nuevo horario acordado en la pestaña de ")
                            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                                append("Avisos")
                            }
                            append(". Tu racha se mantiene intacta si la completas dentro del nuevo plazo.")
                        }
                        Text(
                            text = annotatedText,
                            style = AppTypography.bodySmall,
                            color = Accent
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Submit
            Button(
                onClick = onConfirmPostpone,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary),
                shape = RoundedCornerShape(8.dp)
            ) {
                Icon(Icons.Outlined.Send, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text("Enviar aviso y posponer", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(
                onClick = onNavigateBack,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancelar y volver", color = Secondary)
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun MessageChip(text: String) {
    Surface(
        color = White,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, OutlineVariant)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            style = AppTypography.bodySmall,
            color = NeutralAction
        )
    }
}

@Composable
fun PostponeOption(
    title: String,
    subtitle: String,
    selected: Boolean,
    isSuggested: Boolean = false,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = if (selected) Color(0xFFE8F5F3) else White),
        shape = RoundedCornerShape(12.dp),
        border = if (selected) BorderStroke(1.dp, Primary) else BorderStroke(1.dp, OutlineVariant),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = selected,
                    onClick = onClick,
                    colors = RadioButtonDefaults.colors(selectedColor = Primary, unselectedColor = OutlineVariant)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column {
                    Text(title, style = AppTypography.bodyMedium, color = NeutralAction, fontWeight = FontWeight.Bold)
                    Text(subtitle, style = AppTypography.bodySmall, color = Secondary)
                }
            }
            if (isSuggested) {
                Surface(
                    color = White,
                    border = BorderStroke(1.dp, Primary),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Text(
                        "Sugerido",
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        color = Primary,
                        style = AppTypography.labelLarge.copy(fontSize = 10.sp)
                    )
                }
            }
        }
    }
}
