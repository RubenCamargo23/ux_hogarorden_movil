package com.misw.hogarorden.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import com.misw.hogarorden.R
import com.misw.hogarorden.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onNavigateToLogin: () -> Unit, // Assuming we should be able to navigate back
    onNavigateToHome: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var inviteCode by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            
            // Logo placeholder
            Box(
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.White, RoundedCornerShape(20.dp))
                    .border(1.dp, OutlineVariant, RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Home, // Replace with custom icon when available
                    contentDescription = "Logo",
                    tint = Primary,
                    modifier = Modifier.size(32.dp)
                )
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = "Hogar en Orden",
                style = AppTypography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = NeutralAction
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Coordinación sencilla del hogar",
                style = AppTypography.bodyMedium,
                color = Secondary
            )
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                border = BorderStroke(1.dp, OutlineVariant),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    // Segmented control simulation
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(BackgroundColor, RoundedCornerShape(12.dp))
                            .border(1.dp, OutlineVariant, RoundedCornerShape(12.dp))
                            .padding(4.dp)
                    ) {
                        TextButton(
                            onClick = onNavigateToLogin,
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.textButtonColors(contentColor = Secondary),
                            contentPadding = PaddingValues(12.dp)
                        ) {
                            Text("Iniciar sesión", style = AppTypography.titleSmall, fontWeight = FontWeight.Medium)
                        }
                        Button(
                            onClick = { /* Already here */ },
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.White,
                                contentColor = NeutralAction
                            ),
                            shape = RoundedCornerShape(8.dp),
                            elevation = ButtonDefaults.buttonElevation(
                                defaultElevation = 1.dp,
                                pressedElevation = 0.dp
                            ),
                            contentPadding = PaddingValues(12.dp)
                        ) {
                            Text("Crear cuenta", fontWeight = FontWeight.Bold, style = AppTypography.titleSmall)
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    // Name Field
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text("Nombre completo", style = AppTypography.labelLarge, color = NeutralAction)
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            value = name,
                            onValueChange = { name = it },
                            placeholder = { Text("Ej. Rubén Darío", color = Secondary, style = AppTypography.bodyMedium) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = OutlineVariant,
                                focusedBorderColor = Primary
                            ),
                            singleLine = true,
                            textStyle = AppTypography.bodyMedium
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Email Field
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text("Correo electrónico", style = AppTypography.labelLarge, color = NeutralAction)
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            placeholder = { Text("correo@ejemplo.com", color = Secondary, style = AppTypography.bodyMedium) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = OutlineVariant,
                                focusedBorderColor = Primary
                            ),
                            singleLine = true,
                            textStyle = AppTypography.bodyMedium
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Password Field
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text("Contraseña", style = AppTypography.labelLarge, color = NeutralAction)
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            placeholder = { Text("Mínimo 8 caracteres", color = Secondary, style = AppTypography.bodyMedium) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = OutlineVariant,
                                focusedBorderColor = Primary
                            ),
                            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            trailingIcon = {
                                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                                    Icon(
                                        imageVector = if (passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                        contentDescription = "Toggle password visibility",
                                        tint = Secondary
                                    )
                                }
                            },
                            singleLine = true,
                            textStyle = AppTypography.bodyMedium
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    // Invite Code Field
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text("Código de invitación (opcional)", style = AppTypography.labelLarge, color = NeutralAction)
                        Spacer(modifier = Modifier.height(8.dp))
                        OutlinedTextField(
                            value = inviteCode,
                            onValueChange = { inviteCode = it },
                            placeholder = { Text("Ej. ROSALES-784 o déjalo vacío", color = Secondary, style = AppTypography.bodyMedium) },
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(12.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                unfocusedBorderColor = OutlineVariant,
                                focusedBorderColor = Primary
                            ),
                            singleLine = true,
                            textStyle = AppTypography.bodyMedium
                        )
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    // Register Button
                    Button(
                        onClick = onNavigateToHome,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Primary),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Crear cuenta", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        HorizontalDivider(modifier = Modifier.weight(1f), color = OutlineVariant)
                        Text(
                            text = "O CONTINUAR CON",
                            style = AppTypography.labelLarge.copy(fontSize = 10.sp),
                            color = Secondary,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        HorizontalDivider(modifier = Modifier.weight(1f), color = OutlineVariant)
                    }
                    
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        OutlinedButton(
                            onClick = { /* TODO */ },
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, OutlineVariant)
                        ) {
                            Icon(painter = painterResource(id = R.drawable.google_icon), contentDescription = null, modifier = Modifier.size(20.dp), tint = Color.Unspecified)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Google", color = NeutralAction, style = AppTypography.titleSmall)
                        }
                        
                        OutlinedButton(
                            onClick = { /* TODO */ },
                            modifier = Modifier
                                .weight(1f)
                                .height(48.dp),
                            shape = RoundedCornerShape(12.dp),
                            border = BorderStroke(1.dp, OutlineVariant)
                        ) {
                            Icon(painter = painterResource(id = R.drawable.apple_icon), contentDescription = null, modifier = Modifier.size(20.dp), tint = Color.Unspecified)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Apple", color = NeutralAction, style = AppTypography.titleSmall)
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            val annotatedString = buildAnnotatedString {
                append("Al registrarte aceptas nuestros ")
                withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.Normal)) {
                    append("Términos")
                }
                append(" y la ")
                withStyle(style = SpanStyle(color = Primary, fontWeight = FontWeight.Normal)) {
                    append("Política de privacidad.")
                }
            }
            
            Text(
                text = annotatedString,
                style = AppTypography.bodySmall.copy(fontSize = 12.sp),
                color = Secondary,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
