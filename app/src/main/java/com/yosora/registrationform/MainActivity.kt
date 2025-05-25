package com.yosora.registrationform

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yosora.registrationform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Initialize variable for binding the id's from the layout
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Setup the binding of the id's to the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
    }
}