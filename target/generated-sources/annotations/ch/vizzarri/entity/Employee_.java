package ch.vizzarri.entity;

import ch.vizzarri.entity.Address;
import ch.vizzarri.entity.Department;
import ch.vizzarri.entity.Employee;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190322-rNA", date="2020-03-11T11:32:11")
@StaticMetamodel(Employee.class)
public class Employee_ { 

    public static volatile SingularAttribute<Employee, Address> address;
    public static volatile SingularAttribute<Employee, Employee> manager;
    public static volatile SingularAttribute<Employee, String> last_name;
    public static volatile SingularAttribute<Employee, Long> id;
    public static volatile SingularAttribute<Employee, BigDecimal> salary;
    public static volatile SingularAttribute<Employee, Department> department;
    public static volatile SingularAttribute<Employee, String> first_name;
    public static volatile SingularAttribute<Employee, Integer> age;

}