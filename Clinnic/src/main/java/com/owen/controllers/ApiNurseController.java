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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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

    @Autowired
    private JavaMailSender emailSender;

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

    @GetMapping("/nurse/phieukham/{id}/bacsi")
    public ResponseEntity<List<User>> laybacsi(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.userService.getBacSi(id), HttpStatus.OK);
    }

    
    @PostMapping("/nurse/phieukham/{id}")
    public ResponseEntity<Boolean> thembacsi(@PathVariable(value = "id") int id,@RequestParam Map<String, String> params) throws MessagingException {
        Appointment a = this.appointmentService.getAppointmentById(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User usercurrent = this.userService.getUserByUsername(userDetails.getUsername());
        a.setDoctorId(this.userService.getUserById(Integer.parseInt(params.get("IdDoctor"))));
        a.setNurseId(usercurrent);
        Date ngaykham = a.getAppointmentDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String ngaydikham = dateFormat.format(a.getAppointmentDate());
        if (this.appointmentService.canAcceptAppointment(ngaykham) == true) {
            if (this.appointmentService.addOrUpdateAppointment(a) == true) {
                MimeMessage message = emailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
                String nguoinhan = this.userService.getUserById(a.getSickpersonId().getId()).getEmaill();
                String tennguoibenh = this.userService.getUserById(a.getSickpersonId().getId()).getName();
                String tenbacsi = this.userService.getUserById(a.getDoctorId().getId()).getName();
                System.err.println(nguoinhan);
                helper.setTo(nguoinhan);
                helper.setSubject("LỊCH HẸN PHÒNG MẠCH");

                String content = "<html><body>"
                        + "<p>Xin chào, " + tennguoibenh + "</p>"
                        + "<p>Bạn có lịch hẹn khám tại phòng mạch PIXCEL vào ngày [" + ngaydikham + "]</p>"
                        + "<p>Bác sĩ của bạn là " + tenbacsi + " .</p>"
                        + "<p>Chúng tôi hân hạnh chào đón bạn.</p>"
                        + "</body></html>";

                helper.setText(content, true);

                emailSender.send(message);
//                    model.addAttribute("successMessage", "Lịch hẹn đã được cập nhật và email đã được gửi thành công.");
                return new ResponseEntity<>(true, HttpStatus.OK);
            }

        }
        ////else
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        String nguoinhan = this.userService.getUserById(a.getSickpersonId().getId()).getEmaill();
        String tennguoibenh = this.userService.getUserById(a.getSickpersonId().getId()).getName();
        System.err.println(nguoinhan);
        helper.setTo(nguoinhan);
        helper.setSubject("LỊCH HẸN PHÒNG MẠCH");

        String content = "<html><body>"
                + "<p>Xin chào, " + tennguoibenh + "</p>"
                + "<p>Bạn có lịch hẹn khám tại phòng mạch PIXCEL vào ngày [" + ngaydikham + "]</p>"
                + "<p>Tuy nhiên , phòng mạch của chúng tôi đã đạt tối đa số lượng khách.</p>"
                + "<p>Hi vọng bạn có thể chọn khám vào một ngày khác .Chúng tôi hân hạnh chào đón bạn.</p>"
                + "</body></html>";

        helper.setText(content, true);

        emailSender.send(message);
//                model.addAttribute("errorMessage", "Không thể đặt lịch hẹn. Phòng mạch đã đạt tối đa số lượng khách.");
        return new ResponseEntity<>(false, HttpStatus.OK);

    }

    @GetMapping("/nurse/lichkhamcanthanhtoan")
    public ResponseEntity<List<Appointment>> listlichkhamcanthanhtoan(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.appointmentService.getAppointmentcantPay(), HttpStatus.OK);
    }

    @GetMapping("/nurse/phieukham/{id}/thuoc")
    public ResponseEntity<List<PrescriptionItem>> listthuoccanthanhtoan(@PathVariable(value = "id") int id) {
        Appointment a = this.appointmentService.getAppointmentById(id);
        int idPre = a.getPrescriptionId().getId();
        return new ResponseEntity<>(this.prescriptionItemService.getPrescriptionsbyIDPres(idPre), HttpStatus.OK);
    }

    @GetMapping("/nurse/tongtiencuaphieukham/{id}")
    public ResponseEntity<Integer> listlichkhamcanthanhtoan(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.billService.tinhtien(this.billService.getBillByApoId(id)), HttpStatus.OK);
    }

    @GetMapping("/nurse/phieukham/{id}/dichvu")
    public ResponseEntity<List<ServiceItems>> listdichvucanthanhtoan(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.serviceItemService.getServicecbyAppoID(id), HttpStatus.OK);
    }

    @GetMapping("/nurse/phieukham/{id}/hoadon")
    public ResponseEntity<Bill> hoadon(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.billService.getBillByApoId(id), HttpStatus.OK);
    }

}
