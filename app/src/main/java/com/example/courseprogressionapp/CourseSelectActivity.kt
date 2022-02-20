package com.example.courseprogressionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.courseprogressionapp.adapter.CourseCardAdapter
import com.example.courseprogressionapp.Layout.Layout
import com.example.courseprogressionapp.databinding.CourseSelectBinding

class CourseSelectActivity : AppCompatActivity () {

    private lateinit var binding: CourseSelectBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CourseSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verticalRecyclerView.adapter = CourseCardAdapter(
            applicationContext,
            Layout.VERTICAL
        )

        binding.verticalRecyclerView.setOnClickListener { launchCourseInfo() }

        // Specify fixed size to improve performance
        binding.verticalRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    private fun launchCourseInfo() {
        listIntent = Intent(this, CourseInfoActivity::class.java)
        startActivity(listIntent)
    }

}
