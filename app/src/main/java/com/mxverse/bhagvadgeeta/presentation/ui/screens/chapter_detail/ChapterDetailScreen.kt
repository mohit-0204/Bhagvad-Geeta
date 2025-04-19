package com.mxverse.bhagvadgeeta.presentation.ui.screens.chapter_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterDetailScreen(chapterNumber: Int, onClickBack: () -> Unit) {
    var selectedTab by remember { mutableStateOf(0) }
    var fontSize by remember { mutableFloatStateOf(16f) }

    val tabTitles = listOf("Verses", "Summary", "Commentary")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Chapter Details") },
                navigationIcon = {
                    IconButton(onClick = {onClickBack}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = MaterialTheme.colorScheme.onSurface
                        )
                    }
                },
                windowInsets = WindowInsets(0) // Removes default top padding
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {

            // Chapter Title
            Text("Chapter $chapterNumber", style = MaterialTheme.typography.titleLarge)

            // Subtitle
            Text("Sankhya Yoga", style = MaterialTheme.typography.titleMedium)
            Text(
                "The Yoga of Knowledge and Self-Realization",
                style = MaterialTheme.typography.bodySmall
            )

            Spacer(Modifier.height(8.dp))

            // Description
            Text("In this chapter, Lord Krishna explains the nature of the soul, the difference between the body and the soul...")

            Spacer(Modifier.height(8.dp))

            // Progress bar
            Text("25 of 72 verses read", style = MaterialTheme.typography.bodySmall)
            LinearProgressIndicator(progress = 0.35f, modifier = Modifier.fillMaxWidth())
            Text(
                "35%",
                modifier = Modifier.align(Alignment.End),
                style = MaterialTheme.typography.labelSmall
            )

            Spacer(Modifier.height(16.dp))

            // Tabs
            TabRow(selectedTabIndex = selectedTab) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(selected = selectedTab == index, onClick = { selectedTab = index }) {
                        Text(title, modifier = Modifier.padding(16.dp))
                    }
                }
            }

            Spacer(Modifier.height(16.dp))

            // Font Size Control
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Font Size")
                Spacer(Modifier.width(16.dp))
                IconButton(onClick = { fontSize = (fontSize - 2).coerceAtLeast(12f) }) {
                    Icon(Icons.Outlined.Close, contentDescription = "Decrease")
                }
                Text(fontSize.toInt().toString())
                IconButton(onClick = { fontSize = (fontSize + 2).coerceAtMost(30f) }) {
                    Icon(Icons.Default.Add, contentDescription = "Increase")
                }
            }

            Spacer(Modifier.height(16.dp))

            // Verse Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Verse 1", style = MaterialTheme.typography.labelMedium)
                    Spacer(Modifier.height(8.dp))
                    Text("सञ्जय उवाच ।", fontSize = fontSize.sp)
                    Text("तं तथा कृपयाविष्टमश्रुपूर्णाकुलेक्षणम् ।", fontSize = fontSize.sp)
                    Text("विषीदन्तमिदं वाक्यमुवाच मधुसूदनः ॥1॥", fontSize = fontSize.sp)
                    Spacer(Modifier.height(8.dp))
                    Text("Sanjaya said: Seeing Arjuna full of compassion, his mind depressed, with eyes full of tears, Madhusudana (Krishna) spoke these words.")
                    Spacer(Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Icon(Icons.Default.PlayArrow, contentDescription = "Play Audio")
                        Icon(Icons.Default.Add, contentDescription = "Bookmark")
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                }
            }
        }
    }
}

