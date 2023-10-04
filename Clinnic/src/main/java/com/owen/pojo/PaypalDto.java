/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.pojo;

import lombok.*;
import lombok.ToString;

/**
 *
 * @author Trinh Bao Duy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaypalDto {

    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
}
