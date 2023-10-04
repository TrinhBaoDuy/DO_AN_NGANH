/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.owen.service;

import com.owen.pojo.PrescriptionItem;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Trinh Bao Duy
 */
public interface PrescriptionItemService {
    boolean addOrUpdatePrescriptionItem(PrescriptionItem m, int id);
    boolean addPrescriptionItem(Map<String, String> params);
    List<PrescriptionItem> getPrescriptionsbyIDPres(int id);
    boolean deletePres(int id);
     List<PrescriptionItem> getPrescriptionsbyIDMedicine(int id);
}
