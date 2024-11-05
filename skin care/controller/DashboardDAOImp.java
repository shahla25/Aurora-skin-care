/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skincare.controller;

import com.skincare.db.skincareDb;
import com.skincare.model.Dashboard;
import com.skincare.model.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mhmha
 */

public class DashboardDAOImp implements DashboardDAO {

    // Assume that you have a method to establish a database connection (e.g., skincareDb.getConnection())

    @Override
    public int getTotalDoctors() {
        // Variable to store the total number of doctors
        int totalDoctors = 0;

        try (Connection con = skincareDb.getConnection();
             // SQL query to count the number of doctors
             PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS totalDoctors FROM doctor");
             ResultSet rs = ps.executeQuery()) {

            // Retrieve the result from the query
            if (rs.next()) {
                totalDoctors = rs.getInt("totalDoctors");
            }

        } catch (SQLException | ClassNotFoundException e) {
            // Print the stack trace for debugging purposes
            e.printStackTrace();
            // Handle the exception appropriately in a real-world scenario
        } catch (Exception ex) {
            // Log the exception using Java's logging framework
            Logger.getLogger(DashboardDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the total number of doctors
        return totalDoctors;
    }

    @Override
    public int getTotalAppointments() {
        // Variable to store the total number of appointments
        int totalAppointments = 0;

        try (Connection con = skincareeDb.getConnection();
             // SQL query to count the number of appointments
             PreparedStatement ps = con.prepareStatement("SELECT COUNT(*) AS totalAppointments FROM appointment");
             ResultSet rs = ps.executeQuery()) {

            // Retrieve the result from the query
            if (rs.next()) {
                totalAppointments = rs.getInt("totalAppointments");
            }

        } catch (SQLException | ClassNotFoundException e) {
            // Print the stack trace for debugging purposes
            e.printStackTrace();
            // Handle the exception appropriately in a real-world scenario
        } catch (Exception ex) {
            // Log the exception using Java's logging framework
            Logger.getLogger(DashboardDAOImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the total number of appointments
        return totalAppointments;
    }
}
