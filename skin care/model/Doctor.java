/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skincare.model;

/**
 *
 * @author mhmha
 */
/**
 * Represents a Doctor entity with basic information.
 */
public class Doctor {
    // Fields to store doctor details
    public int doctorId;
    public String doctorName;
    public int doctorContactNo;
    public String status;

    // Getter and setter methods for doctorId
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    // Getter and setter methods for doctorName
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    // Getter and setter methods for doctorContactNo
    public int getDoctorContactNo() {
        return doctorContactNo;
    }

    public void setDoctorContactNo(int doctorContactNo) {
        this.doctorContactNo = doctorContactNo;
    }

    // Getter and setter methods for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

