package sck.demo.account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import sck.demo.account.repository.Customer;
import sck.demo.account.repository.CustomerRepository;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void openNewAccountShouldSuccess() {
        // Create customer for test
        Customer customer = new Customer();
        customer.setFirstName("Somkiat");
        customer.setLastName("Puisungnoen");
        customer.setSalary(20000);
        customer.setAge(30);
        customer = customerRepository.save(customer);

        // Action
        NewAccountRequest request = new NewAccountRequest();
        request.setCustomerId(1);
        ResponseEntity<CreatedAccountResponse> response
                = testRestTemplate.postForEntity("/account", request, CreatedAccountResponse.class);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    public void openNewAccountShouldFailure() {
        // Action
        NewAccountRequest request = new NewAccountRequest();
        request.setCustomerId(2);
        ResponseEntity<CreatedAccountResponse> response
                = testRestTemplate.postForEntity("/account", request, CreatedAccountResponse.class);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());

    }
}