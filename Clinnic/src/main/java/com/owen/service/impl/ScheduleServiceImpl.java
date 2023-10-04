/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.service.impl;

import com.owen.pojo.ScheduleDetail;
import com.owen.pojo.User;
import com.owen.repository.ScheduleRepository;
import com.owen.service.ScheduleService;
import com.owen.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Trinh Bao Duy
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<ScheduleDetail> getSchedules(Map<String, String> params) {
        return this.scheduleRepository.getSchedules(params);
    }

    @Override
    public boolean addOrUpdateScheduleDetail(ScheduleDetail m) {
        return this.scheduleRepository.addOrUpdateScheduleDetail(m);
    }

    @Override
    public boolean deleteScheduleDetail(int id) {
        return this.scheduleRepository.deleteScheduleDetail(id);
    }

    @Override
    public boolean addOrUpdateScheduleDetails(List<ScheduleDetail> scheduleDetails) {
        return this.scheduleRepository.addOrUpdateScheduleDetails(scheduleDetails);
    }

    @Override
    public List<ScheduleDetail> getSchedules(Date fromDate, int roleId) {
        return this.scheduleRepository.getSchedules(fromDate, roleId);
    }

    @Override
    public List<ScheduleDetail> getSchedulesaccepted(Date fromDate) {
        return this.scheduleRepository.getSchedulesaccepted(fromDate);
    }

    @Override
    public ScheduleDetail getScheduleDetailById(int id) {
        return this.scheduleRepository.getScheduleDetailById(id);
    }

    @Override
    public boolean checkLichHopLe(Date dateSchedule, int shiftId, int role) {
        return this.scheduleRepository.checkLichHopLe(dateSchedule, shiftId, role);
    }

    @Override
    public List<ScheduleDetail> getScheduleDetailsByTaiKhoan(User user) {
        return this.scheduleRepository.getScheduleDetailsByTaiKhoan(user);
    }

    @Override
    public List<Integer> getScheduleStatusByDatesAndShift(User user, List<Date> dates, int shiftId) {
        return this.scheduleRepository.getScheduleStatusByDatesAndShift(user, dates, shiftId);
    }

    @Override
    public boolean checktontai(Date fromDate, int roleId, int ca) {
        return this.scheduleRepository.checktontai(fromDate, roleId, ca);
    }

    @Override
    public List<Date> getScheduleofUser(User user, List<Date> dates, int idshift) {
        return this.scheduleRepository.getScheduleofUser(user, dates, idshift);
    }

    @Override
    public List<ScheduleDetail> getSchedulesofUser(User user, List<Date> dates) {
        return this.scheduleRepository.getSchedulesofUser(user, dates);
    }

    @Override
    public List<ScheduleDetail> getScheduleNowofUser(User user, List<Date> dates) {
        return this.scheduleRepository.getScheduleNowofUser(user, dates);
    }

    @Override
    public List<ScheduleDetail> getScheduleDetailsByTaiKhoanfordelete(User user) {
        return this.scheduleRepository.getScheduleDetailsByTaiKhoanfordelete(user);
    }

    @Override
    public List<ScheduleDetail> getShiftbyDayofDoctor(User doctor, Date date) {
        return this.scheduleRepository.getShiftbyDayofDoctor(doctor, date);
    }

    @Override
    public boolean addOrUpdateScheduleDetail(Map<String, String> params) {
        ScheduleDetail m = new ScheduleDetail();
        m.setStatus((short) 0);
        m.setUserId(this.userService.getUserById(Integer.parseInt(params.get("IdUser"))));

        List<Date> listDateCa1 = new ArrayList<>();
        List<Date> listDateCa2 = new ArrayList<>();
        List<Date> listDateCa3 = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateerro = new Date(102, 10, 16);
        try {
            Date thu2ca1 = dateFormat.parse(params.get("thu2ca1"));
            Date thu3ca1 = dateFormat.parse(params.get("thu3ca1"));
            Date thu4ca1 = dateFormat.parse(params.get("thu4ca1"));
            Date thu5ca1 = dateFormat.parse(params.get("thu5ca1"));
            Date thu6ca1 = dateFormat.parse(params.get("thu6ca1"));
            Date thu7ca1 = dateFormat.parse(params.get("thu7ca1"));
            Date thu8ca1 = dateFormat.parse(params.get("thu8ca1"));

            if (!thu2ca1.equals(dateerro)) {
                listDateCa1.add(thu2ca1);
            }
            if (!thu3ca1.equals(dateerro)) {
                listDateCa1.add(thu3ca1);
            }
            if (!thu4ca1.equals(dateerro)) {
                listDateCa1.add(thu4ca1);
            }
            if (!thu5ca1.equals(dateerro)) {
                listDateCa1.add(thu5ca1);
            }
            if (!thu6ca1.equals(dateerro)) {
                listDateCa1.add(thu6ca1);
            }
            if (!thu7ca1.equals(dateerro)) {
                listDateCa1.add(thu7ca1);
            }
            if (!thu8ca1.equals(dateerro)) {
                listDateCa1.add(thu8ca1);
            }

            Date thu2ca2 = dateFormat.parse(params.get("thu2ca2"));
            Date thu3ca2 = dateFormat.parse(params.get("thu3ca2"));
            Date thu4ca2 = dateFormat.parse(params.get("thu4ca2"));
            Date thu5ca2 = dateFormat.parse(params.get("thu5ca2"));
            Date thu6ca2 = dateFormat.parse(params.get("thu6ca2"));
            Date thu7ca2 = dateFormat.parse(params.get("thu7ca2"));
            Date thu8ca2 = dateFormat.parse(params.get("thu8ca2"));

            if (!thu2ca2.equals(dateerro)) {
                listDateCa2.add(thu2ca2);
            }
            if (!thu3ca2.equals(dateerro)) {
                listDateCa2.add(thu3ca2);
            }
            if (!thu4ca2.equals(dateerro)) {
                listDateCa2.add(thu4ca2);
            }
            if (!thu5ca2.equals(dateerro)) {
                listDateCa2.add(thu5ca2);
            }
            if (!thu6ca2.equals(dateerro)) {
                listDateCa2.add(thu6ca2);
            }
            if (!thu7ca2.equals(dateerro)) {
                listDateCa2.add(thu7ca2);
            }
            if (!thu8ca2.equals(dateerro)) {
                listDateCa2.add(thu8ca2);
            }

            Date thu2ca3 = dateFormat.parse(params.get("thu2ca3"));
            Date thu3ca3 = dateFormat.parse(params.get("thu3ca3"));
            Date thu4ca3 = dateFormat.parse(params.get("thu4ca3"));
            Date thu5ca3 = dateFormat.parse(params.get("thu5ca3"));
            Date thu6ca3 = dateFormat.parse(params.get("thu6ca3"));
            Date thu7ca3 = dateFormat.parse(params.get("thu7ca3"));
            Date thu8ca3 = dateFormat.parse(params.get("thu8ca3"));

            if (!thu2ca3.equals(dateerro)) {
                listDateCa3.add(thu2ca3);
            }
            if (!thu3ca3.equals(dateerro)) {
                listDateCa3.add(thu3ca3);
            }
            if (!thu4ca3.equals(dateerro)) {
                listDateCa3.add(thu4ca3);
            }
            if (!thu5ca3.equals(dateerro)) {
                listDateCa3.add(thu5ca3);
            }
            if (!thu6ca3.equals(dateerro)) {
                listDateCa3.add(thu6ca3);
            }
            if (!thu7ca3.equals(dateerro)) {
                listDateCa3.add(thu7ca3);
            }
            if (!thu8ca3.equals(dateerro)) {
                listDateCa3.add(thu8ca3);
            }

        } catch (ParseException ex) {
            Logger.getLogger(ScheduleServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        Date[] arrayDateCa1 = listDateCa1.toArray(new Date[listDateCa1.size()]);
        m.setListdate1(arrayDateCa1);

        Date[] arrayDateCa2 = listDateCa2.toArray(new Date[listDateCa2.size()]);
        m.setListdate2(arrayDateCa2);

        Date[] arrayDateCa3 = listDateCa3.toArray(new Date[listDateCa3.size()]);
        m.setListdate3(arrayDateCa3);
        
        return this.scheduleRepository.addOrUpdateScheduleDetail(m);

    }

}
