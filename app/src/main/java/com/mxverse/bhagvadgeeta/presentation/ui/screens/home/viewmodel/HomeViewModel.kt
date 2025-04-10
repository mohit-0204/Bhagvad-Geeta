package com.mxverse.bhagvadgeeta.presentation.ui.screens.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mxverse.bhagvadgeeta.domain.repository.ApiRepository
import com.mxverse.bhagvadgeeta.data.remote.dtos.ChapterDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: ApiRepository
) : ViewModel() {

    var uiState by mutableStateOf(HomeUiState())
        private set

    init {
        getChapters()
    }

    private fun getChapters() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)
            try {
                val result = repository.getChapters()
                uiState = uiState.copy(chapters = result, isLoading = false)
            } catch (e: Exception) {
                val error = when (e) {
                    is HttpException -> "API Error ${e.code()}: ${e.localizedMessage}"
                    is IOException -> "Network Error: ${e.message}"
                    else -> "Unexpected Error: ${e.localizedMessage}"
                }
                uiState = uiState.copy(errorMessage = error, isLoading = false)            }
        }
    }
}
// UiState.kt
data class HomeUiState(
    val isLoading: Boolean = false,
    val chapters: List<ChapterDto> = emptyList(),
    val errorMessage: String? = null
)
