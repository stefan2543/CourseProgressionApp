package com.example.courseprogressionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.courseprogressionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var listIntent: Intent
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startBtn.setOnClickListener { launchSemester () }
    }

    private fun launchSemester() {
        listIntent = Intent(this, CourseSelectActivity::class.java)
        startActivity(listIntent)
    }
}