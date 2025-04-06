package com.mxverse.bhagvadgeeta.data.repository

import com.mxverse.bhagvadgeeta.data.remote.ApiService
import com.mxverse.bhagvadgeeta.data.remote.dtos.ChapterDto
import com.mxverse.bhagvadgeeta.data.remote.dtos.VerseDto
import com.mxverse.bhagvadgeeta.domain.repository.ApiRepository
import retrofit2.HttpException
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ApiRepository {

    override suspend fun getChapters(): List<ChapterDto> {
        val response = apiService.getChapters()
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            throw HttpException(response)
        }
    }

    override suspend fun getVerses(chapterNumber: Int): List<VerseDto> {
        val response = apiService.getVerses(chapterNumber)
        if (response.isSuccessful) {
            return response.body() ?: emptyList()
        } else {
            throw HttpException(response)
        }
    }
}
