package com.example.courseprogressionapp.data

import com.example.courseprogressionapp.R
import com.example.courseprogressionapp.model.Course

/**
 * Group 7
 * File last updated: 2/21/22
 */

object DataSource {

    val courses: MutableList<Course> = mutableListOf(
        Course(
            R.drawable.cs303,
            "CS 303: Elements of Computers & Programming",
            "This course will introduce basics of programming within the context of a popular and powerful programming language, Python. The course will include the study of the syntax and special features of Python, develop algorithms, and translate them into computer code. Problem solving techniques for a wide variety of problems amenable to computer solution. No prior programming experience is required or assumed.",
            "Bill Young",
            -1
        ),
        Course(
            R.drawable.cs313,
            "CS 313: Elements of Software Design",
            "The emphasis of this course is on software development using object-oriented methodology. This course includes how to design software, how to create reusable software components, and how to compose programs from already available components. Furthermore, students learn about some basic data structures and algorithms and how to match the data structures and algorithms to problems.",
            "Kia Teymourian",
            -1
        ),

        Course(
            R.drawable.cs323,
            "CS 323E: Elements of Scientific Computing ",
            "This is an upper division Elements of Computing course. You should know basic Python syntax and concepts in data structures and algorithms. The emphasis of this course will be on the solution of scientific equations using numerical methods.",
            "Dr. Shyamal Mitra",
            -1
        ),
        Course(
            R.drawable.cs324,
            "C S 324E: Elements of Graphics & Visualization ",
            "This course teaches the basics of computer graphics and data visualization. We'll explore graph generation, image manipulation, scene hierarchy, simulation, interactivity, and object-oriented programming. This will give you a good understanding of how you might use graphics and for data visualization, art generation, and video game development. We'll work in the Java-based language, Processing, and learn about ThreeJS in JavaScript.",
            "Chand John",
            -1
        ),
        Course(
            R.drawable.cs327,
            "C S 327E: Elements of Databases",
            "This course is designed to give students a practical introduction to databases and data systems. The goal is to learn modern data management and data processing techniques through a mix of best practices, experimentation, and problem solving.",
            "Shirley Cohen",
            -1
        ),
        Course(
            R.drawable.cs330,
            "CS 330E: Elements of Software Engineering I",
            "This is a course on software engineering using Python. It is strongly focused on using tools to improve the quality of software development, including automated builds with make, source control with git and GitLab, unit testing with unittest, code coverage with coverage, continuous integration with GitLab CI, automated documentation with pydoc, Docker.",
            "Fares Fraij",
            -1
        ),
        Course(
            R.drawable.cs331,
            "C S 331E: Elements of Software Engineering II",
            "This is an advanced course in software engineering. It will include the creation of a dynamic website with a database backend using tools such as Digital Ocean or Google Cloud Platform, Bootstrap, Flask, Namecheap, PostgreSQL, RESTful APIs, Slack, and SQLAlchemy.",
            "Fares Fraij",
            -1
        ),
        Course(
            R.drawable.web_programming,
            "C S 329E: Elements of Web Programming",
            "This is an upper-division elective course in the Elements of Computing program for non-CS majors. Computing has become an integral part of all natural sciences and engineering disciplines. This is an introductory course in web development. By the end of the course, students will will be able to understand and articulate the unique challenges of developing web pages and applications, and will be able to create simple web applications from scratch using technologies such as HTML, CSS, Javascript, JQuery, PHP, and MySQL.",
            "Dr. William C. (Bill) Bulko",
            -1
        ),
        Course(
            R.drawable.mobile_computing,
            "C S 329E: Elements of Mobile Computing",
            "This is a project-based course covering mobile development. We will be developing for Android using the Kotlin language. We will follow the agile development pipeline, object-oriented programming practices, the Model-View-Controller pattern, and use various forms of data input for mobile software development. This course will involve homework and lab assignments, quizzes, in-class participation, and will culminate in one large final project (there is no final exam).",
            "MJ Johns",
            -1
        ),
        Course(
            R.drawable.game_dev,
            "C S 329E: Elements of Game Development",
            "This course provides students with the fundamentals of how to be a software developer creating a digital game. The course focuses on three areas: (1) learning html5, CSS, and JavaScript using the Phaser game engine to develop a game, (2) general principals of game design and software engineering processes, and (3) how to work in a team. This course is focused on learning how to create 2D games in small teams. ",
            "Dr. Paul Toprac",
            -1
        ),
        Course(
            R.drawable.data_vis,
            "C S 329E: Elements of Data Visualization",
            "An introduction to key design principles and techniques for interactively visualizing data. The major goals of this course are to understand how visual representations can help in the analysis and understanding of complex data, how to design effective visualizations, and how to create your own interactive visualizations using modern frameworks.",
            "Anna Chaney",
            -1
        ),
        Course(
            R.drawable.data_anal,
            "C S 329E: Elements of Data Analytics",
            "An exploration of algorithms to find patterns in datasets. Topics include regression, classification, clustering, anomaly detection, and association analysis. ",
            "Anna Chaney",
            -1
        )
    )

}