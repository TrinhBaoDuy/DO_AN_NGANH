/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.fomatters;

import com.owen.pojo.Department;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author Trinh Bao Duy
 */
public class DepartmentFomatter implements Formatter<Department> {

   @Override
    public String print(Department p, Locale locale) {
        return String.valueOf(p.getId());
    }

    @Override
    public Department parse(String id, Locale locale) throws ParseException {
        return new Department(Integer.parseInt(id));
    }
    
}
