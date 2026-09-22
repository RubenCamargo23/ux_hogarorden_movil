package com.misw.hogarorden

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.misw.hogarorden.ui.screens.ConfirmTaskScreen
import com.misw.hogarorden.ui.screens.HomeScreen
import com.misw.hogarorden.ui.screens.LoginScreen
import com.misw.hogarorden.ui.screens.PostponeScreen
import com.misw.hogarorden.ui.screens.RegisterScreen
import com.misw.hogarorden.ui.screens.TaskDetailScreen
import com.misw.hogarorden.ui.screens.NoticesScreen
import com.misw.hogarorden.ui.screens.CreateNoticeScreen
import com.misw.hogarorden.ui.screens.LeaderboardScreen
import com.misw.hogarorden.ui.screens.ProfileScreen

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object TaskDetail : Screen("task_detail")
    object Postpone : Screen("postpone")
    object ConfirmTask : Screen("confirm_task")
    object Notices : Screen("notices")
    object CreateNotice : Screen("create_notice")
    object Leaderboard : Screen("leaderboard")
    object Profile : Screen("profile")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginScreen(
                onNavigateToRegister = { navController.navigate(Screen.Register.route) },
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Register.route) {
            RegisterScreen(
                onNavigateToLogin = { navController.popBackStack() },
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }
        composable(Screen.Home.route) {
            HomeScreen(
                onNavigateToTaskDetail = { navController.navigate(Screen.TaskDetail.route) },
                onNavigateBottomNav = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
        composable(Screen.TaskDetail.route) {
            TaskDetailScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateToPostpone = { navController.navigate(Screen.Postpone.route) },
                onNavigateToConfirm = { navController.navigate(Screen.ConfirmTask.route) }
            )
        }
        composable(Screen.Postpone.route) {
            PostponeScreen(
                onNavigateBack = { navController.popBackStack() },
                onConfirmPostpone = { navController.popBackStack() }
            )
        }
        composable(Screen.ConfirmTask.route) {
            ConfirmTaskScreen(
                onNavigateBack = { navController.popBackStack() },
                onConfirmTask = { 
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                },
                onNavigateToNotices = {
                    navController.navigate(Screen.Notices.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
        composable(Screen.Notices.route) {
            NoticesScreen(
                onNavigateBottomNav = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onNavigateToCreateNotice = { navController.navigate(Screen.CreateNotice.route) }
            )
        }
        composable(Screen.CreateNotice.route) {
            CreateNoticeScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateBottomNav = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onPublish = { navController.popBackStack() }
            )
        }
        composable(Screen.Leaderboard.route) {
            LeaderboardScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateBottomNav = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
        composable(Screen.Profile.route) {
            ProfileScreen(
                onNavigateBack = { navController.popBackStack() },
                onNavigateBottomNav = { route ->
                    navController.navigate(route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onLogout = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                    }
                }
            )
        }
    }
}
