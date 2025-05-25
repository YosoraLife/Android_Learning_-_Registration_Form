package com.yosora.registrationform

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yosora.loginform.Registration
import com.yosora.registrationform.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    private lateinit var registration: Registration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        displaySummary()
        setupIntents()
    }

    @SuppressLint("SetTextI18n")
    private fun displaySummary() {
        // Get the data as a instance of data class Registration
        registration = intent.getSerializableExtra("Registration") as Registration
        binding.textViewAccountName.text = registration.getFullName()
        binding.textViewEmailAddress.text = registration.emailAddress
        binding.textViewPhoneNumber.text = registration.phoneNumber
        binding.textViewPassword.text = registration.password
    }

    private fun setupIntents() {

        binding.textViewEmailAddress.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${registration.emailAddress}")
            startActivity(intent)
        }

        binding.textViewPhoneNumber.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${registration.phoneNumber}")
            startActivity(intent)
        }
    }
}