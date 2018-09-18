package sck.demo.account.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import sck.demo.account.repository.Account;
import sck.demo.account.repository.AccountRepository;
import sck.demo.account.repository.Customer;
import sck.demo.account.repository.CustomerRepository;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class OpenNewAccountServiceTest {

    private OpenNewAccountService service;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private AccountRepository accountRepository;


    @Before
    public void initial()  {
        initMocks(this);
        service = new OpenNewAccountService(customerRepository, accountRepository);
    }

    @Test
    public void openNewAccountFlowShouldSuccess() {
        // Stub customer
        Customer dummyCustomer = new Customer();
        dummyCustomer.setId(1);
        given(customerRepository.findAccountById(1)).willReturn(dummyCustomer);

        // Stub account
        Account dummyAccount = new Account();
        dummyAccount.setAccountNo(String.format("%05d", 1));
        dummyAccount.setAcccountName(dummyCustomer.getFirstName() + " " + dummyCustomer.getLastName());
        given(accountRepository.save(dummyAccount)).willReturn(dummyAccount);

        // Action
        Account actualAccount = service.openNewAccountFlow(1);

        // Assert
        assertEquals("00001", actualAccount.getAccountNo());

    }

    @Test(expected = RuntimeException.class)
    public void openNewAccountFlowShouldFailure() {
        // Stub customer not found
        given(customerRepository.findAccountById(2)).willThrow(RuntimeException.class);

        // Action
        Account actualAccount = service.openNewAccountFlow(2);

    }
}