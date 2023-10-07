package com.owen.pojo;

import com.owen.pojo.Bill;
import com.owen.pojo.Prescription;
import com.owen.pojo.ServiceItems;
import com.owen.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-07T22:24:37")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-06T12:16:08")
>>>>>>> 6fdf97e48d080183cfa827029995e3766e3f4336
@StaticMetamodel(Appointment.class)
public class Appointment_ { 

    public static volatile SetAttribute<Appointment, ServiceItems> serviceItemsSet;
    public static volatile SingularAttribute<Appointment, Prescription> prescriptionId;
    public static volatile SingularAttribute<Appointment, User> doctorId;
    public static volatile SetAttribute<Appointment, Bill> billSet;
    public static volatile SingularAttribute<Appointment, User> nurseId;
    public static volatile SingularAttribute<Appointment, Date> medicalappointmentDate;
    public static volatile SingularAttribute<Appointment, Integer> id;
    public static volatile SingularAttribute<Appointment, User> sickpersonId;
    public static volatile SingularAttribute<Appointment, Date> appointmentDate;
    public static volatile SingularAttribute<Appointment, Short> status;

}