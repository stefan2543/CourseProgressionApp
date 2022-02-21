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
        listIntent = if (intent.extras!!.getInt("semesterIndex") == 7) {
            Intent(this, FinalProgressionActivity::class.java)
        } else if (intent.extras!!.getBoolean("requirementThree")){
            Intent(this, FinalProgressionActivity::class.java)
        } else {
            Intent(this, CourseSelectActivity::class.java)
        }
        //var chosenCourses = intent.extras!!.getParcelableArrayList("chosenCourses")
        //chosenCourses.add(index: intent.extras!!.getInt("semesterIndex"), element: course)
        val courseData = DataSource.courses
        val course = courseData[intent.extras!!.getInt("courseIndex")]
        course.chosenSemester = intent.extras!!.getInt("semesterIndex")

        if (nextSemester) {
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
        listIntent.putExtra("requirementThree", intent.extras!!.getBoolean("requirementThree"))
        listIntent.putExtra("chosenCourses", intent.extras!!.getParcelableArray("chosenCourses"))
        startActivity(listIntent)
    }

}
