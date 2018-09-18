package sck.demo.application;

import org.junit.Test;

import static org.junit.Assert.*;

public class NewValidationRuleTest {

    @Test
    public void validate_age_more_than_18_expect_pass() {
        NewValidationRule rule = new NewValidationRule();
        ApplicationRequest request = new ApplicationRequest();
        request.setIncome(25000);
        request.setBirthDate("10/03/2000");
        boolean result = rule.process(request);

        // Assert
        assertTrue(result);
    }

    @Test
    public void validate_income_12000_expect_not_pass() {
        NewValidationRule rule = new NewValidationRule();
        ApplicationRequest request = new ApplicationRequest();
        request.setIncome(12000);
        boolean result = rule.process(request);

        // Assert
        assertFalse(result);
    }

    @Test
    public void validate_income_25000_expect_pass() {
        NewValidationRule rule = new NewValidationRule();
        ApplicationRequest request = new ApplicationRequest();
        request.setIncome(25000);
        request.setBirthDate("10/03/2000");
        boolean result = rule.process(request);

        // Assert
        assertTrue(result);
    }

}