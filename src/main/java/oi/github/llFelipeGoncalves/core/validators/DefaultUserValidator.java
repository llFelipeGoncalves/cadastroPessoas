package oi.github.llFelipeGoncalves.core.validators;

import oi.github.llFelipeGoncalves.core.entities.User;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class DefaultUserValidator implements UserValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    @Override
    public void validate(User user) throws ValidatorException {
        if (user == null) {
            throw new ValidatorException("User cannot be null");
        }

        validateName(user.getName());
        validateEmail(user.getEmail());
        validateBirthday(user.getBirthday());
    }

    private void validateName(String name) throws ValidatorException {
        if (name == null || name.trim().isEmpty()) {
            throw new ValidatorException("Name cannot be null or empty");
        }
        if (name.length() < 2 || name.length() > 100) {
            throw new ValidatorException("Name must be between 2 and 100 characters");
        }
    }

    private void validateEmail(String email) throws ValidatorException {
        if (email == null || email.trim().isEmpty()) {
            throw new ValidatorException("Email cannot be null or empty");
        }
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new ValidatorException("Invalid email format");
        }
    }

    private void validateBirthday(LocalDate birthday) throws ValidatorException {
        if (birthday == null) {
            throw new ValidatorException("Birthday cannot be null");
        }
        if (birthday.isAfter(LocalDate.now())) {
            throw new ValidatorException("Birthday cannot be in the future");
        }
        LocalDate minDate = LocalDate.of(1900, 1, 1);
        if (birthday.isBefore(minDate)) {
            throw new ValidatorException("Birthday is too old");
        }
    }
}