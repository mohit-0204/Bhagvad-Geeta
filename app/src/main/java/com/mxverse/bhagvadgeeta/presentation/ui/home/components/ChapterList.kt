package com.mxverse.bhagvadgeeta.presentation.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mxverse.bhagvadgeeta.data.remote.dtos.ChapterDto

@Composable
fun ChapterList(
    chapters: List<ChapterDto>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = "Chapters",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = androidx.compose.ui.text.font.FontWeight.Bold),
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(chapters) { chapter ->
                ChapterItem(chapter)
            }
        }
    }
}

@Composable
fun ChapterItem(
    chapter: ChapterDto,
    modifier: Modifier = Modifier,
    status: String = "Completed" // or "In Progress", "Not Started"
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5)
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                // Title + Chip
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Chapter ${chapter.chapter_number}: ${chapter.name}",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.SemiBold),
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    ChapterStatusChip(status = status)
                }

                Spacer(modifier = Modifier.height(6.dp))

                // Translated Name
                Text(
                    text = chapter.name_translated,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(2.dp))

                // Total Verses
                Text(
                    text = "Verses: ${chapter.verses_count}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                )
            }

            // Right Arrow Icon
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Go to Chapter",
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier
                    .padding(start = 12.dp)
                    .size(24.dp)
            )
        }
    }
}






@Composable
fun ChapterStatusChip(status: String) {
    val (bgColor, textColor) = when (status) {
        "Completed" -> Color(0xFFD1E7DD) to Color(0xFF0F5132) // Green background and text
        "In Progress" -> Color(0xFFFFF3CD) to Color(0xFF664D03) // Yellowish
        else -> Color(0xFFF8D7DA) to Color(0xFF842029) // Red-ish (Not Started)
    }

    Surface(
        color = bgColor,
        shape = RoundedCornerShape(50),
        shadowElevation = 0.dp
    ) {
        Text(
            text = status,
            color = textColor,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp)
        )
    }
}



