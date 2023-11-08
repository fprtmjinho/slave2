package com.example.slave2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.slave2.R
import com.example.slave2.databinding.ActivityPasswordBinding
import com.example.slave2.viewModel.LoginViewModel

class PasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPasswordBinding
    private val viewModel : LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_password)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.passwordEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Nothing to do
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Nothing to do
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.onPasswordChanged(s)
                viewModel.visibility()
            }
        })
        viewModel.event.observe(this) { handleEvent(it) }
    }
    private fun handleEvent(event: LoginViewModel.Event) {
        when (event) {
            is LoginViewModel.Event.passwordLogin -> {
                val intent = Intent(this, FinishActivity::class.java)
                startActivity(intent)
            }
            is LoginViewModel.Event.back -> {
                val intent = Intent(this, EmailActivity::class.java)
                startActivity(intent)
            }
            is LoginViewModel.Event.cencel -> {
                viewModel.onPasswordChanged("")
            }
            is LoginViewModel.Event.visibility -> {
                binding.cencelBtn.visibility = View.VISIBLE
            }
            is LoginViewModel.Event.invisibility -> {
                binding.cencelBtn.visibility = View.INVISIBLE
            }
            else ->{}
        }
    }
}