package com.mxverse.bhagvadgeeta.domain.repository

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<Unit>
    suspend fun signUp(email: String, password: String): Result<Unit>
    fun logout()
    fun isUserLoggedIn(): Boolean
}
