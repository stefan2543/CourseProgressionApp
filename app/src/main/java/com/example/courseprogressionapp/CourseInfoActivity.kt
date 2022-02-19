package com.example.courseprogressionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.courseprogressionapp.databinding.ActivityMainBinding

class CourseInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.addBtn.setOnClickListener { launchSemester () }

    }

    private fun launchSemester() {
        listIntent = Intent(this, CourseSelectActivity::class.java)
        startActivity(listIntent)
    }

}
