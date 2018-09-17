package sck.demo.account.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private  AccountRepository accountRepository;

    @Test
    public void createNewAccountWithValidCustomer() {
        // Create customer
        Customer customer = new Customer();
        customer.setFirstName("Somkiat");
        customer.setLastName("Puisungnoen");
        customer.setSalary(20000);
        customer.setAge(30);
        customerRepository.save(customer);

        // Create Account
        Account account = new Account();
        account.setOwner(customer);
        account.setAccountNo("0000001");
        account.setAcccountName("Account 01");
        accountRepository.save(account);

        // Assert
        assertEquals("# of account = 1", 1, accountRepository.count());
    }

    @Test
    public void createNewTwoAccountWithValidCustomer() {
        // Create customer
        Customer customer = new Customer();
        customer.setFirstName("Somkiat");
        customer.setLastName("Puisungnoen");
        customer.setSalary(20000);
        customer.setAge(30);
        customerRepository.save(customer);

        // Create 2 Accounts
        Account firstAccount = new Account();
        firstAccount.setOwner(customer);
        firstAccount.setAccountNo("0000001");
        firstAccount.setAcccountName("Account 01");
        Account secondAccount = new Account();
        secondAccount.setOwner(customer);
        secondAccount.setAccountNo("0000002");
        secondAccount.setAcccountName("Account 02");
        accountRepository.save(firstAccount);
        accountRepository.save(secondAccount);

        // Assert
        assertEquals("# of account = 2", 2, accountRepository.count());
    }

}