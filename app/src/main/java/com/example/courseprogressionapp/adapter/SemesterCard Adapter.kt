package com.example.courseprogressionapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.courseprogressionapp.R
import com.example.courseprogressionapp.data.DataSource.courses
import com.example.courseprogressionapp.Layout.Layout.GRID
import com.example.courseprogressionapp.model.Course

class SemesterCardAdapter(
    private val context: Context?,
    private val layout: Int,
    private val requirementOne: Boolean,
    private val requirementTwo: Boolean,
    private val requirementThree: Boolean

): RecyclerView.Adapter<SemesterCardAdapter.SemesterCardViewHolder>() {

    /**
     * Initialize variable with the idol's data taken from DataSource idol class
     */
    val courseData = courses
    val validCourseData = mutableListOf<Course>()
    val semesters: MutableList<String> = mutableListOf("1st Year Fall", "1st Year Spring", "2nd Year Fall", "2nd Year Spring", "3rd Year Fall", "3rd Year Spring", "4th Year Fall", "4th Year Spring")


    /**
     * Initialize view elements
     */
    class SemesterCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val courseNameOne: TextView = view!!.findViewById(R.id.course_name_1)
        val courseImageOne: ImageView = view!!.findViewById(R.id.course_image_1)
        val courseNameTwo: TextView = view!!.findViewById(R.id.course_name_2)
        val courseImageTwo: ImageView = view!!.findViewById(R.id.course_image_2)
        val courseNameThree: TextView = view!!.findViewById(R.id.course_name_3)
        val courseImageThree: ImageView = view!!.findViewById(R.id.course_image_3)
        val semester: TextView = view!!.findViewById(R.id.semester)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SemesterCardAdapter.SemesterCardViewHolder {
        /**
         * Defines which layout will be inflated based on layout object value,
         * vertical/horizontal for all cases except grid
         */
        var adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.vertical_list_item, parent, false)
        if (layout == GRID) {
            adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_list_item, parent, false)
        }
        return SemesterCardAdapter.SemesterCardViewHolder(adapterLayout)
    }



    /**
     * Returns the length of the list of idols
     */
    override fun getItemCount(): Int { return 8 }

    /**
     * Sets the data to be displayed in the view card using the position of the idol in the list
     */
    override fun onBindViewHolder(holder: SemesterCardAdapter.SemesterCardViewHolder, position: Int) {
        val resources = context?.resources
        var index = 0
        while (index < courseData.size) {
            if (courseData[index].chosenSemester == position) {
                validCourseData.add(courseData[index])
            }
            index++
        }
        index = 0
        while (index < validCourseData.size) {
            val course = courseData[index]
            if (validCourseData.size >= 1) {
                holder.courseImageOne.setImageResource(course.imageResourceId)
                holder.courseNameOne.text = course.name
            }
            if (validCourseData.size >= 2) {
                holder.courseImageTwo.setImageResource(course.imageResourceId)
                holder.courseNameTwo.text = course.name
            }
            if (validCourseData.size >= 3) {
                holder.courseImageThree.setImageResource(course.imageResourceId)
                holder.courseNameThree.text = course.name
            }
        }
        holder.semester.text = semesters[position]
    }
}