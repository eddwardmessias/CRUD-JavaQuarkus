package br.com.crud.customers.service;

import br.com.crud.customers.dto.CustomerDto;
import br.com.crud.customers.models.Customer;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class CustomerService {

    public List<Customer> listCustomer(){
        return Customer.listAll();
    }

    @Transactional
    public Customer saveCustomer(CustomerDto dto){

        Customer customer = new Customer();


        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setAge(dto.getAge());

        return customer;


    }
    @Transactional
    public void updateCustomer(Long id, CustomerDto dto){

        Customer customer = new Customer();

        Optional<Customer> customerOp = Customer.findByIdOptional(id);

        if(customerOp.isEmpty()){
            throw new NullPointerException("Customer not found");
        }

        customer = customerOp.get();

        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setAge(dto.getAge());

        customer.persist();
    }

    @Transactional
    public void removeCustomer(Long id){

        Optional<Customer> customerOp = Customer.findByIdOptional(id);

        if(customerOp.isEmpty()){
            throw new NullPointerException("Customer not found");
        }

        Customer customer = customerOp.get();

        customer.delete();


    }

}
