package sck.demo.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sck.demo.account.repository.Account;
import sck.demo.account.repository.AccountRepository;
import sck.demo.account.repository.Customer;
import sck.demo.account.repository.CustomerRepository;

@Service
public class OpenNewAccountService {

    private CustomerRepository customerRepository;
    private AccountRepository accountRepository;

    @Autowired
    public OpenNewAccountService(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    public Account openNewAccountFlow(int customerId) {
        Customer currentCustomer = customerRepository.findAccountById(customerId);
        if(currentCustomer != null) {
            Account newAccount = new Account();
            newAccount.setAccountNo(String.format("%05d", customerId));
            newAccount.setAcccountName(currentCustomer.getFirstName() + " " + currentCustomer.getLastName());
            newAccount = accountRepository.save(newAccount);
            return newAccount;
        }
        throw new RuntimeException(String.format("Customer id = %d not found", customerId));
    }

}
