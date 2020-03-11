package ch.vizzarri.entity;

import org.hibernate.validator.constraints.NotEmpty;


import javax.annotation.ManagedBean;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message= "First name cannot be empty !")
    @Size(max = 40, message = "First name must be less than 40 charaters")
    private String first_name;

    @NotNull(message= "Last name cannot be empty !")
    @Size(max = 40, message = "Last name must be less than 40 charaters")
    private String last_name;

    @NotNull(message= "Age cannot be null !")
    private int age;

    @DecimalMin(value = "500", message = "Salary must be at least 500")
    private BigDecimal salary;

    @OneToOne
    @MapKey(name="EMP_ID")
    private Employee manager;

    @ManyToOne
    private Department department;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Embedded
    private Address address;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

