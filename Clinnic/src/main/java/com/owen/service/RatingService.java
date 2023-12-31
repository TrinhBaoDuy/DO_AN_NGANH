/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.owen.service;

import com.owen.pojo.Rating;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Trinh Bao Duy
 */
public interface RatingService {
    List<Rating> getRatingsByIdDoctor(int id);
    List<Rating> getRatingsByIdSickPerson(int id);
    boolean addOrUpdateRating(Map<String, String> params);
    boolean deleteRating(int id);
}
