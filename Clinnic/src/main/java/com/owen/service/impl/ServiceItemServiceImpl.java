/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.service.impl;

import com.owen.pojo.ServiceItems;
import com.owen.repository.ServiceItemRepository;
import com.owen.service.ServiceItemService;
import com.owen.service.ServiceService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Trinh Bao Duy
 */
@Service
public class ServiceItemServiceImpl implements ServiceItemService {

    @Autowired
    private ServiceItemRepository serviceItemRepository;

    @Autowired
    private ServiceService ServiceService;

    @Override
    public boolean addOrUpdateServiceItem(ServiceItems m, int id) {
        return this.serviceItemRepository.addOrUpdateServiceItem(m, id);
    }

    @Override
    public List<ServiceItems> getServicecbyAppoID(int id) {
        return this.serviceItemRepository.getServicecbyAppoID(id);
    }

    @Override
    public boolean deleteServiceItems(int id) {
        return this.serviceItemRepository.deleteServiceItems(id);
    }

    @Override
    public boolean addServiceItems(Map<String, String> params) {
//        ServiceItems ser = new ServiceItems();
//        ser.setDateSer(new Date());
//        List<com.owen.pojo.Service> listdichvu = new ArrayList<>();
//
//        if (!params.get("dichvu1").equals("none")) {
//            listdichvu.add(this.ServiceService.getServicebyId(1));
//        }
//        if (!params.get("dichvu2").equals("none")) {
//            listdichvu.add(this.ServiceService.getServicebyId(2));
//        }
//        if (!params.get("dichvu3").equals("none")) {
//            listdichvu.add(this.ServiceService.getServicebyId(3));
//        }
//        if (!params.get("dichvu4").equals("none")) {
//            listdichvu.add(this.ServiceService.getServicebyId(4));
//        }

//        com.owen.pojo.Service[] listservice = listdichvu.toArray(new com.owen.pojo.Service[listdichvu.size()]);
//        ser.setListdichvu(listservice);
//        int idAppo = Integer.parseInt(params.get("IdAppo"));
//        return this.serviceItemRepository.addOrUpdateServiceItem(ser, idAppo);
        return false;
    }

}
