package contract;

import model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    void registerCustomer(Customer customer);

    Optional<Customer> findCustomerById(int id);

    void deleteCustomerById(int id);

    List<Customer> getAllCustomers();
}




