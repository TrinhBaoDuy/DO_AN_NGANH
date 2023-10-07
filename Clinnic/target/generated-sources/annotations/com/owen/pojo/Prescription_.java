package com.owen.pojo;

import com.owen.pojo.Appointment;
import com.owen.pojo.PrescriptionItem;
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
@StaticMetamodel(Prescription.class)
public class Prescription_ { 

    public static volatile SingularAttribute<Prescription, String> conclusion;
    public static volatile SetAttribute<Prescription, Appointment> appointmentSet;
    public static volatile SingularAttribute<Prescription, String> symptom;
    public static volatile SingularAttribute<Prescription, Date> prescriptionDate;
    public static volatile SingularAttribute<Prescription, Integer> id;
    public static volatile SetAttribute<Prescription, PrescriptionItem> prescriptionItemSet;
    public static volatile SingularAttribute<Prescription, String> prescriptioncol;

}