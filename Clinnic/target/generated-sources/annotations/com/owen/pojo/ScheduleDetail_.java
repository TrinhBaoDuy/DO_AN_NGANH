package com.owen.pojo;

import com.owen.pojo.Shift;
import com.owen.pojo.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-10-21T07:48:56")
@StaticMetamodel(ScheduleDetail.class)
public class ScheduleDetail_ { 

    public static volatile SingularAttribute<ScheduleDetail, Date> dateSchedule;
    public static volatile SingularAttribute<ScheduleDetail, Shift> shiftId;
    public static volatile SingularAttribute<ScheduleDetail, Integer> id;
    public static volatile SingularAttribute<ScheduleDetail, User> userId;
    public static volatile SingularAttribute<ScheduleDetail, Short> status;

}