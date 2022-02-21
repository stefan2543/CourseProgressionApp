package com.example.courseprogressionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.courseprogressionapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var listIntent: Intent
    private lateinit var binding: ActivityMainBinding
    private var semesterIndex = 0
    private var requirementOne = false
    private var requirementTwo = false
    private var requirementThree = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.startBtn.setOnClickListener { launchSemester () }
    }

    private fun launchSemester() {
        listIntent = Intent(this, CourseSelectActivity::class.java)
        listIntent.putExtra("semesterIndex", semesterIndex)
        listIntent.putExtra("requirementOne", requirementOne)
        listIntent.putExtra("requirementTwo", requirementTwo)
        listIntent.putExtra("requirementThree", requirementThree)
        startActivity(listIntent)
    }
}