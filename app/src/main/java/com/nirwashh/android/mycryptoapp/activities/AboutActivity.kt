package com.nirwashh.android.mycryptoapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nirwashh.android.mycryptoapp.R
import com.nirwashh.android.mycryptoapp.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}