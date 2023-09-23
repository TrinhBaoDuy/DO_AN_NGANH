/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.repository.impl;

import com.owen.pojo.Ranking;
import com.owen.repository.RankRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Trinh Bao Duy
 */
@Repository
@Transactional
public class RankRepositoryImpl implements RankRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Override
    public List<Ranking> getRanks() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Ranking");

        return q.getResultList();
    }
    
}
