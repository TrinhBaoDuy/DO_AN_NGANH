/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.service.impl;

import com.owen.pojo.Medicine;
import com.owen.pojo.PrescriptionItem;
import com.owen.repository.PrescriptionItemRepository;
import com.owen.service.MedicineService;
import com.owen.service.PrescriptionItemService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Trinh Bao Duy
 */
@Service
public class PrescriptionItemServiceImpl implements PrescriptionItemService {
    
    @Autowired
    private PrescriptionItemRepository prescriptionItemRepository;
    
    @Autowired
    private MedicineService medicineService;
    
    @Override
    public boolean addOrUpdatePrescriptionItem(PrescriptionItem m, int id) {
        return this.prescriptionItemRepository.addOrUpdatePrescriptionItem(m,id);
    }
    
    @Override
    public List<PrescriptionItem> getPrescriptionsbyIDPres(int id) {
        return this.prescriptionItemRepository.getPrescriptionsbyIDPres(id);
    }

    @Override
    public boolean deletePres(int id) {
        return this.prescriptionItemRepository.deletePres(id);
    }

    @Override
    public List<PrescriptionItem> getPrescriptionsbyIDMedicine(int id) {
        return this.prescriptionItemRepository.getPrescriptionsbyIDMedicine(id);
    }

    @Override
    public boolean addPrescriptionItem(Map<String, String> params) {
        PrescriptionItem pres = new PrescriptionItem();
        Medicine thuoc = this.medicineService.getMedicineById(Integer.parseInt(params.get("idThuoc")));
        pres.setInstructions(params.get("huongdansudung"));
        pres.setQuantity(Integer.parseInt(params.get("soluongthuoc"))); 
        pres.setMedicineId(thuoc);
        int idAppo = Integer.parseInt(params.get("idAppo"));
        return this.prescriptionItemRepository.addOrUpdatePrescriptionItem(pres, idAppo);
    }

}
