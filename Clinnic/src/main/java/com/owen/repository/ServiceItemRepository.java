/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.owen.repository;

import com.owen.pojo.ServiceItems;
import java.util.List;

/**
 *
 * @author Trinh Bao Duy
 */
public interface ServiceItemRepository {
    boolean addOrUpdateServiceItem(ServiceItems m,int id);
    List<ServiceItems> getServicecbyAppoID(int id);
    boolean deleteServiceItems(int id);
}
