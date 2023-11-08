package com.example.slave2.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import com.example.slave2.R
import com.example.slave2.databinding.ActivityMainBinding
import com.example.slave2.viewModel.LoginViewModel

class EmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = LoginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        setContentView(binding.root)

        binding.lifecycleOwner = this

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
        binding.mainBnv.setOnClickListener{
            val intent = Intent(this, PasswordActivity::class.java)
            intent.putExtra("sns", "NORMAL")
            intent.putExtra("snsId", "")
            startActivity(intent)
        }
    }
}