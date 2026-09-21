package com.misw.hogarorden.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.em
import com.misw.hogarorden.R

val AbhayaLibre = FontFamily(
    Font(R.font.abhaya_libre_regular, FontWeight.Normal),
    Font(R.font.abhaya_libre_bold, FontWeight.Bold),
    Font(R.font.abhaya_libre_bold, FontWeight.Medium), // mapped to bold
    Font(R.font.abhaya_libre_bold, FontWeight.SemiBold), // mapped to bold
    Font(R.font.abhaya_libre_bold, FontWeight.ExtraBold) // mapped to bold
)

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 64.sp,
        lineHeight = (64 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    displayMedium = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 46.sp,
        lineHeight = (46 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = (32 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = (32 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
        lineHeight = (26 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = (22 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
        lineHeight = (22 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = (18 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    titleSmall = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = (16 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = (18 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = (16 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    bodySmall = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = (14 * 1.4).sp,
        letterSpacing = 0.sp
    ),
    labelLarge = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = (14 * 1.4).sp,
        letterSpacing = 0.12.em
    ),
    labelMedium = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        lineHeight = (12 * 1.4).sp,
        letterSpacing = 0.12.em
    ),
    labelSmall = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = (11 * 1.4).sp,
        letterSpacing = 0.12.em
    )
)
