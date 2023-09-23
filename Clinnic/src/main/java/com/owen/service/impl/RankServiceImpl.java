/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.service.impl;

import com.owen.pojo.Ranking;
import com.owen.repository.RankRepository;
import com.owen.service.RankService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Trinh Bao Duy
 */

@Service
public class RankServiceImpl implements RankService{
    
    @Autowired
    private RankRepository rankRepository;
    
    @Override
    public List<Ranking> getRanks() {
        return this.rankRepository.getRanks();
    }
    
}
