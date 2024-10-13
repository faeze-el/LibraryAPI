package dotin.library_project.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.time.LocalDate;

public class DateComparisonValidator implements ConstraintValidator<DateAfter, Object> {
    private String startDateField;
    private String endDateField;

    @Override
    public void initialize(DateAfter constraintAnnotation) {
        this.startDateField = constraintAnnotation.startDate();
        this.endDateField = constraintAnnotation.endDate();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            Field startField = value.getClass().getDeclaredField(startDateField);
            Field endField = value.getClass().getDeclaredField(endDateField);

            startField.setAccessible(true);
            endField.setAccessible(true);

            LocalDate startDate = (LocalDate) startField.get(value);
            LocalDate endDate = (LocalDate) endField.get(value);

            if (startDate == null || endDate == null) {
                return true; // Allow null values
            }

            return endDate.isAfter(startDate); // End date must be after start date

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
