package com.mxverse.bhagvadgeeta.presentation.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mxverse.bhagvadgeeta.presentation.ui.screens.home.HomeScreen
import com.mxverse.bhagvadgeeta.presentation.ui.screens.chapter_detail.ChapterDetailScreen
import com.mxverse.bhagvadgeeta.presentation.ui.screens.login.LoginScreen
import com.mxverse.bhagvadgeeta.presentation.ui.screens.signup.SignUpScreen
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mxverse.bhagvadgeeta.presentation.ui.screens.home.components.BottomNavBar
import com.mxverse.bhagvadgeeta.presentation.viewmodel.AuthViewModel

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val destination = currentBackStackEntry?.destination?.route

    val authViewModel: AuthViewModel = hiltViewModel()
    val isLoggedIn by authViewModel.isLoggedIn


    Scaffold(
        bottomBar = {
            BottomNavBar(
                selectedIndex = getBottomNavIndex(destination),
                onItemSelected = { index ->
                    when (index) {
                        0 -> navController.navigate(Home)
                        1 -> {
                            /* navController.navigate(Search) */
                        }

                        2 -> {
                            /* navController.navigate(Settings) */
                        }
                    }
                }
            )

        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = if (isLoggedIn) Home else Login,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Home> {
                HomeScreen(
                    onChapterClick = { chapterNumber ->
                        navController.navigate(ChapterDetail(chapterNumber))
                    }
                )
            }
            composable<ChapterDetail> {
                val args = it.toRoute<ChapterDetail>()
                ChapterDetailScreen(chapterNumber = args.chapterNumber)
            }

            composable<Login> {
                LoginScreen(
                    onSignInSuccess = {
                        authViewModel.onLoginSuccess()
                        navController.navigate(Home) {
                            popUpTo(Login) { inclusive = true }
                        }
                    }, onNavigateToSignUp = {
                        navController.navigate(SignUp)
                    }, onForgotPassword = {
                        Toast.makeText(context, "Not yet implemented", Toast.LENGTH_SHORT).show()
                    }, onGoogleSignIn = {
                        Toast.makeText(context, "Not yet implemented", Toast.LENGTH_SHORT).show()
                    }
                )
            }
            composable<SignUp> {
                SignUpScreen(
                    onSignUpSuccess = {
                        authViewModel.onLoginSuccess()
                        navController.navigate(Home) {
                            popUpTo(Login) { inclusive = true }
                        }
                    }, onNavigateToLogin = {
                        navController.navigate(Login)
                    }, onGoogleSignIn = {
                        Toast.makeText(context, "Not yet implemented", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }

    }


}

fun getBottomNavIndex(route: String?): Int {
    return when (route) {
        Home::class.simpleName -> 0
        // Search::class.simpleName -> 1
        // Settings::class.simpleName -> 2
        else -> 0
    }
}