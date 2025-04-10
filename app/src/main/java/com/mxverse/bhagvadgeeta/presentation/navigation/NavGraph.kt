package com.mxverse.bhagvadgeeta.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.mxverse.bhagvadgeeta.presentation.ui.screens.home.HomeScreen
import com.mxverse.bhagvadgeeta.presentation.ui.screens.chapter_detail.ChapterDetailScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home) {
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
    }
}
