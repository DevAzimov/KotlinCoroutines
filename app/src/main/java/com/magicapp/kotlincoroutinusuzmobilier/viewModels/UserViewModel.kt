package com.magicapp.kotlincoroutinusuzmobilier.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magicapp.kotlincoroutinusuzmobilier.network.ApiClient
import com.magicapp.kotlincoroutinusuzmobilier.utils.Resource
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class UserViewModel: ViewModel() {

    private val liveData = MutableLiveData<Resource<String>>()

    fun getUser() : LiveData<Resource<String>> {
        val apiService1 = ApiClient.apiService(ApiClient.BASE_URL1)
        val apiService2 = ApiClient.apiService(ApiClient.BASE_URL2)

        viewModelScope.launch {

            liveData.postValue(Resource.loading(null))

            try {
                val async1 = async { apiService1.getUsersFromPlaceHolder() }
                val async2 = async { apiService2.getUsersFromGithub() }

                val await1 = async1.await()
                val await2 = async2.await()
                val stringBuilder = StringBuilder()

                for (user in await1) {
                    stringBuilder.append(user.username).append("\n")
                }
                for (user in await2) {
                    stringBuilder.append(user.login).append("\n")
                }
                liveData.postValue(Resource.success(stringBuilder.toString()))

            }catch (e: Exception){
                liveData.postValue(Resource.error(e.message ?: "Error", null))
            }
        }
        return liveData
    }

}