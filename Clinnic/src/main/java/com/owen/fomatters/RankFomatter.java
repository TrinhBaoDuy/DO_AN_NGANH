/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.fomatters;

import com.owen.pojo.Rank;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Trinh Bao Duy
 */
public class RankFomatter implements Formatter<Rank> {

    @Override
    public String print(Rank p, Locale locale) {
        return String.valueOf(p.getId());
    }

    @Override
    public Rank parse(String id, Locale locale) throws ParseException {
        return new Rank(Integer.parseInt(id));
    }
}
