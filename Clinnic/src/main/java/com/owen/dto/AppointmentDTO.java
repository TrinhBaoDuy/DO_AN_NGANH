/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.dto;

import com.owen.pojo.Prescription;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Trinh Bao Duy
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDTO {
    private Integer id;
    private Date appointmentDate;
    private Short status;
    private Date medicalappointmentDate;
    private Prescription prescriptionId;
    private UserDTO doctorId;
    private UserDTO nurseId;
    private UserDTO sickpersonId;

}
