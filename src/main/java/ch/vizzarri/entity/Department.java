package ch.vizzarri.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
    @Id
    private String departmentCode;
    @OneToMany(mappedBy = "department")
    private List<Employee> employees = new ArrayList();
}
