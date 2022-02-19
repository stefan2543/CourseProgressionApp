package com.example.courseprogressionapp.data

import com.example.courseprogressionapp.R
import com.example.courseprogressionapp.model.Course


object DataSource {

    val courses: List<Course> = listOf(
        Course(
            //R.drawable.image file name
            name: "CS 303E",
            description: "This course will introduce basics of programming within the context of a popular and powerful programming language, Python. The course will include the study of the syntax and special features of Python, develop algorithms, and translate them into computer code. Problem solving techniques for a wide variety of problems amenable to computer solution. No prior programming experience is required or assumed.",
            source: "Bill Young"
        ),
        Course(
            //R.drawable.image file name
            name: "CS 313E",
            description: "The emphasis of this course is on software development using object-oriented methodology. This course includes how to design software, how to create reusable software components, and how to compose programs from already available components. Furthermore, students learn about some basic data structures and algorithms and how to match the data structures and algorithms to problems.",
            source: "Kia Teymourian"
        ),

    )
}