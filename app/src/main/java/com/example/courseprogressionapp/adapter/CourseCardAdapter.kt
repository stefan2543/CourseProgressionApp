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

class CourseCardAdapter(
    private val context: Context?,
    private val layout: Int,
    private val requirementOne: Boolean,
    private val requirementTwo: Boolean,
    private val requirementThree: Boolean

): RecyclerView.Adapter<CourseCardAdapter.CourseCardViewHolder>() {

    /**
     * Initialize variable with the idol's data taken from DataSource idol class
     */
    val courseData = courses


    /**
     * Initialize view elements
     */
    class CourseCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        val courseName: TextView = view!!.findViewById(R.id.course_name)
        val imageView: ImageView = view!!.findViewById(R.id.course_image)




    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseCardAdapter.CourseCardViewHolder {
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
        return CourseCardAdapter.CourseCardViewHolder(adapterLayout)
    }



    /**
     * Returns the length of the list of idols
     */
    override fun getItemCount(): Int {
        return if (!requirementOne) {
            1
        } else if (!requirementTwo) {
            1
        } else {
            courseData.size
            }
        }


    /**
     * Sets the data to be displayed in the view card using the position of the idol in the list
     */
    override fun onBindViewHolder(holder: CourseCardAdapter.CourseCardViewHolder, position: Int) {
        val resources = context?.resources
        val course = courses[position]
        holder.imageView.setImageResource(course.imageResourceId)
        holder.courseName.text = course.name
    }
}