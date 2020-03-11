package ch.vizzarri.handler;

import ch.vizzarri.entity.Employee;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PersistenceService {
    @PersistenceContext(unitName ="myUnit")
    EntityManager entityManager;

    @Inject
    QueryHandler queryHandler;

    public void saveEmployee(Employee employee) {
        entityManager.persist(employee);
    }
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

}
