package com.mxverse.bhagvadgeeta.presentation.ui.home

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mxverse.bhagvadgeeta.data.remote.dtos.ChapterDto
import com.mxverse.bhagvadgeeta.presentation.viewmodel.HomeViewModel
import okhttp3.OkHttpClient
import okhttp3.Request

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), modifier: Modifier) {
    val state = viewModel.uiState

    when {
        state.isLoading -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        state.errorMessage != null -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = state.errorMessage)

                Thread{
                    val client = OkHttpClient()

                    val request = Request.Builder()
                        .url("https://bhagavad-gita3.p.rapidapi.com/v2/chapters/")
                        .get()
                        .addHeader(
                            "x-rapidapi-key",
                            "f8c6f1af6fmsh2cc70538ee20e29p1ddb70jsncb7e6fceb4de"
                        )
                        .addHeader("x-rapidapi-host", "bhagavad-gita3.p.rapidapi.com")
                        .build()

                    val response = client.newCall(request).execute()

                    Log.d("HomeScreen", "Resp: \n${response.body?.string()}")
                }.start()


                Log.d(
                    "HomeScreen", "Error: \n" + state.errorMessage)
            }
        }

        else -> {
            LazyColumn(modifier.fillMaxSize()) {
                items(state.chapters) { chapter ->
                    ChapterItem(chapter)
                }
            }
        }
    }
}

@Composable
fun ChapterItem(chapter: ChapterDto) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Chapter ${chapter.name}", style = MaterialTheme.typography.titleMedium)
        Text(text = chapter.name, style = MaterialTheme.typography.bodyLarge)
        Text(text = chapter.name_translated, style = MaterialTheme.typography.bodyMedium)
    }
}
