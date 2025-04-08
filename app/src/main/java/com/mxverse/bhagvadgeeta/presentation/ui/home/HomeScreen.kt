package com.mxverse.bhagvadgeeta.presentation.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mxverse.bhagvadgeeta.presentation.ui.home.components.BottomNavBar
import com.mxverse.bhagvadgeeta.presentation.ui.home.components.ChapterList
import com.mxverse.bhagvadgeeta.presentation.ui.home.components.HomeTopBar
import com.mxverse.bhagvadgeeta.presentation.ui.home.components.ProgressCard
import com.mxverse.bhagvadgeeta.presentation.ui.home.components.VerseOfTheDayCard
import com.mxverse.bhagvadgeeta.presentation.ui.home.components.WelcomeSection
import com.mxverse.bhagvadgeeta.presentation.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.uiState
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                selectedIndex = selectedIndex,
                onItemSelected = { selectedIndex = it }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            HomeTopBar()
            WelcomeSection("Mohit")
            VerseOfTheDayCard()
            ProgressCard()

            when {
                state.isLoading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                state.errorMessage != null -> {
                    Box(
                        modifier = Modifier.fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = state.errorMessage,
                            color = MaterialTheme.colorScheme.error,
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                else -> {
                    ChapterList(chapters = state.chapters)
                }
            }
        }
    }
}




