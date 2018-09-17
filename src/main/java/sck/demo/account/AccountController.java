package sck.demo.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sck.demo.account.repository.Account;
import sck.demo.account.service.OpenNewAccountService;

@RestController
public class AccountController {

    @Autowired
    private OpenNewAccountService service;

    @PostMapping("/account")
    public CreatedAccountResponse openNewAccount(@RequestBody NewAccountRequest newAccount) {
        // 1. Get Customer Information by ID
        // 2. Create new Account
        // 3. Send result to requester
        Account account = service.openNewAccountFlow(newAccount.getCustomerId());

        CreatedAccountResponse response = new CreatedAccountResponse();
        response.setId(account.getId());
        response.setAccountNo(account.getAcccountName());
        return response;
    }

}
