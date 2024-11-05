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

/**
 * Represents a Receipt providing details of a patient's payment for a dental appointment.
 */
public class Receipt {
    // Fields to store receipt details
    private int appointmentId;
    private String currentDateTime;
    private String patientName;
    private String treatment;
    private int registrationFees;
    private int additionalCost;
    private int totalCost;

    // Getter and setter methods for appointmentId
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    // Getter and setter methods for currentDateTime
    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    // Getter and setter methods for patientName
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    // Getter and setter methods for treatment
    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    // Getter and setter methods for registrationFees
    public int getRegistrationFees() {
        return registrationFees;
    }

    public void setRegistrationFees(int registrationFees) {
        this.registrationFees = registrationFees;
    }

    // Getter and setter methods for additionalCost
    public int getAdditionalCost() {
        return additionalCost;
    }

    public void setAdditionalCost(int additionalCost) {
        this.additionalCost = additionalCost;
    }

    // Getter and setter methods for totalCost
    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}


