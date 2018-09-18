package sck.demo.application;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class NewValidationRule {

    public static final int MINIMUM_INCOME = 15000;

    public boolean process(ApplicationRequest request) {
        if(รายได้ต้องมากกว่า15000(request)) {
            int age = calculateAge(LocalDate.now(), request.getBirthDate());
            if(age >= 18) {
                return true;
            }
        }
        return false;
    }

    public int calculateAge(LocalDate current, String birthDate) {
        String[] data = birthDate.split("/");
        LocalDate bd = LocalDate.of(
                Integer.parseInt(data[2]),
                Integer.parseInt(data[1]),
                Integer.parseInt(data[0])
        );
        Period period = Period.between(bd, current);
        return period.getYears();
    }

    private boolean รายได้ต้องมากกว่า15000(ApplicationRequest request) {
        return request.getIncome() >= MINIMUM_INCOME;
    }

}
