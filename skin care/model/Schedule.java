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
/**
 * Represents a Schedule entity for a doctor's availability.
 */
public class Schedule {
    // Fields to store schedule details
    public int scheduleId;
    public String doctorName;
    public Date scheduleDate; // Updated to Date type
    public String scheduleTime;
    public String status;

    // Getter and setter methods for scheduleId
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    // Getter and setter methods for doctorName
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    // Getter and setter methods for scheduleDate
    public Date getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(Date scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    // Getter and setter methods for scheduleTime
    public String getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    // Getter and setter methods for status
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
