package com.mxverse.bhagvadgeeta.presentation.navigation

import kotlinx.serialization.Serializable

sealed interface Screen

@Serializable
data object Home : Screen

@Serializable
data class ChapterDetail(val chapterNumber: Int) : Screen
