package com.owen.pojo;

import com.owen.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-22T16:50:03")
@StaticMetamodel(Rank.class)
public class Rank_ { 

    public static volatile SingularAttribute<Rank, Double> price;
    public static volatile SingularAttribute<Rank, String> name;
    public static volatile SingularAttribute<Rank, Integer> id;
    public static volatile SetAttribute<Rank, User> userSet;

}