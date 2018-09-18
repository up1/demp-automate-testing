package sck.demo.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewValidateController {

    @PostMapping("/api/application/new/validate")
    public ResponseEntity<SuccessResponse>
          validate(@RequestBody ApplicationRequest request) {

        SuccessResponse response = new SuccessResponse();
        response.setResponseCode("S1212312121");
        response.setResult("Success");

        return new ResponseEntity<SuccessResponse>(response, HttpStatus.OK);
    }

}
