/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.dto;


import com.owen.pojo.Payment;
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
public class BillDTO {
    private Integer id;
    private Integer payMoney;
    private AppointmentDTO appoId;
    private Payment payId;
}
