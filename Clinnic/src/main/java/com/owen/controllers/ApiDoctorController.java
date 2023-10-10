
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.controllers;

import com.owen.dto.AppointmentDTO;
import com.owen.dto.UserDTO;
import com.owen.pojo.Appointment;
import com.owen.pojo.Prescription;
import com.owen.pojo.Rating;
import com.owen.pojo.ScheduleDetail;
import com.owen.pojo.ServiceItems;
import com.owen.pojo.User;
import com.owen.service.AppointmentService;
import com.owen.service.BillService;
import com.owen.service.PrescriptionService;
import com.owen.service.RatingService;
import com.owen.service.ScheduleService;
import com.owen.service.ServiceItemService;
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

    @Autowired
    private PrescriptionService prescriptionService;

    @Autowired
    private ServiceItemService ServiceItemService;
    
    @Autowired
    private BillService billService;

    @GetMapping("/doctors")
    public ResponseEntity<List<User>> listdoctor(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.userService.getBacSi(params), HttpStatus.OK);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<?> doctor(@PathVariable(value = "id") int id) {
        UserDTO dto = this.userService.getUserDtoById(id);
        return new ResponseEntity<>(dto == null ? new ResponseEntity("false", HttpStatus.BAD_REQUEST) : dto, HttpStatus.OK);
    }

    @GetMapping("/doctor/{id}/rating")
    public ResponseEntity<List<Rating>> listdoctorRating(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.RatingService.getRatingsByIdDoctor(id), HttpStatus.OK);
    }

    @PostMapping("/doctor/rating")
    public ResponseEntity<Boolean> listdoctorRating(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.RatingService.addOrUpdateRating(params), HttpStatus.OK);
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

    @GetMapping("/doctor/khambenh/{id}/phieukham")
    public ResponseEntity<AppointmentDTO> phieukham(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.appointmentService.getAppointmentDTOById(id), HttpStatus.OK);
    }

    @GetMapping("/doctor/khambenh/{id}/phieubenh")
    public ResponseEntity<Prescription> phieubenh(@PathVariable(value = "id") int id, @RequestParam Map<String, String> params) {
        Appointment m = this.appointmentService.getAppointmentById(id);
        int idPre = m.getPrescriptionId().getId();
        return new ResponseEntity<>(this.prescriptionService.getPrescriptionById(idPre), HttpStatus.OK);
    }

    public LocalDateTime getCurrentDateTime() {
        return LocalDateTime.now();
    }

    @PostMapping("/doctor/khambenh")
    public ResponseEntity<Boolean> khambenh(@RequestParam Map<String, String> params) {
        if (this.prescriptionService.updatePrescription(params) == true && this.ServiceItemService.addServiceItems(params) == true) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }
    
    @PostMapping("/doctor/taohoadon")
    public ResponseEntity<Boolean> taohoadon(@RequestParam Map<String, String> params) {
        if (this.billService.addOrUpdateBill(params) == true) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

//    hàm này là để xem lịch sử bị bênh của bênh nhan truyền vào id thằng bệnh nhân
//    http://localhost:8080/Clinnic/api/doctor/lichsukham/6?date=2023-08-10
//    http://localhost:8080/Clinnic/api/doctor/lichsukham/6?date=null nhưng mà hk biết sao test null nó đang lỗi đang muốn d=chạy debug để check coi sao nó hk đc nhưng ma fhk chạyddc
    @GetMapping("/doctor/lichsukham/{id}")
    public ResponseEntity<List<Appointment>> lichsukhambenh(@PathVariable(value = "id") int id, @RequestParam Map<String, String> params) throws ParseException {
        String date = params.get("date");
        List<Appointment> lich = null;
        if (date != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date ngaykham = dateFormat.parse(date);
            lich = this.appointmentService.getAppointmentsbyUser(this.userService.getUserById(id), ngaykham);
        } else {
            lich = this.appointmentService.getAppointmentsbyUser(this.userService.getUserById(id), null);
        }
        return new ResponseEntity<>(lich, HttpStatus.OK);
    }
    



}
