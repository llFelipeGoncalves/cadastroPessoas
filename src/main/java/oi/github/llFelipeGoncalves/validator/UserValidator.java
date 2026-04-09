package oi.github.llFelipeGoncalves.validator;

import oi.github.llFelipeGoncalves.exceptions.EmptyStorageException;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.models.UserModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class UserValidator {

    private UserValidator() {

    }

    public static void verifyModel(final UserModel model) throws ValidatorException {

        if (stringIsBlank(model.getName()))
            throw new ValidatorException("Informe um nome válido...");

        if (model.getName().length() <= 1 )
            throw new ValidatorException("nome deve ter mais de um caracter...");

        if (stringIsBlank(model.getEmail()))
            throw new ValidatorException("Informe um e-mail valido...");

        if ((!model.getEmail().contains("@")) || (!model.getEmail().contains(".")))
            throw new ValidatorException("Informe um e-mail valido...");

    }

    public static LocalDate parseAndValidateBirthday(String birthdayString) throws ValidatorException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(birthdayString, formatter);
        } catch (DateTimeParseException e) {
            throw new ValidatorException("Erro: O formato da data está incorreto. Use dd/MM/yyyy");
        }
    }

    public static void verifyStorage(List<UserModel> modelsList) {
        if (modelsList.isEmpty()) throw new EmptyStorageException("O armazenamento está vazio");
    }

    private static boolean stringIsBlank(final String value){
        return value == null || value.isBlank();
    }
}
