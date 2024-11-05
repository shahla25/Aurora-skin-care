/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skincare.controller;

import com.skincare.db.skincareDb;
import com.skincare.model.Appointment;

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

public class AppointmentDAOImp implements AppointmentDAO {
    
    public int totalPrice = 1000;


    @Override
    public void saveAppointment(Appointment appointment) {
        try {
            // Get a connection to the database
            Connection con = skincareDb.getConnection();
            
            // SQL query to insert appointment details
            String sql = "INSERT INTO appointment(doctorName, appointmentDate, appointmentTime, patientName, patientPhone, patientAddress, status, totalPrice) VALUES(?,?,?,?,?,?,?,?)";
            
            // Prepare the SQL statement
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            
            // Set values for the placeholders in the SQL query
            ps.setString(1, appointment.getDoctorName());
            ps.setString(2, new SimpleDateFormat("yyyy-MM-dd").format(appointment.getAppointmentDate()));
            ps.setString(3, appointment.getAppointmentTime());
            ps.setString(4, appointment.getPatientName());
            ps.setInt(5, appointment.getPatientPhone());
            ps.setString(6, appointment.getPatientAddress());
            ps.setString(7, appointment.getStatus());
            ps.setInt(8, totalPrice);

            // Execute the SQL statement
            ps.executeUpdate();
            
            // Display a success message
            JOptionPane.showMessageDialog(null, "Appointment Details Saved");

        } catch (Exception e) {
            e.printStackTrace();
            // Display an error message
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void updateAppointment(Appointment appointment) {
        try {
            // Get a connection to the database
            Connection con = skincareDb.getConnection();
            
            // SQL query to update appointment details
            String sql = "UPDATE appointment SET doctorName=?, appointmentDate=?, appointmentTime=?, patientName=?, patientPhone=?, patientAddress=?, status=?, totalPrice=? WHERE appointmentId =?";
            
            // Prepare the SQL statement
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            
            // Set values for the placeholders in the SQL query
            ps.setString(1, appointment.getDoctorName());
            ps.setDate(2, new java.sql.Date(appointment.getAppointmentDate().getTime()));
            ps.setString(3, appointment.getAppointmentTime());
            ps.setString(4, appointment.getPatientName());
            ps.setInt(5, appointment.getPatientPhone());
            ps.setString(6, appointment.getPatientAddress());
            ps.setString(7, appointment.getStatus());
            ps.setInt(8, totalPrice);
            ps.setInt(9, appointment.getAppointmentId());

            // Execute the SQL statement
            ps.executeUpdate();
            
            // Display a success message
            JOptionPane.showMessageDialog(null, "Appointment Details Updated");

        } catch (Exception e) {
            e.printStackTrace();
            // Display an error message
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void deleteAppointment(Appointment appointment) {
        try {
            // Get a connection to the database
            Connection con = skincareDb.getConnection();
            
            // SQL query to delete an appointment
            String sql = "DELETE from appointment WHERE appointmentId=?";
            
            // Prepare the SQL statement
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            
            // Set the value for the placeholder in the SQL query
            ps.setInt(1, appointment.getAppointmentId());

            // Execute the SQL statement
            ps.executeUpdate();
            
            // Display a success message
            JOptionPane.showMessageDialog(null, "Appointment Details Deleted");

        } catch (Exception e) {
            e.printStackTrace();
            // Display an error message
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public Appointment getAppointment(int id) {
        Appointment pt = new Appointment();
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
                pt.setDoctorName(rs.getString("doctorName"));
                pt.setAppointmentDate(rs.getDate("appointmentDate"));
                pt.setAppointmentTime(rs.getString("appointmentTime"));
                pt.setPatientName(rs.getString("patientName"));
                pt.setPatientPhone(rs.getInt("patientPhone"));
                pt.setPatientAddress(rs.getString("patientAddress"));
                pt.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Display an error message
            JOptionPane.showMessageDialog(null, "Error");
        }
        return pt;
    }

    @Override
    public List<Appointment> listAppointment() {
        List<Appointment> list = new ArrayList<>();
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
                Appointment pt = new Appointment();
                pt.setAppointmentId(rs.getInt("appointmentId"));
                pt.setDoctorName(rs.getString("doctorName"));
                pt.setAppointmentDate(rs.getDate("appointmentDate"));
                pt.setAppointmentTime(rs.getString("appointmentTime"));
                pt.setPatientName(rs.getString("patientName"));
                pt.setPatientPhone(rs.getInt("patientPhone"));
                pt.setPatientAddress(rs.getString("patientAddress"));
                pt.setStatus(rs.getString("status"));
                pt.setTotalPrice(rs.getInt("totalPrice"));

                list.add(pt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<String> getDoctorNames() {
        List<String> doctorNames = new ArrayList<>();
        try {
            // Get a connection to the database
            Connection con = skincareDb.getConnection();
            
            // SQL query to retrieve active doctor names
            String sql = "SELECT doctorName FROM doctor WHERE status='Active'";
            
            // Prepare the SQL statement
            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
                // Process the result set
                while (rs.next()) {
                    doctorNames.add(rs.getString("doctorName"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception or rethrow a custom exception
        }
        return doctorNames;
    }

    @Override
    public List<String> getStatusList() {
        return Arrays.asList("Active", "Inactive");
    }

    @Override
    public List<String> getTimeList(String selectedDoctorName, Date selectedDate) {
        List<String> timeList = new ArrayList<>();
        try {
            // Get a connection to the database
            Connection con = skincareDb.getConnection();
            
            // SQL query to retrieve available appointment times
            String sql = "SELECT DISTINCT ts.scheduleTime " +
                         "FROM timeschedule ts " +
                         "LEFT JOIN appointment app ON ts.scheduleTime = app.appointmentTime " +
                         "WHERE ts.doctorName = ? AND ts.scheduleDate = ? AND ts.status = 'Active' " +
                         "AND (app.appointmentTime IS NULL OR app.doctorName IS NULL OR app.appointmentDate IS NULL)";

            // Prepare the SQL statement
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, selectedDoctorName);
                ps.setDate(2, new java.sql.Date(selectedDate.getTime()));

                System.out.println("Executing SQL Query: " + ps.toString()); // Print the SQL query

                // Execute the SQL query
                try (ResultSet rs = ps.executeQuery()) {
                    // Process the result set
                    while (rs.next()) {
                        timeList.add(rs.getString("scheduleTime"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error getting appointment times: " + e.getMessage());
        }
        return timeList;
    }
}
