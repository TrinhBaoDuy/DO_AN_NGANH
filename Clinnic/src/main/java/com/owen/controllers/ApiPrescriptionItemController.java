/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.controllers;

import com.owen.pojo.Medicine;
import com.owen.pojo.PrescriptionItem;
import com.owen.pojo.User;
import com.owen.service.MedicineService;
import com.owen.service.PrescriptionItemService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Trinh Bao Duy
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiPrescriptionItemController {
    
    @Autowired
    private PrescriptionItemService prescriptionItemService;
    
    @Autowired
    private  MedicineService medicineService;
    
    @DeleteMapping("/doctor/khambenh/kethuoc/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Model model, @PathVariable(value = "id") int id) {
        this.prescriptionItemService.deletePres(id);
    }
    
    
    ////nay là hàm show ra mấy cái thuốc mà cái thằng đó uống id ở đây là id của cái Prescription á nha 
//    ví dụ http://localhost:8080/Clinnic/api/doctor/phieubenh/35/kethuoc
    @GetMapping("/doctor/phieubenh/{id}/kethuoc")
    public ResponseEntity<List<PrescriptionItem>> listchitietthuoc(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.prescriptionItemService.getPrescriptionsbyIDPres(id), HttpStatus.OK);
    }
    
    
    //////////hàm này là hàm kê thuỐC thì param t cần m chuyển qua là (idThuoc , huongdansudung,soluongthuoc,idAppo )
    
    @PostMapping("/doctor/phieubenh/kethuoc")
    public ResponseEntity<Boolean> napchitietthuoc(@RequestParam Map<String, String> params) {
        if (this.prescriptionItemService.addPrescriptionItem(params)== true) {
                    Medicine medicine = this.medicineService.getMedicineById(Integer.parseInt(params.get("idThuoc")));
                    int soluongthuoc = medicine.getQuantity();
                    int soluongban = Integer.parseInt(params.get("soluongthuoc"));
                    int soluongupdate = soluongthuoc - soluongban;
                    medicine.setQuantity(soluongupdate);
                    this.medicineService.addOrUpdateMedicine(medicine);
                    return new ResponseEntity<>(true, HttpStatus.OK);
                }
        return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
    }
    
    
    
    
    
            
            
}
