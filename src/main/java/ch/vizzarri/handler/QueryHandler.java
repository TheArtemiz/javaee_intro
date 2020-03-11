package ch.vizzarri.handler;

import ch.vizzarri.entity.Address;
import ch.vizzarri.entity.Employee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collection;

@Stateless
public class QueryHandler implements Serializable {

    @PersistenceContext(unitName ="myUnit")
    private  EntityManager entityManager;

    public Collection<Employee> getEmployee(){
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }
    public Collection<Employee> getDeparmentEmployees(){
        return entityManager.createQuery("SELECT d.employees FROM Department d").getResultList();

    }

    public Address getEmployeeAddress(Employee e){
        return (Address)entityManager.createQuery("SELECT e.address FROM Employee e WHERE e = :employee").setParameter("employee",e).getSingleResult();
    }
    public Employee getEmployeeById(Long id){
        return (Employee) entityManager.createQuery("SELECT e from Employee e WHERE e.id = :id").setParameter("id",id).getSingleResult();
    }

    public void addNewEmployee(Employee employee){
        entityManager.persist(employee);
    }
}
