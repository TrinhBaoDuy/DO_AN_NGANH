/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.service.impl;

import com.owen.pojo.Department;
import com.owen.repository.KhoaRepository;
import com.owen.service.KhoaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Trinh Bao Duy
 */
@Service
public class KhoaServiceImpl implements KhoaService{   

    @Autowired
    private KhoaRepository khoaRepository;
    
    @Override
    public List<Department> getKhoas() {
        return this.khoaRepository.getKhoas();
    }

}
