package sck.demo.account;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @PostMapping("/account")
    public CreatedAccountResponse openNewAccount(@RequestBody NewAccountRequest newAccount) {
        // 1. Get Customer Information by ID
        // 2. Check customer with business rules for open new account
        // 3. Send result to requester
        return new CreatedAccountResponse();
    }

}
