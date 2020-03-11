package ch.vizzarri.ressources;

import ch.vizzarri.entity.Employee;
import ch.vizzarri.handler.QueryHandler;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Collection;

@Path("employee")
@Produces("application/json")
@Consumes("application/json")
public class EmployeeResource {
    @Inject
    QueryHandler queryHandler;

    @Context
    private UriInfo uriInfo;

    @GET
    @Path("getAllEmployee")
    public Response getAllEmployee(){
        return Response.ok(queryHandler.getEmployee()).status(Response.Status.FOUND).build();
    }

    @GET
    @Path("getEmployeeById/{id: \\d+}")
    public Response getEmployeeById(@PathParam("id") @DefaultValue("0") Long id){
        return Response.ok(queryHandler.getEmployeeById(id)).status(Response.Status.FOUND).build();
    }

   // @GET
   // @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   //@Path("findEmployeeById") //?id=27 /id?id=95
    //public Response findEmployeeById(@FormParam("id") @DefaultValue("0") Long id) {
    //   return Response.ok(queryHandler.getEmployeeById(id)).status(Response.Status.FOUND).build();

    //}


    @POST
    @Path("new")
    public Response addNewEmployee(@Valid Employee employee){
        queryHandler.addNewEmployee(employee);
        URI uri = uriInfo.getAbsolutePathBuilder().path(employee.getId().toString()).build();
        return Response.created(uri).status(Response.Status.CREATED).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("map")
    public Response addNewEmployee(MultivaluedMap<String, String> formMap){
        String firstname = formMap.getFirst("firstname");
        String lastname = formMap.getFirst("lastname");
        int age = Integer.parseInt(formMap.getFirst("age"));
        BigDecimal salary = new BigDecimal(formMap.getFirst("salary"));

        Employee newEmp = new Employee();
        newEmp.setAge(age);
        newEmp.setFirst_name(firstname);
        newEmp.setLast_name(lastname);
        newEmp.setSalary(salary);

       return addNewEmployee(newEmp);
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("form")
    public Response addNewEmployee(@FormParam("firstname") String firstname, @FormParam("lastname") String lastname,@FormParam("age") int age, @FormParam("salary") BigDecimal salary, @HeaderParam("Referer") String referer) {
        Employee newEmp = new Employee();
        newEmp.setAge(age);
        newEmp.setFirst_name(firstname);
        newEmp.setLast_name(lastname);
        newEmp.setSalary(salary);


        return addNewEmployee(newEmp);

    }


}
