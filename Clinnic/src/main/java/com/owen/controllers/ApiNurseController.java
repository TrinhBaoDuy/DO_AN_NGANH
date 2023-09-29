/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.controllers;

import com.owen.pojo.Appointment;
import com.owen.pojo.Bill;
import com.owen.pojo.Medicine;
import com.owen.pojo.Prescription;
import com.owen.pojo.PrescriptionItem;
import com.owen.pojo.ScheduleDetail;
import com.owen.pojo.ServiceItems;
import com.owen.pojo.User;
import com.owen.service.AppointmentService;
import com.owen.service.BillService;
import com.owen.service.PaymentService;
import com.owen.service.PrescriptionItemService;
import com.owen.service.ScheduleService;
import com.owen.service.ServiceItemService;
import com.owen.service.UserService;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
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
public class ApiNurseController {

    @Autowired
    private CustomDateEditor customDateEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, customDateEditor);
    }

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private UserService userService;

    @Autowired
    private PrescriptionItemService prescriptionItemService;

    @Autowired
    private ServiceItemService serviceItemService;

    @Autowired
    private BillService billService;



    @GetMapping("/nurse/lichkham")
    public ResponseEntity<List<Appointment>> listlichkham(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.appointmentService.getAppointments(params), HttpStatus.OK);
    }

    @GetMapping("/nurse/lichkhamchuaxatnhan")
    public ResponseEntity<List<Appointment>> listlichkhamchuaxatnhan(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.appointmentService.getAppointmentsunfished(), HttpStatus.OK);
    }

    @GetMapping("/nurse/lichlamhientai")
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
        return new ResponseEntity<>(this.scheduleService.getScheduleNowofUser(usercurrent, dateListnow), HttpStatus.OK);
    }

    @GetMapping("/nurse/lichlamhdangky")
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
        return new ResponseEntity<>(this.scheduleService.getSchedulesofUser(usercurrent, dateList), HttpStatus.OK);
    }

    @GetMapping("/nurse/lichkhamcanthanhtoan")
    public ResponseEntity<List<Appointment>> listlichkhamcanthanhtoan(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.appointmentService.getAppointmentcantPay(), HttpStatus.OK);
    }

    @GetMapping("/nurse/phieukham/{id}/thuoc")
    public ResponseEntity<List<PrescriptionItem>> listthuoccanthanhtoan(@PathVariable(value = "id") int id) {
        Appointment a = this.appointmentService.getAppointmentById(id);
        int idPre = a.getPrescriptionId().getId();
        return new ResponseEntity<>( this.prescriptionItemService.getPrescriptionsbyIDPres(idPre), HttpStatus.OK);
    }

    @GetMapping("/nurse/tongtiencuaphieukham/{id}")
    public ResponseEntity<Integer> listlichkhamcanthanhtoan(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.billService.tinhtien(this.billService.getBillByApoId(id)), HttpStatus.OK);
    }
    
    @GetMapping("/nurse/phieukham/{id}/dichvu")
    public ResponseEntity<List<ServiceItems>> listdichvucanthanhtoan(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>( this.serviceItemService.getServicecbyAppoID(id), HttpStatus.OK);
    }
    
    @GetMapping("/nurse/phieukham/{id}/hoadon")
    public ResponseEntity<Bill> hoadon(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>( this.billService.getBillByApoId(id), HttpStatus.OK);
    }
    

}
