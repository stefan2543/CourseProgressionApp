package com.example.courseprogressionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.courseprogressionapp.data.DataSource
import com.example.courseprogressionapp.databinding.CourseInfoBinding
import com.example.courseprogressionapp.data.ChosenCourses

/**
 * Group 7
 * File last updated: 2/21/22
 */

class CourseInfoActivity : AppCompatActivity() {

    private lateinit var binding: CourseInfoBinding
    private lateinit var listIntent: Intent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CourseInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Defines which course data will be displayed
        val courseData = DataSource.courses
        val course = courseData[intent.extras!!.getInt("courseIndex")]
        binding.imageViewZoom.setImageResource(course.imageResourceId)
        binding.courseNameZoom.text = course.name
        binding.courseDescriptionZoom.text =
            resources?.getString(R.string.course_description, course.description)
        // Click listeners for both add course buttons
        binding.button2.setOnClickListener { launchSemester(false) }
        binding.addBtn.setOnClickListener { launchSemester(true) }

    }

    // Tells app which activity to launch next based off number of courses chosen
    private fun launchSemester(nextSemester: Boolean) {
        var requirementThree = false
        // Adds the current course to chosen courses data and tagged with semester chosen
        val courseData = DataSource.courses
        val course = courseData[intent.extras!!.getInt("courseIndex")]
        course.chosenSemester = intent.extras!!.getInt("semesterIndex")
        val chosenCourseData = ChosenCourses.courses
        chosenCourseData.add(course)
        courseData.removeAt(intent.extras!!.getInt("courseIndex"))
        //  Checks how many courses have been chosen in current semester
        var index = 0
        val numChosenCoursesTotal = chosenCourseData.size
        var numChosenCourses = 0
        while (index < chosenCourseData.size) {
            if (chosenCourseData[index].chosenSemester == intent.extras!!.getInt("semesterIndex")) {
                numChosenCourses++
            }
            index++
        }
        if (numChosenCoursesTotal >= 6) {
            requirementThree = true
        }
        // Decides which activity to move to depending on number of courses chosen
        listIntent = if (intent.extras!!.getInt("semesterIndex") == 7) {
            Intent(this, FinalProgressionActivity::class.java)
        } else if (requirementThree) {
            Intent(this, FinalProgressionActivity::class.java)
        } else {
            Intent(this, CourseSelectActivity::class.java)
        }
        // Updates the current semester based off button clicks and updates if requirements have been met
        if (nextSemester) {
            listIntent.putExtra("semesterIndex", intent.extras!!.getInt("semesterIndex") + 1)
        } else if (numChosenCourses >= 3) {
            listIntent.putExtra("semesterIndex", intent.extras!!.getInt("semesterIndex") + 1)
        } else {
            listIntent.putExtra("semesterIndex", intent.extras!!.getInt("semesterIndex"))
        }
        if (!intent.extras!!.getBoolean("requirementOne")) {
            listIntent.putExtra("requirementOne", true)
        } else if (!intent.extras!!.getBoolean("requirementTwo")) {
            listIntent.putExtra("requirementOne", true)
            listIntent.putExtra("requirementTwo", true)
        } else {
            listIntent.putExtra("requirementOne", true)
            listIntent.putExtra("requirementTwo", true)
        }
        listIntent.putExtra("requirementThree", requirementThree)
        startActivity(listIntent)
    }

}
