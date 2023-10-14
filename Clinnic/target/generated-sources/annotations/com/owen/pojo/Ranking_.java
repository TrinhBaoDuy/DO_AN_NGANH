package com.owen.pojo;

import com.owen.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-12T22:52:38")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-12T15:21:37")
>>>>>>> fe4a0e80b4e93dc18c29d1b8dd76a2a9609f818d
@StaticMetamodel(Ranking.class)
public class Ranking_ { 

    public static volatile SingularAttribute<Ranking, Double> price;
    public static volatile SingularAttribute<Ranking, String> name;
    public static volatile SingularAttribute<Ranking, Integer> id;
    public static volatile SetAttribute<Ranking, User> userSet;

}