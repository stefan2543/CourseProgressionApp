package com.example.courseprogressionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.courseprogressionapp.adapter.CourseCardAdapter
import com.example.courseprogressionapp.Layout.Layout

class FinalProgressionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGridListBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gridRecyclerView.adapter = CourseCardAdapter(
            applicationContext,
            Layout.GRID
        )

        binding.editBtn.setOnClickListener { launchSemester () }

        // Specify fixed size to improve performance
        binding.gridRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun launchSemester() {
        listIntent = Intent(this, CourseSelectActivity::class.java)
        startActivity(listIntent)
    }
}