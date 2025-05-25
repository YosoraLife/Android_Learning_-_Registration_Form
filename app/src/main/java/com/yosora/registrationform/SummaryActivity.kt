package com.yosora.registrationform

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yosora.loginform.Registration
import com.yosora.registrationform.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    private lateinit var registration: Registration
    private lateinit var summaryText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        displaySummary()
    }

    private fun displaySummary() {
        // Get the data as a instance of data class Registration
        registration = intent.getSerializableExtra("Registration") as Registration
        summaryText = """
            Registration summary
            
            ${registration.title} ${registration.firstName} ${registration.lastName}
            Email: ${registration.emailAddress}
            Phone: ${registration.phoneNumber}
            Password: ${registration.password}
        """.trimIndent()
        binding.textViewSummary.text = summaryText
    }
}