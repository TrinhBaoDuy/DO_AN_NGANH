package com.owen.pojo;

import com.owen.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-27T12:34:24")
@StaticMetamodel(Ranking.class)
public class Ranking_ { 

    public static volatile SingularAttribute<Ranking, Double> price;
    public static volatile SingularAttribute<Ranking, String> name;
    public static volatile SingularAttribute<Ranking, Integer> id;
    public static volatile SetAttribute<Ranking, User> userSet;

}