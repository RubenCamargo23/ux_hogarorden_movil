package com.misw.hogarorden.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
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
import com.misw.hogarorden.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onNavigateToRegister: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            
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
                            Text("Iniciar sesión", fontWeight = FontWeight.Bold, style = AppTypography.titleSmall)
                        }
                        TextButton(
                            onClick = onNavigateToRegister,
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.textButtonColors(contentColor = Secondary),
                            contentPadding = PaddingValues(12.dp)
                        ) {
                            Text("Crear cuenta", style = AppTypography.titleSmall, fontWeight = FontWeight.Medium)
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
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
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("Contraseña", style = AppTypography.labelLarge, color = NeutralAction)
                            TextButton(
                                onClick = { /* TODO */ },
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Text("¿Olvidaste tu contraseña?", color = Primary, fontSize = 12.sp)
                            }
                        }
                        OutlinedTextField(
                            value = password,
                            onValueChange = { password = it },
                            placeholder = { Text("••••••••", color = Secondary, style = AppTypography.bodyMedium) },
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
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    // Login Button
                    Button(
                        onClick = onNavigateToHome,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Primary),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Iniciar sesión", fontSize = 16.sp, fontWeight = FontWeight.Medium)
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
                            Text("Apple", color = NeutralAction, style = AppTypography.titleSmall)
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            val annotatedString = buildAnnotatedString {
                append("Al continuar aceptas nuestros ")
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
