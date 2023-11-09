package com.example.slave2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import androidx.activity.viewModels
import com.example.slave2.R
import com.example.slave2.databinding.ActivityEmailBinding
import com.example.slave2.viewModel.LoginViewModel

class EmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEmailBinding
    private val viewModel : LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_email)
        binding.lifecycleOwner = this
        setContentView(binding.root)


        binding.viewModel = viewModel
        binding.emailEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Nothing to do
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Nothing to do
            }

            override fun afterTextChanged(s: Editable?) {
                viewModel.onEmailChanged(s)
            }
        })
        viewModel.event.observe(this) { handleEvent(it) }


    }
    private fun handleEvent(event: LoginViewModel.Event) {
        when (event) {
            is LoginViewModel.Event.emailLogin -> {
                val intent = Intent(this, PasswordActivity::class.java)
                intent.putExtra("email",viewModel.email.value.toString())
                finish()
                startActivity(intent)
            }
            else ->{}
        }
    }
}