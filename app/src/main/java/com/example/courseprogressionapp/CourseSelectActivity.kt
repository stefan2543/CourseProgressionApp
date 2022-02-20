package com.example.courseprogressionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.courseprogressionapp.adapter.CourseCardAdapter
import com.example.courseprogressionapp.Layout.Layout
import com.example.courseprogressionapp.databinding.CourseSelectBinding
import com.example.courseprogressionapp.support.onItemClick

class CourseSelectActivity : AppCompatActivity () {

    private lateinit var binding: CourseSelectBinding
    private lateinit var listIntent: Intent
    private val semesters: MutableList<String> = mutableListOf("1st Year Fall", "1st Year Spring", "2nd Year Fall", "2nd Year Spring", "3rd Year Fall", "3rd Year Spring", "4th Year Fall", "4th Year Spring")
    private var currentSemester = 0
    private var requirementOne = true
    private var requirementTwo = true
    private var requirementThree = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CourseSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.verticalRecyclerView.adapter = CourseCardAdapter(
            applicationContext,
            Layout.VERTICAL,
            requirementOne,
            requirementTwo,
            requirementThree
        )



        binding.verticalRecyclerView.onItemClick { recyclerView, position, v -> launchCourseInfo() }
        // Specify fixed size to improve performance
        binding.verticalRecyclerView.setHasFixedSize(true)

        // Enable up button for backward navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.currentSemester.text = semesters[currentSemester]
    }

    private fun launchCourseInfo() {
        listIntent = Intent(this, CourseInfoActivity::class.java)
        startActivity(listIntent)
    }

}
