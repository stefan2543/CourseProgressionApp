package com.example.courseprogressionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.courseprogressionapp.data.DataSource
import com.example.courseprogressionapp.databinding.CourseInfoBinding
import com.example.courseprogressionapp.data.ChosenCourses


class CourseInfoActivity : AppCompatActivity() {

    private lateinit var binding: CourseInfoBinding
    private lateinit var listIntent: Intent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CourseInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val courseData = DataSource.courses
        val course = courseData[intent.extras!!.getInt("courseIndex")]
        binding.imageViewZoom.setImageResource(course.imageResourceId)
        binding.courseNameZoom.text = course.name
        binding.courseDescriptionZoom.text = resources?.getString(R.string.course_description, course.description)
        binding.button2.setOnClickListener { launchSemester(false)  }
        binding.addBtn.setOnClickListener { launchSemester(true) }

    }

    private fun launchSemester(nextSemester: Boolean) {
        var requirementThree = false
        val courseData = DataSource.courses
        val course = courseData[intent.extras!!.getInt("courseIndex")]
        course.chosenSemester = intent.extras!!.getInt("semesterIndex")
        val chosenCourseData = ChosenCourses.courses
        chosenCourseData.add(course)
        courseData.removeAt(intent.extras!!.getInt("courseIndex"))

        var index = 0
        var numChosenCoursesTotal = chosenCourseData.size
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

        listIntent = if (intent.extras!!.getInt("semesterIndex") == 7) {
            Intent(this, FinalProgressionActivity::class.java)
        } else if (requirementThree){
            Intent(this, FinalProgressionActivity::class.java)
        } else {
            Intent(this, CourseSelectActivity::class.java)
        }

        if (nextSemester) {
            listIntent.putExtra("semesterIndex", intent.extras!!.getInt("semesterIndex") + 1)
        } else if (numChosenCourses >= 3) {
            listIntent.putExtra("semesterIndex", intent.extras!!.getInt("semesterIndex") + 1)
        }
        else {
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
