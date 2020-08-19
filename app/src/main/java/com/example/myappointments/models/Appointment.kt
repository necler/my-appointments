package com.example.myappointments.models

data class Appointment (
    val id: Int,
    val doctorName: String,
    val scheduleDate: String,
    val scheduleTime: String
)