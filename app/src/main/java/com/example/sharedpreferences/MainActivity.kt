package com.example.sharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val MY_SHARED_PREF_NAME = "my_shared_pref"
    private val NAME = "name"
    private val AGE = "age"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showSavedData()
        binding.btnSave.setOnClickListener {
            saveData()
        }
    }


    private fun saveData(){
        val insertName = binding.etName.text.toString()
        val insertAge = binding.etAge.text.toString()

        val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME,
        Context.MODE_PRIVATE)

        val editor = sharedPref.edit()
        editor.putString(NAME, insertName)
        editor.putString(AGE, insertAge)
        editor.apply()

        Toast.makeText(this, "Data saved",
        Toast.LENGTH_SHORT
        ).show()

        binding.tvResult.text = "Name: $insertName \nAge: $insertAge"
    }

    private fun showSavedData(){

        val sharedPref = getSharedPreferences(MY_SHARED_PREF_NAME, Context.MODE_PRIVATE)

        val name = sharedPref.getString(NAME, "")
        val age = sharedPref.getString(AGE, "")

        binding.tvResult.text = "Name: $name \nAge: $age"
    }
}