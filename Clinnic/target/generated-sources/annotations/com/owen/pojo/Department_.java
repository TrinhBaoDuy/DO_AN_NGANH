package com.owen.pojo;

import com.owen.pojo.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2023-09-26T12:34:50")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile SingularAttribute<Department, String> name;
    public static volatile SingularAttribute<Department, Integer> id;
    public static volatile SingularAttribute<Department, String> describe;
    public static volatile SetAttribute<Department, User> userSet;

}