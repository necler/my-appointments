package com.example.myappointments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappointments.models.Appointment
import kotlinx.android.synthetic.main.activity_appointments.*

class AppointmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        val appointments = ArrayList<Appointment>()

        appointments.add(Appointment(1,"Médico AA","22/07/2020","03:00 PM"))
        appointments.add(Appointment(2,"Médico BB","23/07/2020","04:00 PM"))
        appointments.add(Appointment(3,"Médico CC","24/07/2020","05:00 PM"))

        rvAppointment.layoutManager = LinearLayoutManager(this)
        rvAppointment.adapter = AppointmentsAdapter(appointments)

    }


}