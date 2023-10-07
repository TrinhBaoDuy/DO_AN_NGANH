package com.owen.pojo;

import com.owen.pojo.Appointment;
import com.owen.pojo.Payment;
import com.owen.pojo.Tienkham;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-07T22:24:37")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-06T12:16:08")
>>>>>>> 6fdf97e48d080183cfa827029995e3766e3f4336
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, Integer> payMoney;
    public static volatile SingularAttribute<Bill, Tienkham> tienkham;
    public static volatile SingularAttribute<Bill, Integer> id;
    public static volatile SingularAttribute<Bill, Payment> payId;
    public static volatile SingularAttribute<Bill, Appointment> appoId;

}