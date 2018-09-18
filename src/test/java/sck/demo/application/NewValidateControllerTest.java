package sck.demo.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NewValidateControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void validateSuccess() {
        ApplicationRequest request = new ApplicationRequest();
        request.setFirstName("ชนนิกานต์");
        ResponseEntity<SuccessResponse> response = testRestTemplate
                .postForEntity("/api/application/new/validate",
                        request, SuccessResponse.class);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        SuccessResponse expected = new SuccessResponse();
        expected.setResponseCode("S1212312121");
        expected.setResult("Success");
        assertEquals(expected, response.getBody());

    }
}