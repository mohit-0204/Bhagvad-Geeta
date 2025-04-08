package com.mxverse.bhagvadgeeta.presentation.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter

@Composable
fun VerseOfTheDayCard(
    shlok: String = "आत्मैव ह्यात्मनो बन्धुरात्मैव रिपुरात्मनः ।",
    meaning: String = "The self is the friend of the self, and the self is the enemy of the self..."
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .heightIn(min = 140.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFFF5EB) // light saffron background
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(
                    text = "Shlok of the Day",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = Color(0xFFDE7B29), // deeper saffron
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "\"$shlok\"",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = meaning,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
                    )
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Image(
                painter = rememberAsyncImagePainter("https://cdnb.artstation.com/p/assets/images/images/045/009/957/large/nikhil-mishra-shri-krishna-5-1a-wm.jpg?1641718204"), // change to any image
                contentDescription = "Shlok Image",
                modifier = Modifier
                    .size(64.dp)
                    .align(Alignment.Top),
                contentScale = ContentScale.Crop
            )
        }
    }
}
