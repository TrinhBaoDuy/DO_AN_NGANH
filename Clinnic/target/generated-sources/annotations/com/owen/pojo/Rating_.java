package com.owen.pojo;

import com.owen.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-22T16:50:03")
@StaticMetamodel(Rating.class)
public class Rating_ { 

    public static volatile SingularAttribute<Rating, Date> ratingDate;
    public static volatile SingularAttribute<Rating, User> doctorId;
    public static volatile SingularAttribute<Rating, Integer> id;
    public static volatile SingularAttribute<Rating, User> sickpersonId;
    public static volatile SingularAttribute<Rating, String> value;
    public static volatile SingularAttribute<Rating, Integer> point;

}