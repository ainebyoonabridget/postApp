package com.example.hello.models

import com.example.hello.models.Course
import com.google.gson.annotations.SerializedName

data class CoursesResponse(
    @SerializedName("courses") var courses: List<Course>
)

annotation class SerializedName(val value: String)
