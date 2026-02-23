package service;

import contract.ICustomerService;
import dao.CustomerDAO;
import model.Customer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CustomerService implements ICustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void registerCustomer(Customer customer) {
        Objects.requireNonNull(customer, "customer must not be null");
        if (customerDAO.findByCustomerId(customer.getCustomerId()).isPresent())
            throw new IllegalArgumentException("customer with id " + customer.getCustomerId() + " already exists");
        customerDAO.addCustomer(customer);
    }

    @Override
    public Optional<Customer> findCustomerById(int id) {
        return customerDAO.findByCustomerId(id);
    }

    @Override
    public void deleteCustomerById(int id) {
        if (!customerDAO.removeCustomerById(id))
            throw new IllegalArgumentException("customer with id " + id + " not found");
    }

    @Override
    public List<Customer> getAllCustomers() {
        return List.copyOf(Arrays.asList(customerDAO.getAllCustomers()));
    }
}

