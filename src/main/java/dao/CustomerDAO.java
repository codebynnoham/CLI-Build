package dao;

import model.Booking;
import model.Customer;

import java.util.Arrays;
import java.util.Optional;

public class CustomerDAO {
    private Customer[] customerDB;
    private int index;

    public CustomerDAO(int initialCapacity) {
        this.customerDB = new Customer[Math.max(initialCapacity, 1)];
        this.index = 0;
    }

    public void addCustomer(Customer customer) {
        if (index == customerDB.length)
            resize();
        customerDB[index++] = customer;
    }

    private void resize() {
        customerDB = Arrays.copyOf(customerDB, customerDB.length * 2);
    }

    public Customer[] getAllCustomers() {
        return Arrays.copyOf(customerDB, index);
    }

    public Optional<Customer> findByCustomerId(int customerId) {
        for (int i = 0; i < index; i++) {
            Customer customer = customerDB[i];
            if (customer.getCustomerId() == customerId)
                return Optional.of(customer);
        }
        return Optional.empty();
    }

    public boolean removeCustomerById(int customerId) {
        for (int i = 0; i < index; i++) {
            Customer customer = customerDB[i];
            if (customer.getCustomerId() == customerId) {
                for (int j = i; j < index - 1; j++) {
                    customerDB[j] = customerDB[j + 1];
                }
                customerDB[index - 1] = null;
                index--;
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return index;
    }
}


