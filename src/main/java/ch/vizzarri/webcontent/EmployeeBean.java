package ch.vizzarri.webcontent;

import ch.vizzarri.entity.Employee;
import ch.vizzarri.handler.QueryHandler;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.ApplicationPath;
import java.util.ArrayList;
import java.util.List;

@Named(value = "employeeBean")
public class EmployeeBean {
    private List<Employee> listEmployees;
    @Inject
    private QueryHandler queryHandler;

    public List<Employee> getListEmployees(){
        if(listEmployees == null || listEmployees.size()== 0) this.setListEmployees((List<Employee>)queryHandler.getEmployee());

        return listEmployees;
    }
    public void setListEmployees(List<Employee> employees){
            this.listEmployees = new ArrayList<>(employees);
    }


}
