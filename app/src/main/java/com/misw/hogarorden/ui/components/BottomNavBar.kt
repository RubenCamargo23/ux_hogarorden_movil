package com.misw.hogarorden.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.EventAvailable
import androidx.compose.material.icons.filled.ManageAccounts
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.misw.hogarorden.ui.theme.Primary
import com.misw.hogarorden.ui.theme.Secondary
import com.misw.hogarorden.ui.theme.White
import com.misw.hogarorden.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavBar(
    currentRoute: String,
    onNavigate: (String) -> Unit
) {
    NavigationBar(
        containerColor = White,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            selected = currentRoute == Screen.Home.route,
            onClick = { onNavigate(Screen.Home.route) },
            icon = { Icon(Icons.Default.EventAvailable, contentDescription = "Hoy") },
            label = { Text("Hoy", fontWeight = if (currentRoute == Screen.Home.route) FontWeight.Bold else FontWeight.Normal) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                indicatorColor = White,
                unselectedIconColor = Secondary,
                unselectedTextColor = Secondary
            )
        )
        NavigationBarItem(
            selected = currentRoute == Screen.Notices.route,
            onClick = { onNavigate(Screen.Notices.route) },
            icon = { 
                BadgedBox(badge = { Badge { Text("1") } }) {
                    Icon(Icons.Default.Notifications, contentDescription = "Avisos")
                }
            },
            label = { Text("Avisos", fontWeight = if (currentRoute == Screen.Notices.route) FontWeight.Bold else FontWeight.Normal) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                indicatorColor = White,
                unselectedIconColor = Secondary,
                unselectedTextColor = Secondary
            )
        )
        NavigationBarItem(
            selected = currentRoute == Screen.Leaderboard.route,
            onClick = { onNavigate(Screen.Leaderboard.route) },
            icon = { Icon(Icons.Default.EmojiEvents, contentDescription = "Puntos") },
            label = { Text("Puntos", fontWeight = if (currentRoute == Screen.Leaderboard.route) FontWeight.Bold else FontWeight.Normal) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                indicatorColor = White,
                unselectedIconColor = Secondary,
                unselectedTextColor = Secondary
            )
        )
        NavigationBarItem(
            selected = currentRoute == Screen.Profile.route,
            onClick = { onNavigate(Screen.Profile.route) },
            icon = { Icon(Icons.Default.ManageAccounts, contentDescription = "Perfil") },
            label = { Text("Perfil", fontWeight = if (currentRoute == Screen.Profile.route) FontWeight.Bold else FontWeight.Normal) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Primary,
                selectedTextColor = Primary,
                indicatorColor = White,
                unselectedIconColor = Secondary,
                unselectedTextColor = Secondary
            )
        )
    }
}
