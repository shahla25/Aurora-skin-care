/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skincare.model;

import java.util.Date;

/**
 *
 * @author mhmha
 */
import java.util.Date;

public class Appointment {
    // Unique identifier for the appointment
    private int appointmentId;

    // Name of the doctor handling the appointment
    private String doctorName;

    // Date of the appointment
    private Date appointmentDate;

    // Time of the appointment
    private String appointmentTime;

    // Name of the patient
    private String patientName;

    // Phone number of the patient
    private int patientPhone;

    // Address of the patient
    private String patientAddress;

    // Current status of the appointment (e.g., confirmed, canceled)
    private String status;

    // Total cost of the appointment
    private int totalPrice;

    
    // Getter and setter methods for appointmentId
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    // Getter and setter methods for doctorName
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    // Getter and setter methods for appointmentDate
    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    // Getter and setter methods for appointmentTime
    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    // Getter and setter methods for patientName
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    // Getter and setter methods for patientPhone
    public int getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(int patientPhone) {
        this.patientPhone = patientPhone;
    }

    // Getter and setter methods for patientAddress
    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    // Getter and setter methods for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and setter methods for totalPrice
    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}

