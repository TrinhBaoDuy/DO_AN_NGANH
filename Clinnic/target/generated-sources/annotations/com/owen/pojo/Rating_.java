package com.owen.pojo;

import com.owen.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-07T22:24:37")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-06T12:16:08")
>>>>>>> 6fdf97e48d080183cfa827029995e3766e3f4336
@StaticMetamodel(Rating.class)
public class Rating_ { 

    public static volatile SingularAttribute<Rating, Date> ratingDate;
    public static volatile SingularAttribute<Rating, User> doctorId;
    public static volatile SingularAttribute<Rating, Integer> id;
    public static volatile SingularAttribute<Rating, User> sickpersonId;
    public static volatile SingularAttribute<Rating, String> value;
    public static volatile SingularAttribute<Rating, Integer> point;

}