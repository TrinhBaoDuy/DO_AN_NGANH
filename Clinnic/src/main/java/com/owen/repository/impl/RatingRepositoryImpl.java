/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.repository.impl;

import com.owen.pojo.Appointment;
import com.owen.pojo.Rating;
import com.owen.repository.RatingRepository;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class RatingRepositoryImpl implements RatingRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public boolean addOrUpdateRating(Rating m) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (m.getId() == null) {
                s.save(m);
            } else {
                s.update(m);
            }
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRating(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        Rating r = session.get(Rating.class, id);
        try {
            session.delete(r);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Rating> getRatingsByIdDoctor(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Rating> query = builder.createQuery(Rating.class);
        Root<Rating> root = query.from(Rating.class);
        query.select(root);
        Join<Rating, Appointment> phieuKhamJoin = root.join("phieukhamId");
        Predicate doctorIdPredicate = builder.equal(phieuKhamJoin.get("doctorId"), id);
        query.where(doctorIdPredicate);
        TypedQuery<Rating> typedQuery = session.createQuery(query);
        return typedQuery.getResultList();
    }

    @Override
    public List<Rating> getRatingsByIdSickPerson(int id) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Rating> query = builder.createQuery(Rating.class);
        Root<Rating> root = query.from(Rating.class);
        query.select(root);

        Join<Rating, Appointment> phieuKhamJoin = root.join("phieukhamId");
        Predicate doctorIdPredicate = builder.equal(phieuKhamJoin.get("sickpersonId"), id);

        query.where(doctorIdPredicate);

        TypedQuery<Rating> typedQuery = session.createQuery(query);
        return typedQuery.getResultList();
    }

}
