package com.example.courseprogressionapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.courseprogressionapp.Layout.Layout
import com.example.courseprogressionapp.adapter.SemesterCardAdapter
import com.example.courseprogressionapp.databinding.ActivityGridListBinding

class FinalProgressionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGridListBinding
    private lateinit var listIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gridRecyclerView.adapter = SemesterCardAdapter(
            applicationContext,
            Layout.GRID,
            intent.extras!!.getBoolean("requirementOne"),
            intent.extras!!.getBoolean("requirementTwo"),
            intent.extras!!.getBoolean("requirementThree")
        )

        binding.editBtn.setOnClickListener { launchSemester () }

        // Specify fixed size to improve performance
        binding.gridRecyclerView.setHasFixedSize(true)

    }

    private fun launchSemester() {
        listIntent = Intent(this, CourseSelectActivity::class.java)
        startActivity(listIntent)
    }
}