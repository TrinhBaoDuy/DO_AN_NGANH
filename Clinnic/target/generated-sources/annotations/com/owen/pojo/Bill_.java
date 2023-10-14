package com.owen.pojo;

import com.owen.pojo.Appointment;
import com.owen.pojo.Payment;
import com.owen.pojo.Tienkham;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-12T22:52:38")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-12T15:21:37")
>>>>>>> fe4a0e80b4e93dc18c29d1b8dd76a2a9609f818d
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, Integer> payMoney;
    public static volatile SingularAttribute<Bill, Tienkham> tienkham;
    public static volatile SingularAttribute<Bill, Integer> id;
    public static volatile SingularAttribute<Bill, Payment> payId;
    public static volatile SingularAttribute<Bill, Appointment> appoId;

}