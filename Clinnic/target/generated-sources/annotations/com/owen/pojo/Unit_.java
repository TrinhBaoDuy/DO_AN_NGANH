package com.owen.pojo;

import com.owen.pojo.Medicine;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-07T22:24:37")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-06T12:16:08")
>>>>>>> 6fdf97e48d080183cfa827029995e3766e3f4336
@StaticMetamodel(Unit.class)
public class Unit_ { 

    public static volatile SingularAttribute<Unit, String> name;
    public static volatile SingularAttribute<Unit, Integer> id;
    public static volatile SetAttribute<Unit, Medicine> medicineSet;

}