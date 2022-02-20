package com.example.courseprogressionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.courseprogressionapp.adapter.CourseCardAdapter
import com.example.courseprogressionapp.Layout.Layout
import com.example.courseprogressionapp.databinding.ActivityVerticalListBinding

class CourseSelectActivity : AppCompatActivity () {

    private lateinit var binding: ActivityVerticalListBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerticalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verticalRecyclerView.adapter = CourseCardAdapter(
            applicationContext,
            Layout.VERTICAL
        )

        binding.courseBtn.setOnClickListener { launchCourseInfo() }

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
