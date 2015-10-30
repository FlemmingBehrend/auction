package dk.topdanmark.registration.entity;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class UserFactory {

    @Inject
    Validator validator;

    Email email;

    String name;

    DateOfBirth dateOfBirth;

    public UserFactory withEmail(String emailAddress) {
        this.email = new Email(emailAddress);
        validate(this.email);
        return this;
    }

    public UserFactory withName(String name) {
        this.name = name;
        return this;
    }

    public UserFactory withDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = new DateOfBirth(dateOfBirth);
        validate(this.dateOfBirth);
        return this;
    }

    public User build() {
        User user = new User(name, email);
        if (dateOfBirth != null) {
            user.setDateOfBirth(this.dateOfBirth);
        }
        validate(user);
        return user;
    }

    private void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (violations.isEmpty())
            return;
        throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
    }

}