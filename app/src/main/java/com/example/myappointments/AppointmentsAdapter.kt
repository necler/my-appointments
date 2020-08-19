package com.example.myappointments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myappointments.models.Appointment
import kotlinx.android.synthetic.main.items_appointment.view.*

class AppointmentsAdapter (private val appointments: ArrayList<Appointment>): RecyclerView.Adapter<AppointmentsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind (appointment : Appointment) = with(itemView){
                tvAppointmentId.text = "Cita médica nº ${appointment.id}"
                tvDoctorName.text = appointment.doctorName
                tvScheduleDate.text = "Atención el día ${appointment.scheduleDate}"
                tvScheduleTime.text = "A las ${appointment.scheduleTime}"

            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.items_appointment,parent,false)
            )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val appointment = appointments[position]

        holder.bind(appointment)
    }

    override fun getItemCount() = appointments.size


}