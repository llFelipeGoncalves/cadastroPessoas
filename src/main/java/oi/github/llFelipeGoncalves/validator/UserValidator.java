package oi.github.llFelipeGoncalves.validator;

import oi.github.llFelipeGoncalves.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.models.UserModel;

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

    private static boolean stringIsBlank(final String value){
        return value == null || value.isBlank();
    }
}
