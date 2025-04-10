package com.mxverse.bhagvadgeeta.presentation.ui.screens.chapter_detail
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterDetailScreen(chapterNumber: Int) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Chapter $chapterNumber") }) }
    ) { innerPadding ->
        Box(Modifier
            .fillMaxSize()
            .padding(innerPadding), contentAlignment = Alignment.Center) {
            Text("Details for Chapter $chapterNumber")
        }
    }
}
