/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.dto;

import com.owen.pojo.Department;
import com.owen.pojo.Ranking;
import com.owen.pojo.Role;
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
public class UserDTO {

    private Integer id;
    private String username;
    private String password;
    private String avatar;
    private String name;
    private String phone;
    private String address;
    private String emaill;
    private Date dod;
    private String sex;
    private Role roleId;
    private Department khoaId;
    private Ranking rankId;
}
