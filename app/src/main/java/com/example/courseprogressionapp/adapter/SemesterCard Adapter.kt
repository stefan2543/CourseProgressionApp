package com.example.courseprogressionapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.courseprogressionapp.R
import com.example.courseprogressionapp.data.ChosenCourses.courses
import com.example.courseprogressionapp.model.Course

/**
 * Group 7
 * File last updated: 2/21/22
 */

class SemesterCardAdapter(


) : RecyclerView.Adapter<SemesterCardAdapter.SemesterCardViewHolder>() {

    /**
     * Initialize variable with the course data taken from DataSource course class
     * Defines List of semester names
     */
    private val courseData = courses
    private val semesters: MutableList<String> = mutableListOf(
        "1st Year Fall",
        "1st Year Spring",
        "2nd Year Fall",
        "2nd Year Spring",
        "3rd Year Fall",
        "3rd Year Spring",
        "4th Year Fall",
        "4th Year Spring"
    )


    /**
     * Initialize view elements
     */
    class SemesterCardViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
        val courseNameOne: TextView = view!!.findViewById(R.id.course_name_1)
        val courseImageOne: ImageView = view!!.findViewById(R.id.course_image_1)
        val courseNameTwo: TextView = view!!.findViewById(R.id.course_name_2)
        val courseImageTwo: ImageView = view!!.findViewById(R.id.course_image_2)
        val courseNameThree: TextView = view!!.findViewById(R.id.course_name_3)
        val courseImageThree: ImageView = view!!.findViewById(R.id.course_image_3)
        val semester: TextView = view!!.findViewById(R.id.semester)


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SemesterCardAdapter.SemesterCardViewHolder {
        /**
         * Defines which layout will be inflated
         */
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.grid_list_item, parent, false)

        return SemesterCardAdapter.SemesterCardViewHolder(adapterLayout)
    }


    /**
     * Returns the length of the list of semesters
     */
    override fun getItemCount(): Int {
        return semesters.size
    }

    /**
     * Sets the data to be displayed in the view card using the position of the semester in the list
     * and adds only chosen courses to each semester
     */
    override fun onBindViewHolder(
        holder: SemesterCardAdapter.SemesterCardViewHolder,
        position: Int
    ) {
        var index = 0
        val validCourseData = mutableListOf<Course>()
        /**
         * Adds chosen course to current semester
         */
        while (index < courseData.size) {
            if (courseData[index].chosenSemester == position) {
                validCourseData.add(courseData[index])
            }
            index++
        }
        /**
         * Sets course data to be displayed for each course in current semester
         */
        if (validCourseData.size >= 1) {
            holder.courseImageOne.setImageResource(validCourseData[0].imageResourceId)
            holder.courseNameOne.text = validCourseData[0].name
        }
        if (validCourseData.size >= 2) {
            holder.courseImageTwo.setImageResource(validCourseData[1].imageResourceId)
            holder.courseNameTwo.text = validCourseData[1].name
        }
        if (validCourseData.size >= 3) {
            holder.courseImageThree.setImageResource(validCourseData[2].imageResourceId)
            holder.courseNameThree.text = validCourseData[2].name
        }
        holder.semester.text = semesters[position]
    }
}