package com.mxverse.bhagvadgeeta.data.remote

import com.mxverse.bhagvadgeeta.data.remote.dtos.ChapterDto
import com.mxverse.bhagvadgeeta.data.remote.dtos.VerseDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v2/chapters/")
    suspend fun getChapters(): Response<List<ChapterDto>>

    @GET("v2/chapters/{chapterNumber}/verses")
    suspend fun getVerses(@Path("chapterNumber") chapter: Int): Response<List<VerseDto>>
}
