package com.learning.hwork6_1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.learning.hwork6_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("User Information", Context.MODE_PRIVATE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegister.setOnClickListener(::registerUserInformation)
        binding.buttonShowInfo.setOnClickListener(::makeFieldsVisible)
        binding.buttonHideInfo.setOnClickListener(::makeFieldsInvisible)
    }

    private fun registerUserInformation(view: View) {
        lateinit var userFullName: String
        lateinit var userUserName: String
        lateinit var userEmail: String
        lateinit var userPassword: String
        lateinit var userGender: String
        if (binding.editTextFullName.text.isNotBlank()) {
            userFullName = binding.editTextFullName.text.toString()
        }
        if (binding.editTextUserName.text.isNotBlank()) {
            userUserName = binding.editTextUserName.text.toString()
        }
        if (binding.editTextEmail.text.isNotBlank()) {
            userEmail = binding.editTextEmail.text.toString()
        }
        if (binding.editTextPassword.text.isNotBlank()) {
            userPassword = binding.editTextPassword.text.toString()
        }
        if (binding.radioButtonFemale.isChecked) {
            userGender = binding.radioButtonFemale.text.toString()
        } else if (binding.radioButtonMale.isChecked) {
            userGender = binding.radioButtonMale.text.toString()
        }

        sharedPreferences.edit().putString("userFullName", userFullName).apply()
        sharedPreferences.edit().putString("userUserName", userUserName).apply()
        sharedPreferences.edit().putString("userEmail", userEmail).apply()
        sharedPreferences.edit().putString("userPassword", userPassword).apply()
        sharedPreferences.edit().putString("userGender", userGender).apply()


        Toast.makeText(this, "Registered", Toast.LENGTH_SHORT).show()

        binding.textViewFullName.text = sharedPreferences.getString(userFullName, userFullName)
        binding.textViewUserName.text = sharedPreferences.getString(userUserName, userUserName)
        binding.textViewEmail.text = sharedPreferences.getString(userEmail, userEmail)
        binding.textViewPassword.text = sharedPreferences.getString(userPassword, userPassword)
        binding.textViewGender2.text = sharedPreferences.getString(userGender, userGender)

    }

    private fun makeFieldsInvisible(view: View) {
        if (binding.textViewFullName.visibility == 0) {
            binding.textViewFullName.visibility = View.INVISIBLE
        }
        if (binding.textViewUserName.visibility == 0) {
            binding.textViewUserName.visibility = View.INVISIBLE
        }
        if (binding.textViewEmail.visibility == 0) {
            binding.textViewEmail.visibility = View.INVISIBLE
        }
        if (binding.textViewPassword.visibility == 0) {
            binding.textViewPassword.visibility = View.INVISIBLE
        }
        if (binding.textViewGender2.visibility == 0) {
            binding.textViewGender2.visibility = View.INVISIBLE
        }
        if (binding.buttonHideInfo.visibility == 0) {
            binding.buttonHideInfo.visibility = View.INVISIBLE
        }
    }

    private fun makeFieldsVisible(view: View) {
        if (binding.textViewFullName.visibility == 4) {
            binding.textViewFullName.visibility = View.VISIBLE
        }
        if (binding.textViewUserName.visibility == 4) {
            binding.textViewUserName.visibility = View.VISIBLE
        }
        if (binding.textViewEmail.visibility == 4) {
            binding.textViewEmail.visibility = View.VISIBLE
        }
        if (binding.textViewPassword.visibility == 4) {
            binding.textViewPassword.visibility = View.VISIBLE
        }
        if (binding.textViewGender2.visibility == 4) {
            binding.textViewGender2.visibility = View.VISIBLE
        }
        if (binding.buttonHideInfo.visibility == 4) {
            binding.buttonHideInfo.visibility = View.VISIBLE
        }
    }
}

