package com.mxverse.bhagvadgeeta.data.remote.dtos

data class ChapterDto(
    val id: Int,
    val name: String,
    val name_translated: String,
    val verses_count: Int,
    val chapter_summary: String
)
