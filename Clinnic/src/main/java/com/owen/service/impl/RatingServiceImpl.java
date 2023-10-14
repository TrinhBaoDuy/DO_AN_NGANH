/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.service.impl;

import com.owen.pojo.Rating;
import com.owen.repository.AppointmentRepository;
import com.owen.repository.RatingRepository;
import com.owen.service.RatingService;
import com.owen.service.UserService;
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
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepository RatingRepository;
    
    @Autowired
    private UserService UserService;
    
    @Autowired
    private AppointmentRepository apoo;
    
    @Override
    public List<Rating> getRatingsByIdDoctor(int id) {
       return this.RatingRepository.getRatingsByIdDoctor(id);
    }

    @Override
    public List<Rating> getRatingsByIdSickPerson(int id) {
       return this.RatingRepository.getRatingsByIdSickPerson(id);
    }

    @Override
    public boolean addOrUpdateRating(Map<String, String> params) {
        Rating m = new Rating();
        m.setPhieukhamId(this.apoo.getAppointmentById(Integer.parseInt(params.get("phieukhamId"))));
//        m.setDoctorId(UserService.getUserById(Integer.parseInt(params.get("IdDoctor"))));
//        m.setSickpersonId(UserService.getUserById(Integer.parseInt(params.get("IdBenhNhan"))));
        m.setPoint(Integer.valueOf(params.get("point")));
        m.setValue(params.get("comment"));
        m.setRatingDate(new Date());
        return this.RatingRepository.addOrUpdateRating(m);
    }

    @Override
    public boolean deleteRating(int id) {
        return this.RatingRepository.deleteRating(id);
    }
    
}
