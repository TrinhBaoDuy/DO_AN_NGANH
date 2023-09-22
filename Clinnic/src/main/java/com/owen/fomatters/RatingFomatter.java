/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.fomatters;

import com.owen.pojo.Rating;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Trinh Bao Duy
 */
public class RatingFomatter implements Formatter<Rating> {

    @Override
    public String print(Rating p, Locale locale) {
        return String.valueOf(p.getId());
    }

    @Override
    public Rating parse(String id, Locale locale) throws ParseException {
        return new Rating(Integer.parseInt(id));
    }
}
