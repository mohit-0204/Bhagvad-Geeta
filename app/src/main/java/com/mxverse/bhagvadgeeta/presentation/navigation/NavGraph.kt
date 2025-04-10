package com.mxverse.bhagvadgeeta.presentation.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mxverse.bhagvadgeeta.presentation.ui.screens.home.HomeScreen
import com.mxverse.bhagvadgeeta.presentation.ui.screens.chapter_detail.ChapterDetailScreen
import com.mxverse.bhagvadgeeta.presentation.ui.screens.login.LoginScreen
import com.mxverse.bhagvadgeeta.presentation.ui.screens.signup.SignUpScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = Login) {
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
