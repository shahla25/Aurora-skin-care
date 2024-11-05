/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.skincare.controller;
import com.skincare.model.Appointment;
import java.util.Date;

import java.util.List;

/**
 *
 * @author mhmha
 */
public interface AppointmentDAO {

    // Save a new appointment to the database
    void saveAppointment(Appointment appointment);

    // Update an existing appointment in the database
    void updateAppointment(Appointment appointment);

    // Delete an appointment from the database
    void deleteAppointment(Appointment appointment);

    // Retrieve an appointment by its unique identifier
    Appointment getAppointment(int id);

    // Retrieve a list of all appointments in the database
    List<Appointment> listAppointment();

    // Retrieve a list of doctor names available in the system
    List<String> getDoctorNames();

    // Retrieve a list of status options (e.g., Active, Inactive)
    List<String> getStatusList();

    // Retrieve a list of available appointment times for a specific doctor and date
    List<String> getTimeList(String selectedDoctorName, Date selectedDate);
}
