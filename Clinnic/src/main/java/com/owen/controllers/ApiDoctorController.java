
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.controllers;

import com.owen.pojo.Appointment;
import com.owen.pojo.Prescription;
import com.owen.pojo.Rating;
import com.owen.pojo.ScheduleDetail;
import com.owen.pojo.ServiceItems;
import com.owen.pojo.User;
import com.owen.service.AppointmentService;
import com.owen.service.RatingService;
import com.owen.service.ScheduleService;
import com.owen.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Trinh Bao Duy
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiDoctorController {

    @Autowired
    private UserService userService;

    @Autowired
    private RatingService RatingService;

    @Autowired
    private ScheduleService ScheduleService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping("/doctors")
    public ResponseEntity<List<User>> listdoctor(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.userService.getBacSi(params), HttpStatus.OK);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<User> doctor(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/doctor/{id}/rating")
    public ResponseEntity<List<Rating>> listdoctorRating(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.RatingService.getRatingsByIdDoctor(id), HttpStatus.OK);
    }

    @PostMapping("/doctor/rating")
    public ResponseEntity<Boolean> listdoctorRating(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.RatingService.addOrUpdateRating(params), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/doctor/shift")
    public ResponseEntity<List<ScheduleDetail>> listshiftDoctor(@RequestParam Map<String, String> params) throws ParseException {
        int id = Integer.parseInt(params.get("IdDoctor"));
        User doctor = this.userService.getUserById(id);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(params.get("date"));
        return new ResponseEntity<>(this.ScheduleService.getShiftbyDayofDoctor(doctor, date), HttpStatus.OK);
    }

    @GetMapping("/doctor/department")
    public ResponseEntity<List<User>> listDoctorbydepartment(@RequestParam Map<String, String> params) throws ParseException {
        int id = Integer.parseInt(params.get("IdKhoa"));
        return new ResponseEntity<>(this.userService.getDoctorbyDepartment(id), HttpStatus.OK);
    }

    @GetMapping("/doctor/lichkham")
    public ResponseEntity<List<Appointment>> lichkham() throws ParseException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User usercurrent = this.userService.getUserByUsername(userDetails.getUsername());
        return new ResponseEntity<>(this.appointmentService.getAppointmentsbyDoctor(usercurrent), HttpStatus.OK);
    }

    @GetMapping("/doctor/khambenh/{id}")
    public ResponseEntity<Appointment> phieukham(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.appointmentService.getAppointmentById(id), HttpStatus.OK);
    }

    @GetMapping("/doctor/lichlamhientai")
    public ResponseEntity<List<ScheduleDetail>> listlichlam(@RequestParam Map<String, String> params) {
        List<Date> dateListnow = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // Đặt ngày là thứ Hai của tuần hiện tại

        for (int i = 0; i < 7; i++) { // Thêm các ngày từ thứ Hai đến Chủ nhật
            dateListnow.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_WEEK, 1);
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User usercurrent = this.userService.getUserByUsername(userDetails.getUsername());
//        User usercurrent = this.userService.getUserByUsername("doctor1");
        return new ResponseEntity<>(this.scheduleService.getScheduleNowofUser(usercurrent, dateListnow), HttpStatus.OK);
    }

    @GetMapping("/doctor/lichlamhdangky")
    public ResponseEntity<List<ScheduleDetail>> listlichlamdangky(@RequestParam Map<String, String> params) {
        List<Date> dateList = new ArrayList<>();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // Đặt ngày là thứ Hai
        calendar2.add(Calendar.WEEK_OF_YEAR, 1);
        dateList.add(calendar2.getTime()); // Thêm ngày thứ Hai gần nhất vào danh sách
        for (int i = 0; i < 6; i++) { // Thêm các ngày từ thứ Ba đến Chủ nhật
            calendar2.add(Calendar.DAY_OF_WEEK, 1);
            dateList.add(calendar2.getTime());
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User usercurrent = this.userService.getUserByUsername(userDetails.getUsername());
//        User usercurrent = this.userService.getUserByUsername("doctor1");
        return new ResponseEntity<>(this.scheduleService.getSchedulesofUser(usercurrent, dateList), HttpStatus.OK);
    }
    
    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }
    
    //////////tiep tuc lam kham benh nhung chua biet cach truyen theo list
    @PostMapping("/doctor/khambenh/{id}")
    public ResponseEntity<Appointment> khambenh(@PathVariable(value = "id") int id,@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.appointmentService.getAppointmentById(id), HttpStatus.OK);
    }
    

}
