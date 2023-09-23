/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.service.impl;

import com.owen.pojo.Rating;
import com.owen.repository.RatingRepository;
import com.owen.service.RatingService;
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
    
    @Override
    public List<Rating> getRatingsByIdDoctor(Map<String, String> params) {
       int id = Integer.parseInt(params.get("IdDoctor"));
       return this.RatingRepository.getRatingsByIdDoctor(id);
    }

    @Override
    public List<Rating> getRatingsByIdSickPerson(Map<String, String> params) {
       int id = Integer.parseInt(params.get("IdBenhNhan"));
       return this.RatingRepository.getRatingsByIdSickPerson(id);
    }

    @Override
    public boolean addOrUpdateRating(Rating m) {
        return this.RatingRepository.addOrUpdateRating(m);
    }

    @Override
    public boolean deleteRating(int id) {
        return this.RatingRepository.deleteRating(id);
    }
    
}
