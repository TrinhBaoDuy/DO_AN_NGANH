package com.owen.pojo;

import com.owen.pojo.Shift;
import com.owen.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-12T22:52:38")
=======
@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-12T15:21:37")
>>>>>>> fe4a0e80b4e93dc18c29d1b8dd76a2a9609f818d
@StaticMetamodel(ScheduleDetail.class)
public class ScheduleDetail_ { 

    public static volatile SingularAttribute<ScheduleDetail, Date> dateSchedule;
    public static volatile SingularAttribute<ScheduleDetail, Shift> shiftId;
    public static volatile SingularAttribute<ScheduleDetail, Integer> id;
    public static volatile SingularAttribute<ScheduleDetail, User> userId;
    public static volatile SingularAttribute<ScheduleDetail, Short> status;

}