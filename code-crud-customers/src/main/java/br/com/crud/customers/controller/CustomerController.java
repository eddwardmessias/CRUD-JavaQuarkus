package br.com.crud.customers.controller;


import br.com.crud.customers.dto.CustomerDto;
import br.com.crud.customers.models.Customer;
import br.com.crud.customers.service.CustomerService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerController {

    @Inject
    CustomerService service;

    @GET
    public Response listCustomers(){
        List<Customer> customers = service.listCustomer();
        return  Response.ok(customers).build();
    }

    @POST
    public  Response saveCustomer(CustomerDto dto){

        Customer customer = service.saveCustomer(dto);

        return Response.ok(customer).status(201).build();

    }

    @PUT
    @Path("{id}")
    public Response updateCustomer(@PathParam("id") Long id, CustomerDto dto){
        service.updateCustomer(id, dto);

        return Response.status(204).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeCustomer(@PathParam("id") Long id){
        service.removeCustomer(id);

        return Response.status(204).build();
    }
}

