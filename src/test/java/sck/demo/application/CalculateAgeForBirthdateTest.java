package sck.demo.application;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CalculateAgeForBirthdateTest {

    @Test
    public void calculateAge_10_with_input_10_03_2000() {
        LocalDate mockCurrent = LocalDate.of(2010, 3, 10);
        NewValidationRule rule = new NewValidationRule();
        int actual = rule.calculateAge(mockCurrent, "10/03/2000");
        assertEquals(10, actual);
    }
}