package com.mxverse.bhagvadgeeta.presentation.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
@Composable
fun ProgressCard(
    progressPercent: Float = 0.44f,
    chaptersRead: Int = 8,
    totalChapters: Int = 18,
    dayStreak: Int = 13
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFFBF9) // Very light cream
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Text(
                text = "Your Progress",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Circular Progress with Background Track
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(72.dp)
                ) {
                    CircularProgressIndicator(
                        progress = 1f,
                        color = Color(0xFFE0E0E0), // Gray background track
                        strokeWidth = 8.dp,
                        modifier = Modifier.fillMaxSize()
                    )
                    CircularProgressIndicator(
                        progress = progressPercent,
                        color = Color(0xFFF55C2A),
                        strokeWidth = 8.dp,
                        modifier = Modifier.fillMaxSize()
                    )
                    Text(
                        text = "${(progressPercent * 100).toInt()}%",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Stat Boxes
                StatBox(
                    title = "Chapters Read",
                    value = "$chaptersRead/$totalChapters"
                )

                Spacer(modifier = Modifier.width(8.dp))

                StatBox(
                    title = "Day Streak",
                    value = "\uD83D\uDD25$dayStreak"
                )
            }
        }
    }
}

@Composable
fun StatBox(
    title: String,
    value: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFFFFF2E6), RoundedCornerShape(12.dp))
            .padding(vertical = 12.dp, horizontal = 16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = FontWeight.Medium,
                color = Color(0xFF666666)
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
        )
    }
}
