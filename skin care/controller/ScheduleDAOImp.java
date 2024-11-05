/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skincare.controller;

import com.skincare.db.skincareDb;
import com.skincare.model.Schedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mhmha
 */

/**
 * Implementation of the ScheduleDAO interface providing methods for managing doctor schedules.
 * This class includes functionality to save, update, delete, retrieve, and list schedules,
 * as well as get lists of doctor names, status, and time slots.
 */
public class ScheduleDAOImp implements ScheduleDAO{

    //Save Function
    @Override
    public void saveSchedule(Schedule schedule) {
        try {
            Connection con = skincareDb.getConnection();
            String sql = "INSERT INTO timeschedule(doctorName, scheduleDate, scheduleTime, status) VALUES(?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, schedule.getDoctorName());

            // Convert Date to String in the required format
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = sdf.format(schedule.getScheduleDate());
            ps.setString(2, formattedDate);

            ps.setString(3, schedule.getScheduleTime());
            ps.setString(4, schedule.getStatus());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Schedule Details Saved");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    //Update Function

    @Override
    public void updateSchedule(Schedule schedule) {
        try {
            Connection con = skincareDb.getConnection();
            String sql = "UPDATE timeschedule SET doctorName=?, scheduleDate=?, scheduleTime=?,status=? WHERE scheduleId =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, schedule.getDoctorName());
            ps.setDate(2, new java.sql.Date(schedule.getScheduleDate().getTime())); // Changed from schedule.getScheduleDate()
            ps.setString(3, schedule.getScheduleTime());
            ps.setString(4, schedule.getStatus());
            ps.setInt(5, schedule.getScheduleId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Schedule Details Updated");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    //Delete Function
    @Override
    public void deleteSchedule(Schedule schedule) {
        try {
            Connection con = skincareDb.getConnection();
            String sql = "DELETE FROM timeschedule WHERE scheduleId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, schedule.getScheduleId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Schedule Details Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    //Get Data Function
    @Override
    public Schedule getSchedule(int id) {
        Schedule pt = null;
        try {
            Connection con = skincareDb.getConnection();
            String sql = "SELECT * FROM timeschedule WHERE scheduleId=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pt = new Schedule();
                pt.setScheduleId(rs.getInt("scheduleId"));
                pt.setDoctorName(rs.getString("doctorName"));
                pt.setScheduleDate(rs.getDate("scheduleDate")); // Changed from getString to getDate
                pt.setScheduleTime(rs.getString("scheduleTime"));
                pt.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return pt;
    }

    //List Schedule Data Function
    @Override
    public List<Schedule> listSchedule() {
        List<Schedule> list = new ArrayList<>();

        try {
            Connection con = ToothcareDb.getConnection();
            String sql = "SELECT * FROM timeschedule";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Schedule pt = new Schedule();

                pt.setScheduleId(rs.getInt("scheduleId"));
                pt.setDoctorName(rs.getString("doctorName"));
                pt.setScheduleDate(rs.getDate("scheduleDate"));
                pt.setScheduleTime(rs.getString("scheduleTime"));
                pt.setStatus(rs.getString("status"));

                list.add(pt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list; 
    }
    
    
    //List DoctorNames Data Function
    @Override
    public List<String> getDoctorNames() {
        List<String> doctorNames = new ArrayList<>();
        try {
            Connection con = skincareDb.getConnection();
            String sql = "SELECT doctorName FROM doctor WHERE status='Active'";
            try (PreparedStatement ps = con.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {
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
    
    //Get Status Data Function
    @Override
    public List<String> getStatusList() {
        return Arrays.asList("Active", "Inactive");
    }

    //Get Time Data Function
    @Override
    public List<String> getTimeList() {
        return Arrays.asList("03.00pm", "03.30pm", "04.00pm", "04.30pm", "05.00pm", "05.30pm", "06.00pm",
                "06.30pm", "07.00pm", "07.30pm", "08.00pm", "08.30pm", "09.00pm", "09.30pm");
    }
    

}