package com.example.courseprogressionapp.model

import androidx.annotation.DrawableRes

// This is course class template you add the skeleton of data info
data class Course (
    @DrawableRes val imageResourceId: Int,
    val name: String,
    val description: String,
    val source: String
    )
