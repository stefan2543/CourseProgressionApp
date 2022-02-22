package com.example.courseprogressionapp.model

import androidx.annotation.DrawableRes

/**
 * Group 7
 * File last updated: 2/21/22
 */

// This is course class template
data class Course(
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val description: String,
    val source: String,
    var chosenSemester: Int
)
