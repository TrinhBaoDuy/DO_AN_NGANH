/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.controllers;

import com.owen.pojo.Payment;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.owen.pojo.ScheduleDetail;
import com.owen.pojo.User;
import com.owen.service.ScheduleService;
import com.owen.service.UserService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
public class ApiScheduleDetailController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private UserService userService;

    @PostMapping("/dangkylichlam")
    public ResponseEntity<Boolean> handlePostRequest(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.scheduleService.addOrUpdateScheduleDetail(params), HttpStatus.OK);

    }
    
    //////đây là lịch làm của tuần hiện tại ở ca 1 dùng để đem ra so sánh để khi có thì không cho check nữa
    @GetMapping("/lichlamdangkyca1")
    public ResponseEntity<List<Date>> listlichlamca1(@RequestParam Map<String, String> params) {
        List<Date> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // Đặt ngày là thứ Hai
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        dateList.add(calendar.getTime()); // Thêm ngày thứ Hai gần nhất vào danh sách
        for (int i = 0; i < 6; i++) { // Thêm các ngày từ thứ Ba đến Chủ nhật
            calendar.add(Calendar.DAY_OF_WEEK, 1);
            dateList.add(calendar.getTime());
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User usercurrent = this.userService.getUserByUsername(userDetails.getUsername());
//        User usercurrent = this.userService.getUserByUsername("doctor1");
        return new ResponseEntity<>(this.scheduleService.getScheduleofUser(usercurrent, dateList, 1), HttpStatus.OK);
    }
    
    @GetMapping("/lichlamdangkyca3")
    public ResponseEntity<List<Date>> listlichlamca3(@RequestParam Map<String, String> params) {
        List<Date> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // Đặt ngày là thứ Hai
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        dateList.add(calendar.getTime()); // Thêm ngày thứ Hai gần nhất vào danh sách
        for (int i = 0; i < 6; i++) { // Thêm các ngày từ thứ Ba đến Chủ nhật
            calendar.add(Calendar.DAY_OF_WEEK, 1);
            dateList.add(calendar.getTime());
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User usercurrent = this.userService.getUserByUsername(userDetails.getUsername());
//        User usercurrent = this.userService.getUserByUsername("doctor1");
        return new ResponseEntity<>(this.scheduleService.getScheduleofUser(usercurrent, dateList, 3), HttpStatus.OK);
    }
    
    @GetMapping("/lichlamdangkyca2")
    public ResponseEntity<List<Date>> listlichlamca2(@RequestParam Map<String, String> params) {
        List<Date> dateList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // Đặt ngày là thứ Hai
        calendar.add(Calendar.WEEK_OF_YEAR, 1);
        dateList.add(calendar.getTime()); // Thêm ngày thứ Hai gần nhất vào danh sách
        for (int i = 0; i < 6; i++) { // Thêm các ngày từ thứ Ba đến Chủ nhật
            calendar.add(Calendar.DAY_OF_WEEK, 1);
            dateList.add(calendar.getTime());
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User usercurrent = this.userService.getUserByUsername(userDetails.getUsername());
//        User usercurrent = this.userService.getUserByUsername("doctor1");
        return new ResponseEntity<>(this.scheduleService.getScheduleofUser(usercurrent, dateList, 2), HttpStatus.OK);
    }
    

    @GetMapping("/lichlamhientai")
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

    @GetMapping("/lichlamhdangky")
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
    
    @GetMapping("/xacnhanlich/{id}/{date}/{idRole}/{idCa}")
    public ResponseEntity<Boolean> checklichlam(@PathVariable(value = "id") int id,@PathVariable(value = "date") Date date,@PathVariable(value = "idRole") int idRole,@PathVariable(value = "idCa") int idCa
    ) {
         ScheduleDetail s = this.scheduleService.getScheduleDetailById(id);
        if (this.scheduleService.checkLichHopLe(date, idCa, idRole) == true) {
            if (this.scheduleService.addOrUpdateScheduleDetail(s) == true) {
               return new ResponseEntity<>(true, HttpStatus.OK);
            }return new ResponseEntity<>(false, HttpStatus.OK);
        } 
        return new ResponseEntity<>(false, HttpStatus.OK);
    }
    
    ////truyền id cái lịch dô á
    @GetMapping("/xemlichlam/huy/{id}")
    public ResponseEntity<Boolean> xoalichlamcuanhanvien(@PathVariable(value = "id")int id) {
         return new ResponseEntity<>(this.scheduleService.deleteScheduleDetail(id), HttpStatus.OK);
    }
    
    @GetMapping("/lichlamhientai/{id}")
    public ResponseEntity<List<ScheduleDetail>> listlichlamcuadoituonbyid(@PathVariable(value = "id")int id) {
        List<Date> dateListnow = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // Đặt ngày là thứ Hai của tuần hiện tại
        for (int i = 0; i < 7; i++) { // Thêm các ngày từ thứ Hai đến Chủ nhật
            dateListnow.add(calendar.getTime());
            calendar.add(Calendar.DAY_OF_WEEK, 1);
        }
        User usercurrent = this.userService.getUserById(id);
        return new ResponseEntity<>(this.scheduleService.getScheduleNowofUser(usercurrent, dateListnow), HttpStatus.OK);
    }
}
