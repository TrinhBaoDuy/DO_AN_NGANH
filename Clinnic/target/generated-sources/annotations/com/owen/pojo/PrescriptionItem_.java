package com.owen.pojo;

import com.owen.pojo.Medicine;
import com.owen.pojo.Prescription;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-12T22:52:38")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-12T15:21:37")
>>>>>>> fe4a0e80b4e93dc18c29d1b8dd76a2a9609f818d
@StaticMetamodel(PrescriptionItem.class)
public class PrescriptionItem_ { 

    public static volatile SingularAttribute<PrescriptionItem, String> instructions;
    public static volatile SingularAttribute<PrescriptionItem, Prescription> prescriptionId;
    public static volatile SingularAttribute<PrescriptionItem, Integer> quantity;
    public static volatile SingularAttribute<PrescriptionItem, Medicine> medicineId;
    public static volatile SingularAttribute<PrescriptionItem, Integer> id;

}