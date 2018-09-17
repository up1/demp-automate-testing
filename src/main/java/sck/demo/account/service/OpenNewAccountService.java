package sck.demo.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sck.demo.account.repository.Account;
import sck.demo.account.repository.AccountRepository;
import sck.demo.account.repository.Customer;
import sck.demo.account.repository.CustomerRepository;

@Service
public class OpenNewAccountService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Account openNewAccountFlow(int customerId) {
        Customer currentCustomer = customerRepository.findAccountById(customerId);
        Account newAccount = new Account();
        newAccount.setAccountNo(String.format("%05d", customerId));
        newAccount.setAcccountName(currentCustomer.getFirstName() + " " + currentCustomer.getLastName());
        accountRepository.save(newAccount);
        return newAccount;
    }

}
