package oi.github.llFelipeGoncalves.core.validators;

import oi.github.llFelipeGoncalves.core.entities.User;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;

import java.time.LocalDate;
import java.util.regex.Pattern;

public interface UserValidator {
    void validate(User user) throws ValidatorException;
}