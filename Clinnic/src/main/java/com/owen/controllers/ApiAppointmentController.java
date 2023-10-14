/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.owen.pojo.Appointment;
import com.owen.pojo.Medicine;
import com.owen.pojo.Prescription;
import com.owen.pojo.PrescriptionItem;
import com.owen.pojo.User;
import com.owen.service.AppointmentService;
import com.owen.service.PrescriptionItemService;
import com.owen.service.PrescriptionService;
import com.owen.service.UserService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class ApiAppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PrescriptionService prescriptionService;
    
    @Autowired
    private PrescriptionItemService prescriptionItemService;
    
    @Autowired
    private UserService userService;

    @PostMapping("/appointments")
    @CrossOrigin
    public ResponseEntity<Appointment> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.appointmentService.dangkykham(params), HttpStatus.OK);
    }

    @GetMapping("/appointments")
    @CrossOrigin
    public ResponseEntity<List<Appointment>> listphieu() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User usercurrent = this.userService.getUserByUsername(userDetails.getUsername());
        return new ResponseEntity<>(this.appointmentService.getAppointmentsbySickperson(usercurrent.getId()), HttpStatus.OK);
    }

    @DeleteMapping("/appointments/{id}")
    @CrossOrigin
    public ResponseEntity<Boolean> deleteById(@PathVariable(value = "id") int id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User usercurrent = this.userService.getUserByUsername(userDetails.getUsername());
        Boolean res = this.appointmentService.deleteAppo(id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    
    
//    hàm này là hàm xuất file pdf truyền thằng id của appoment cái phiếu muốn xuất dô
    @GetMapping("/doctor/khambenh/kethuoc/export/{id}")
    public void exportPDF(HttpServletResponse response, @PathVariable(value = "id") int id) {
        // Lấy thông tin và dữ liệu cần thiết từ dịch vụ và nguồn dữ liệu của bạn
        Appointment a = this.appointmentService.getAppointmentById(id);
        String tenBenhnhan = a.getSickpersonId().getName();
        String tenBacsi = a.getDoctorId().getName();
        int idPre = a.getPrescriptionId().getId();
        Prescription p = this.prescriptionService.getPrescriptionById(idPre);
        String chuanDoan = p.getSymptom();
        List<PrescriptionItem> thuoc = this.prescriptionItemService.getPrescriptionsbyIDPres(idPre);

        try {
            // Tạo một đối tượng Document
            Document document = new Document();

            // Tạo một đối tượng PdfWriter để ghi dữ liệu vào tài liệu PDF
            PdfWriter.getInstance(document, response.getOutputStream());

            // Thiết lập tên tệp PDF đầu ra
            response.setHeader("Content-Disposition", "attachment; filename=\"Donthuoc.pdf\"");

            // Mở tài liệu
            document.open();

            // Tạo và định dạng các phần tử trong tài liệu
            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font contentFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL);
//             BaseFont unicodeFont = BaseFont.createFont("path/to/unicode/font.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//            Font unicodeContentFont = new Font(unicodeFont, 12, Font.NORMAL);

            // Tiêu đề
            Paragraph title = new Paragraph("PHONG MACH PISCEL", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Thông tin bệnh nhân
            Paragraph patientInfo = new Paragraph("Benh nhan: " + tenBenhnhan, headerFont);
            document.add(patientInfo);

            // Thông tin bác sĩ
            Paragraph doctorInfo = new Paragraph("Bac si: " + tenBacsi, headerFont);
            document.add(doctorInfo);

            // Chẩn đoán
            Paragraph diagnosis = new Paragraph("Chuan doan: " + chuanDoan, headerFont);
            document.add(diagnosis);

            // Danh sách thuốc
            Paragraph prescriptionHeading = new Paragraph("Danh sach thuoc:", headerFont);
            document.add(prescriptionHeading);

            for (PrescriptionItem item : thuoc) {
                String tenThuoc = item.getMedicineId().getName();
                String huongDan = item.getInstructions();
                Paragraph medication = new Paragraph("- " + tenThuoc + ": " + huongDan, contentFont);
                document.add(medication);
            }

            // Đóng tài liệu
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
