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



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CourseSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.verticalRecyclerView.adapter = CourseCardAdapter(
            applicationContext,
            Layout.VERTICAL,
            intent.extras!!.getBoolean("requirementOne"),
            intent.extras!!.getBoolean("requirementTwo"),
            intent.extras!!.getBoolean("requirementThree")
        )



        binding.verticalRecyclerView.onItemClick { recyclerView, position, v -> launchCourseInfo(position) }
        // Specify fixed size to improve performance
        binding.verticalRecyclerView.setHasFixedSize(true)


        binding.currentSemester.text = semesters[intent.extras!!.getInt("semesterIndex")]

        binding.skipBtn.setOnClickListener() { launchSemester () }
    }

    private fun launchCourseInfo(position: Int) {
        listIntent = Intent(this, CourseInfoActivity::class.java)
        listIntent.putExtra("courseIndex", position)
        listIntent.putExtra("semesterIndex", intent.extras!!.getInt("semesterIndex"))
        listIntent.putExtra("requirementOne", intent.extras!!.getBoolean("requirementOne"))
        listIntent.putExtra("requirementTwo", intent.extras!!.getBoolean("requirementTwo"))
        listIntent.putExtra("requirementThree", intent.extras!!.getBoolean("requirementThree"))

        startActivity(listIntent)
    }

    private fun launchSemester() {
        listIntent = Intent(this, CourseSelectActivity::class.java)
        listIntent.putExtra("semesterIndex", intent.extras!!.getInt("semesterIndex") + 1)
        listIntent.putExtra("requirementOne", intent.extras!!.getBoolean("requirementOne"))
        listIntent.putExtra("requirementTwo", intent.extras!!.getBoolean("requirementTwo"))
        listIntent.putExtra("requirementThree", intent.extras!!.getBoolean("requirementThree"))
        startActivity(listIntent)
    }

}
