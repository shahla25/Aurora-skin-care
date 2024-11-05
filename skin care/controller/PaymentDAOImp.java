/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skincare.controller;

import com.skincare.db.ToothcareDb;
import com.skincare.model.Payment;
import com.skincare.model.Receipt;

/**
 *
 * @author mhmha
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;


/**
 * Implementation of the PaymentDAO interface providing methods for payment-related operations.
 * This class includes functionality to calculate registration fees, get a treatment list, 
 * calculate additional cost for a specific treatment, calculate total price, update payment details,
 * retrieve payment details, list all payments, and generate a receipt.
 */

public class PaymentDAOImp implements PaymentDAO {
    
    // Registration fees
    private static final int REGISTRATION_FEES = 1000;
    
    public int getRegistrationFees() {
        return REGISTRATION_FEES;
    }
    
    @Override
    public List<String> getTreatmentList() {
        return Arrays.asList("Cleanings", "Whitening", "Filling", "Nerve Filling", "Root Canal Therapy");
    }
    
    public int calculateAdditionalCost(String treatment) {
        int additionalCost = 0;
        switch (treatment) {
            case "Cleanings":
                additionalCost = 2500;
                break;
            case "Whitening":
                additionalCost = 3000;
                break;
            case "Filling":
                additionalCost = 3500;
                break;
            case "Nerve Filling":
                additionalCost = 4000;
                break;
            case "Root Canal Therapy":
                additionalCost = 4500;
                break;
            // Add more cases if needed for other treatments
        }
        return additionalCost;
    }
    
    public int calculateTotalPrice(String treatment) {
        // Calculate the total price including registration fees and additional cost
        return Payment.getRegistrationFees() + calculateAdditionalCost(treatment);
    }

    @Override
    public void updatePayment(Payment payment) {
        try {
            // Get a connection to the database
            Connection con = skincareDb.getConnection();
            
            // SQL query to update appointment details
            String sql = "UPDATE appointment SET patientName=?, treatment=?, totalPrice=? WHERE appointmentId =?";
            
            // Prepare the SQL statement
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            
            // Set values for the placeholders in the SQL query
            ps.setString(1, payment.getPatientName());
            ps.setString(2, payment.getTreatment());
            ps.setInt(3, payment.getTotalPrice());
            ps.setInt(4, payment.getAppointmentId());

            // Execute the SQL statement
            ps.executeUpdate();
            
            // Display a success message
            JOptionPane.showMessageDialog(null, "Payment Details Updated");

        } catch (Exception e) {
            e.printStackTrace();
            // Display an error message
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public Payment getPayment(int id) {
        Payment pt = new Payment();
        try {
            // Get a connection to the database
            Connection con = skincareDb.getConnection();
            
            // SQL query to retrieve appointment details by ID
            String sql = "SELECT * FROM appointment WHERE appointmentId=?";
            
            // Prepare the SQL statement
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            
            // Set the value for the placeholder in the SQL query
            ps.setInt(1, id);

            // Execute the SQL query
            ResultSet rs = ps.executeQuery();
            
            // Process the result set
            if (rs.next()) {
                pt.setAppointmentId(rs.getInt("appointmentId"));
                pt.setPatientName(rs.getString("patientName"));
                pt.setTreatment(rs.getString("treatment"));
                pt.setTotalPrice(rs.getInt("totalPrice"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Display an error message
            JOptionPane.showMessageDialog(null, "Error");
        }
        return pt;
    }

    @Override
    public List<Payment> listPayment() {
        List<Payment> list = new ArrayList<>();
        try {
            // Get a connection to the database
            Connection con = skincareDb.getConnection();
            
            // SQL query to retrieve all appointments
            String sql = "SELECT * FROM appointment";
            
            // Prepare the SQL statement
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            
            // Execute the SQL query
            ResultSet rs = ps.executeQuery();
            
            // Process the result set
            while (rs.next()) {
                Payment pt = new Payment();
                pt.setAppointmentId(rs.getInt("appointmentId"));
                pt.setPatientName(rs.getString("patientName"));
                pt.setTreatment(rs.getString("treatment"));
                pt.setTotalPrice(rs.getInt("totalPrice"));


                list.add(pt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Receipt getReceipt(int appointmentId) {
        try {
            Connection con = skincareDb.getConnection();
            String sql = "SELECT * FROM appointment WHERE appointmentId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, appointmentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Receipt receipt = new Receipt();
                receipt.setAppointmentId(rs.getInt("appointmentId"));
                receipt.setPatientName(rs.getString("patientName"));
                receipt.setTreatment(rs.getString("treatment"));
                receipt.setRegistrationFees(Payment.getRegistrationFees());

                // Calculate additional cost based on treatment
                int additionalCost = calculateAdditionalCost(receipt.getTreatment());
                receipt.setAdditionalCost(additionalCost);

                // Calculate total cost
                int totalCost = Payment.getRegistrationFees() + additionalCost;
                receipt.setTotalCost(totalCost);

                // Set current date and time
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                receipt.setCurrentDateTime(sdf.format(new Date()));

                return receipt;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
