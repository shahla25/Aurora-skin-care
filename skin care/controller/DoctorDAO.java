/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.skincare.controller;
import com.skincare.model.Doctor;

import java.util.List;

/**
 *
 * @author mhmha
 */
public interface DoctorDAO {
    public void saveDoctor(Doctor doctor);
    public void updateDoctor(Doctor doctor);
    public void deleteDoctor(Doctor doctor);
    public Doctor getDoctor (int id);
    public List<Doctor> listDoctor();
}
