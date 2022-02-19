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

class CourseCardAdapter(
    private val context: Context?,
    private val layout: Int
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
        //val idolAge: TextView = view!!.findViewById(R.id.idol_age)
        val courseDescription: TextView = view!!.findViewById(R.id.course_description)
        val imageView: ImageView = view!!.findViewById(R.id.course_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseCardViewHolder {
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
        return CourseCardViewHolder(adapterLayout)
    }

    /**
     * Returns the length of the list of idols
     */
    override fun getItemCount(): Int = courseData.size

    /**
     * Sets the data to be displayed in the view card using the position of the idol in the list
     */
    override fun onBindViewHolder(holder: CourseCardViewHolder, position: Int) {
        val resources = context?.resources
        val course = courseData[position]
        holder.imageView.setImageResource(course.imageResourceId)
        holder.courseName.text = course.name
        //holder.idolAge.text = resources?.getString(R.string.dog_age, idol.age)
        holder.courseDescription.text = resources?.getString(R.string.course_description, course.description)
    }
}