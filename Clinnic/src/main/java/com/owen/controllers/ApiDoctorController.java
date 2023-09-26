/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.controllers;

import com.owen.pojo.Rating;
import com.owen.pojo.User;
import com.owen.service.RatingService;
import com.owen.service.ScheduleService;
import com.owen.service.UserService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<List<Integer>> listshiftDoctor(@RequestParam Map<String, String> params) throws ParseException {
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

}
