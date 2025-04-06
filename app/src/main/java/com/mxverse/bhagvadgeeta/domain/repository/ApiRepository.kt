package com.mxverse.bhagvadgeeta.domain.repository

import com.mxverse.bhagvadgeeta.data.remote.dtos.ChapterDto
import com.mxverse.bhagvadgeeta.data.remote.dtos.VerseDto

interface ApiRepository {
    suspend fun getChapters(): List<ChapterDto>
    suspend fun getVerses(chapterNumber: Int): List<VerseDto>
}