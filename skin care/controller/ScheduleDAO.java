/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.skincare.controller;
import com.skincare.model.Schedule;

import java.util.List;

/**
 *
 * @author mhmha
 */
public interface ScheduleDAO {
    public void saveSchedule(Schedule schedule);
    public void updateSchedule(Schedule schedule);
    public void deleteSchedule(Schedule schedule);
    public Schedule getSchedule (int id);
    public List<Schedule> listSchedule();
    List<String> getDoctorNames();
    List<String> getStatusList();
    List<String> getTimeList();

}