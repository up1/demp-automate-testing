package sck.demo.account.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void successWithCreateNewCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Somkiat");
        customer.setLastName("Puisungnoen");
        customer.setSalary(20000);
        customer.setAge(30);
        customerRepository.save(customer);

        assertEquals("# of customer must have 1", 1,customerRepository.count());
    }

    @Test
    public void successWithFindCustomerByID_with_valid_condition() {
        Customer customer = new Customer();
        customer.setFirstName("Somkiat");
        customer.setLastName("Puisungnoen");
        customer.setSalary(20000);
        customer.setAge(30);
        customer = customerRepository.save(customer);

        Customer foundAccount
                = customerRepository.findAccountById(customer.getId());

        assertNotNull(foundAccount);

    }

}