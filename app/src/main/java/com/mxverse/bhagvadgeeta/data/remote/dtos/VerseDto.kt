package com.mxverse.bhagvadgeeta.data.remote.dtos

data class VerseDto(
    val id: Int,
    val verse_number: Int,
    val text: String,
    val transliteration: String,
    val word_meanings: String,
    val translation: String
)
