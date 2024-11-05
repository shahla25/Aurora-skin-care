/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.skincare.controller;

import com.skincare.db.skincareDb;
import com.skincare.model.Doctor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mhmha
 */

/**
 * Implementation of the DoctorDAO interface providing CRUD operations for Doctor entities.
 */
public class DoctorDAOImp implements DoctorDAO{

    @Override
    public void saveDoctor(Doctor doctor) {
        try{
            Connection con = (Connection) skincareDb.getConnection();
            String sql = "INSERT INTO doctor(doctorName,doctorContactNo,status) VALUES(?,?,?)";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, doctor.getDoctorName());
            ps.setInt(2, doctor.getDoctorContactNo());
            ps.setString(3, doctor.getStatus());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Doctor Details Saved");
            
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        try{
            Connection con = (Connection) skincareDb.getConnection();
            String sql = "UPDATE doctor SET doctorName=?,doctorContactNo=?, status=? WHERE doctorId =?";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, doctor.getDoctorName());
            ps.setInt(2, doctor.getDoctorContactNo());
            ps.setString(3, doctor.getStatus());
            ps.setInt(4, doctor.getDoctorId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Doctor Details Updated");
         
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        } 
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        try{
            Connection con = (Connection) skincareDb.getConnection();
            String sql = "DELETE from doctor WHERE doctorId =?";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, doctor.getDoctorId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Doctor Details Deleted");
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        } 
    }

    @Override
    public Doctor getDoctor(int id) {
        Doctor pt = new Doctor();
        try{
            Connection con = (Connection) skincareDb.getConnection();
            String sql = "SELECT * FROM doctor WHERE doctorId=?";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pt.setDoctorId(rs.getInt("doctorId"));
                pt.setDoctorName(rs.getString("doctorName"));
                pt.setDoctorContactNo(rs.getInt("doctorContactNo"));
                pt.setStatus(rs.getString("status"));

            }
        } catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }    
        return pt;
    }

    @Override
    public List<Doctor> listDoctor() {
        List<Doctor> list = new ArrayList<Doctor>();
        try{
            Connection con = skincareDb.getConnection();
            String sql = "SELECT * FROM doctor";
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Doctor pt = new Doctor();
                pt.setDoctorId(rs.getInt("doctorId"));
                pt.setDoctorName(rs.getString("doctorName"));
                pt.setDoctorContactNo(rs.getInt("doctorContactNo"));
                pt.setStatus(rs.getString("status"));

                list.add(pt);    
            }  
        } catch (Exception e){
            e.printStackTrace();     
        }
        return list;
    }

    
}
