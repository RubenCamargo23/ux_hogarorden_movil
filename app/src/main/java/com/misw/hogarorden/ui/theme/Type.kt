package com.misw.hogarorden.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.misw.hogarorden.R

val AbhayaLibre = FontFamily(
    Font(R.font.abhaya_libre_regular, FontWeight.Normal),
    Font(R.font.abhaya_libre_bold, FontWeight.Bold),
    Font(R.font.abhaya_libre_bold, FontWeight.ExtraBold),
    Font(R.font.abhaya_libre_regular, FontWeight.Medium),
    Font(R.font.abhaya_libre_bold, FontWeight.SemiBold)
)

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Bold,
        fontSize = 64.sp,
        lineHeight = (64 * 1.4).sp
    ),
    displayMedium = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Bold,
        fontSize = 46.sp,
        lineHeight = (46 * 1.4).sp
    ),
    titleLarge = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = (32 * 1.4).sp
    ),
    bodyLarge = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
        lineHeight = (26 * 1.4).sp
    ),
    bodyMedium = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = (22 * 1.4).sp
    ),
    bodySmall = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = (18 * 1.4).sp
    ),
    labelLarge = TextStyle(
        fontFamily = AbhayaLibre,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = (16 * 1.4).sp,
        letterSpacing = 0.12.sp
    )
)
