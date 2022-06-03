package com.magicapp.kotlincoroutinusuzmobilier.repository

import com.magicapp.kotlincoroutinusuzmobilier.network.ApiService

class UserRepository(val apiService: ApiService) {

    suspend fun getUsersFromPlaceHolder() = apiService.getUsersFromPlaceHolder()
    suspend fun getUsersFromGithub() = apiService.getUsersFromGithub()

}