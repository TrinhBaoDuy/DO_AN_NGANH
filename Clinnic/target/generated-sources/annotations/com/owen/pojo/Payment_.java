package com.owen.pojo;

import com.owen.pojo.Bill;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-07T22:24:37")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-06T12:16:08")
>>>>>>> 6fdf97e48d080183cfa827029995e3766e3f4336
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SetAttribute<Payment, Bill> billSet;
    public static volatile SingularAttribute<Payment, String> paymentMethod;
    public static volatile SingularAttribute<Payment, Integer> id;

}