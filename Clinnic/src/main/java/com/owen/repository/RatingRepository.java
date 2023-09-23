/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.owen.repository;

import com.owen.pojo.Rating;
import java.util.List;

/**
 *
 * @author Trinh Bao Duy
 */
public interface RatingRepository {
    List<Rating> getRatingsByIdDoctor(int id);
    List<Rating> getRatingsByIdSickPerson(int id);
    boolean addOrUpdateRating(Rating m);
    boolean deleteRating(int id);

}
