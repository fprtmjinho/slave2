package com.example.slave2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.slave2.R
import com.example.slave2.databinding.ActivityFinishBinding
import com.example.slave2.viewModel.LoginViewModel

class FinishActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFinishBinding
    private val viewModel : LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_finish)
        binding.lifecycleOwner = this
        setContentView(binding.root)
        binding.viewModel = viewModel
        binding.emailText.text = intent.getStringExtra("email")
        binding.passwordText.text = intent.getStringExtra("password")
        viewModel.event.observe(this) { handleEvent(it) }
    }
    private fun handleEvent(event: LoginViewModel.Event) {
        when (event) {
            is LoginViewModel.Event.back -> {
                val intent = Intent(this, EmailActivity::class.java)
                finish()
                startActivity(intent)
            }
            else ->{}
        }
    }

}