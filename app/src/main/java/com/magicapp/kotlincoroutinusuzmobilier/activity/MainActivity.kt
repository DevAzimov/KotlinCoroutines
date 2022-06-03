package com.magicapp.kotlincoroutinusuzmobilier.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.magicapp.kotlincoroutinusuzmobilier.databinding.ActivityMainBinding
import com.magicapp.kotlincoroutinusuzmobilier.model.User
import com.magicapp.kotlincoroutinusuzmobilier.network.ApiClient
import com.magicapp.kotlincoroutinusuzmobilier.utils.Status
import com.magicapp.kotlincoroutinusuzmobilier.viewModels.UserViewModel
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.math.log

class MainActivity : AppCompatActivity(){
    private  val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userViewModel.getUser().observe(this, Observer {
            when (it.status) {
                Status.LOADING -> {

                }
                Status.ERROR -> {

                }
                Status.SUCCESS -> {
                    binding.tv.text = it.data
                }
            }
        })

    }
}