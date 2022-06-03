package com.magicapp.kotlincoroutinusuzmobilier.network

import com.magicapp.kotlincoroutinusuzmobilier.model.GithubUser
import com.magicapp.kotlincoroutinusuzmobilier.model.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users")
    suspend fun getUsersFromPlaceHolder(): List<User>

    @GET("users")
    suspend fun getUsersFromGithub(): List<GithubUser>

}