package spring.copany.study.MVC2.web.jov;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ItemValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Item.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Item item = (Item) target;

    }
}
