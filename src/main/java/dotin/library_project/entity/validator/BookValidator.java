package dotin.library_project.entity.validator;

import dotin.library_project.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookValidator implements Validator {
    public BookValidator() {
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Book.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Book book = (Book) target;
        if (book.getTitle()==null || book.getTitle().isEmpty())
            errors.rejectValue("title", "book.title.required");
    }

    public void validate(Object target, Errors errors, Object... validationHints) {
        Book book = (Book) target;
        if (validationHints.length > 0) {
            if (validationHints[0] == "create") {
                if (book.getTitle()==null || book.getTitle().isEmpty()) {
                    errors.rejectValue("title", "title.required","Title cannot be empty");
                }
//                if (book.getAge() < 18 || book.getAge() > 65) {
//                    errors.rejectValue("age", "book.age.outOfRange", new Object[]{18, 65}, "Age must be between 18 and 65");
//                }
            }
//            else if (validationHints[0] == "update") {
//                // Perform update-specific validation
//                if (StringUtils.isEmpty(book.getName()) && StringUtils.isEmpty(book.getEmail())) {
//                    errors.rejectValue("name", "name.or.email.required", "Name or email cannot be empty");
//                }
//            }
        } else {
            // Perform default validation
            if (book.getTitle().isEmpty()) {
                errors.rejectValue("title", "title.required");
            }

        }
    }
}
