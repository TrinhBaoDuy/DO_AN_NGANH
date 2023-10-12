/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.controllers;

import java.net.URI;
import static com.owen.controllers.NurseController.PAYPAL_CANCEL_URL;
import static com.owen.controllers.NurseController.PAYPAL_SUCCESS_URL;
import com.owen.dto.BillDTO;
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
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.springmvc.dto.momoclasses.Environment;
import com.springmvc.dto.momoclasses.PaymentResponse;
import com.springmvc.enums.RequestType;
import com.springmvc.momoprocessor.CreateOrderMoMo;
import com.springmvc.share.utils.LogUtils;
import com.springmvc.share.utils.URLUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
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

    @Autowired
    private PaymentService paymentService;

    public static final String PAYPAL_SUCCESS_URL = "pay/success";
    public static final String PAYPAL_CANCEL_URL = "pay/cancel";

    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping("/nurse/lichkham")
    public ResponseEntity<List<Appointment>> listlichkham(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.appointmentService.getAppointments(params), HttpStatus.OK);
    }

    @GetMapping("/nurse/lichkhamchuaxatnhan")
    public ResponseEntity<List<Appointment>> listlichkhamchuaxatnhan(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.appointmentService.getAppointmentsunfished(), HttpStatus.OK);
    }

    @GetMapping("/nurse/phieukham/{id}/bacsi")
    public ResponseEntity<List<User>> laybacsi(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.userService.getBacSi(id), HttpStatus.OK);
    }

    @PostMapping("/nurse/phieukham/{id}")
    public ResponseEntity<Boolean> thembacsi(@PathVariable(value = "id") int id, @RequestParam Map<String, String> params) throws MessagingException {
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
//                MimeMessage message = emailSender.createMimeMessage();
//                MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//                String nguoinhan = this.userService.getUserById(a.getSickpersonId().getId()).getEmaill();
//                String tennguoibenh = this.userService.getUserById(a.getSickpersonId().getId()).getName();
//                String tenbacsi = this.userService.getUserById(a.getDoctorId().getId()).getName();
//                System.err.println(nguoinhan);
//                helper.setTo(nguoinhan);
//                helper.setSubject("LỊCH HẸN PHÒNG MẠCH");
//
//                String content = "<html><body>"
//                        + "<p>Xin chào, " + tennguoibenh + "</p>"
//                        + "<p>Bạn có lịch hẹn khám tại phòng mạch PIXCEL vào ngày [" + ngaydikham + "]</p>"
//                        + "<p>Bác sĩ của bạn là " + tenbacsi + " .</p>"
//                        + "<p>Chúng tôi hân hạnh chào đón bạn.</p>"
//                        + "</body></html>";
//
//                helper.setText(content, true);
//
//                emailSender.send(message);
////                    model.addAttribute("successMessage", "Lịch hẹn đã được cập nhật và email đã được gửi thành công.");
                return new ResponseEntity<>(true, HttpStatus.OK);
            }

        }
        ////else
//        MimeMessage message = emailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
//        String nguoinhan = this.userService.getUserById(a.getSickpersonId().getId()).getEmaill();
//        String tennguoibenh = this.userService.getUserById(a.getSickpersonId().getId()).getName();
//        System.err.println(nguoinhan);
//        helper.setTo(nguoinhan);
//        helper.setSubject("LỊCH HẸN PHÒNG MẠCH");
//
//        String content = "<html><body>"
//                + "<p>Xin chào, " + tennguoibenh + "</p>"
//                + "<p>Bạn có lịch hẹn khám tại phòng mạch PIXCEL vào ngày [" + ngaydikham + "]</p>"
//                + "<p>Tuy nhiên , phòng mạch của chúng tôi đã đạt tối đa số lượng khách.</p>"
//                + "<p>Hi vọng bạn có thể chọn khám vào một ngày khác .Chúng tôi hân hạnh chào đón bạn.</p>"
//                + "</body></html>";
//
//        helper.setText(content, true);
//
//        emailSender.send(message);
//                model.addAttribute("errorMessage", "Không thể đặt lịch hẹn. Phòng mạch đã đạt tối đa số lượng khách.");
        return new ResponseEntity<>(false, HttpStatus.OK);

    }

    @GetMapping("/nurse/lichkhamcanthanhtoan")
    public ResponseEntity<List<Appointment>> listlichkhamcanthanhtoan() {
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
    
    @GetMapping("/nurse/tinhtien/{id}")
    public ResponseEntity<Integer> tinhtien(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.billService.tinhtien(this.billService.getBillByApoId(id)), HttpStatus.OK);
    }

    
    @GetMapping("/nurse/phieukham/{id}/hoadon")
    public ResponseEntity<BillDTO> hoadon(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.billService.getBillDTOByApoId(id), HttpStatus.OK);
    }

//    sb-a47l7c27634055@personal.example.com
//    p<O8gh!!
    @PostMapping("/nurse/thanhtoan")
    public ResponseEntity<?> xulithanhtoan(@RequestParam Map<String, String> params, HttpServletRequest request) throws MessagingException, Exception {
        Bill bill = this.billService.getBillByApoId(Integer.parseInt(params.get("idAppo")));
        com.owen.pojo.Payment p = this.paymentService.getPaymentbyID(Integer.parseInt(params.get("loaithanhtoan")));
        bill.setPayId(p);
        bill.setPayMoney(Integer.valueOf(params.get("tongtien")));
        if (this.billService.addOrUpdateBill(bill)) {
//            if (bill.getPayId().getId() == 1) {
//                return new ResponseEntity<>(true, HttpStatus.OK);
//            }
//            if (bill.getPayId().getId() == 2) {
//                LogUtils.init();
//                String requestId = String.valueOf(System.currentTimeMillis());
//                String orderId = String.valueOf(System.currentTimeMillis());
//                long amount = bill.getPayMoney();
//
//                String orderInfo = "Thanh toán hóa đơn";
//                String returnURL = "nurse/thanhtoan/" + bill.getId();
//                String notifyURL = "nurse/thanhtoan/" + bill.getId();
//                Environment environment = Environment.selectEnv("dev");
//                PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId, Long.toString(amount), orderInfo, returnURL, notifyURL, "", RequestType.CAPTURE_WALLET, Boolean.TRUE);
//                String url = captureWalletMoMoResponse.getPayUrl();
//                HttpHeaders headers = new HttpHeaders();
//                headers.setLocation(URI.create(url));
//
////                 Trả về chuyển hướng tới URL thanh toán
//                return new ResponseEntity<>(headers, HttpStatus.FOUND);
//            }
//            if (bill.getPayId().getId() == 3) {
//                String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
//                String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
//                Double amount = Double.valueOf(bill.getPayMoney());
//                double exchangeRate = 0.000043;
//                Double total = amount * exchangeRate;
//
//                try {
//                    Payment payment = this.paymentService.createPayment(
//                            total,
//                            "USD",
//                            "paypal",
//                            "sale",
//                            "payment description",
//                            cancelUrl,
//                            successUrl);
//                    for (Links links : payment.getLinks()) {
//                        if (links.getRel().equals("approval_url")) {
//                            HttpHeaders headers = new HttpHeaders();
//                            headers.setLocation(URI.create(links.getHref()));
//
//                            // Trả về chuyển hướng tới URL thanh toán
//                            return new ResponseEntity<>(headers, HttpStatus.OK);
//                        }
//                    }
//                } catch (PayPalRESTException e) {
//                    log.error(e.getMessage());
//                }
//                return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
//    }

        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/nurse/thanhtoan/{id}")
    public ResponseEntity<?> xulithanhtoan2(@PathVariable(value = "id") int id, HttpServletRequest request) throws MessagingException, Exception {
        Bill bill = this.billService.getBillByApoId(id);
        if (bill.getPayId().getId() == 1) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        if (bill.getPayId().getId() == 2) {
            LogUtils.init();
            String requestId = String.valueOf(System.currentTimeMillis());
            String orderId = String.valueOf(System.currentTimeMillis());
            long amount = bill.getPayMoney();

            String orderInfo = "Thanh toán hóa đơn";
            String returnURL = "nurse/thanhtoan/" + bill.getId();
            String notifyURL = "nurse/thanhtoan/" + bill.getId();
            Environment environment = Environment.selectEnv("dev");
            PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId, Long.toString(amount), orderInfo, returnURL, notifyURL, "", RequestType.CAPTURE_WALLET, Boolean.TRUE);
            String url = captureWalletMoMoResponse.getPayUrl();
            return new ResponseEntity<>(url, HttpStatus.OK);
//            HttpHeaders headers = new HttpHeaders();
//            headers.setLocation(URI.create(url));
//
////                 Trả về chuyển hướng tới URL thanh toán
//            return new ResponseEntity<>(headers, HttpStatus.FOUND);
        }
        if (bill.getPayId().getId() == 3) {
            String cancelUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_CANCEL_URL;
            String successUrl = URLUtils.getBaseURl(request) + "/" + PAYPAL_SUCCESS_URL;
            Double amount = Double.valueOf(bill.getPayMoney());
            double exchangeRate = 0.000043;
            Double total = amount * exchangeRate;

            try {
                Payment payment = this.paymentService.createPayment(
                        total,
                        "USD",
                        "paypal",
                        "sale",
                        "payment description",
                        cancelUrl,
                        successUrl);
                for (Links links : payment.getLinks()) {
                    if (links.getRel().equals("approval_url")) {
//                        HttpHeaders headers = new HttpHeaders();
//                        headers.setLocation(URI.create(links.getHref()));

                        // Trả về chuyển hướng tới URL thanh toán
                        return new ResponseEntity<>(links.getHref(), HttpStatus.OK);
                    }
                }
            } catch (PayPalRESTException e) {
                log.error(e.getMessage());
            }
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
}
