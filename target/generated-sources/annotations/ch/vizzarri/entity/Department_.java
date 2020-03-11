package ch.vizzarri.entity;

import ch.vizzarri.entity.Employee;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190322-rNA", date="2020-03-09T14:00:20")
@StaticMetamodel(Department.class)
public class Department_ { 

    public static volatile SingularAttribute<Department, String> departmentCode;
    public static volatile ListAttribute<Department, Employee> employees;

}