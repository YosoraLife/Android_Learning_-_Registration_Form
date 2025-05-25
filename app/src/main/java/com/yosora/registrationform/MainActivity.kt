package com.yosora.registrationform

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yosora.loginform.Registration
import com.yosora.registrationform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Initialize variable for binding the id's from the layout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup the binding of the id's to the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        setupSpinner()
        setupButton()
    }

    private fun setupSpinner() {
        // SETUP SPINNER
        val titles = arrayOf("Mr", "Ms")  // Set spinner values in an array
        val titleAdapter = ArrayAdapter(this, R.layout.simple_spinner_dropdown_item, titles)  // Set adaptor with the template and the values
        binding.spinnerTitle.adapter = titleAdapter  // Bind the adaptor to the spinner in the layout
    }

    private fun setupButton() {
        // Setup the button click action
        binding.buttonRegister.setOnClickListener {
            createAccount()
        }
    }

    private fun createAccount() {
        // Create an instance of data class Registration with all the input data
        val registration = Registration(
            binding.spinnerTitle.selectedItem as String,
            binding.editTextFirstName.text.toString(),
            binding.editTextLastName.text.toString(),
            binding.editTextEmailAddress.text.toString(),
            binding.editTextPhoneNumber.text.toString(),
            binding.editTextPassword.text.toString()
        )

        // Create an new intent
        val previewSummaryIntent = Intent(this, SummaryActivity::class.java)
        previewSummaryIntent.putExtra("Registration", registration)  // Add the instance of the data class to the intent
        startActivity(previewSummaryIntent)  // Start the activity

    }

}