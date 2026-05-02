package oi.github.llFelipeGoncalves;

import oi.github.llFelipeGoncalves.dao.UserDAO;
import oi.github.llFelipeGoncalves.exceptions.EmptyStorageException;
import oi.github.llFelipeGoncalves.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.models.MenuOptions;
import oi.github.llFelipeGoncalves.models.UserModel;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import static oi.github.llFelipeGoncalves.validator.UserValidator.parseAndValidateBirthday;
import static oi.github.llFelipeGoncalves.validator.UserValidator.verifyModel;

public class Main {
    private static final UserDAO dao = new UserDAO();
    private static final Scanner scanner = new Scanner(System.in);

     public static void main(String[] args) {

        while (true) {
            System.out.println("\n============================================");
            System.out.println("Bem vindo ao sistema de cadastro de usuários");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Buscar por identificador ");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");
            int userInput = scanner.nextInt();
            MenuOptions selectOption = MenuOptions.values()[userInput - 1];
            switch (selectOption) {
                case SAVE -> {
                    try {
                        UserModel user = dao.save(requestToSave());
                        System.out.printf("Usuário salvo... %s", user);
                    } catch (ValidatorException | DateTimeParseException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case UPDATE -> {
                    try {
                        UserModel user = dao.update(requestToUpdate());
                        System.out.printf("Usuário salvo... %s", user);
                    } catch (UserNotFoundException | EmptyStorageException | ValidatorException | DateTimeParseException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case DELETE -> {
                    try {
                        dao.delete(requestId());
                        System.out.println("Usuário deletado...");
                    } catch (UserNotFoundException | EmptyStorageException e) {
                        System.err.println(e.getMessage());
                    }
                }
                case FIND_BY_ID -> {
                    try {
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.printf("Usuário com id %s", id);
                        System.out.println(user);
                    } catch (UserNotFoundException | EmptyStorageException e) {
                        System.err.println(e.getMessage());
                    }
                }

                case FIND_ALL -> {
                    List<UserModel> users = dao.findAll();
                    System.out.println("Usuários cadastrados");
                    users.forEach(System.out::println);
                }
                case EXIT -> System.exit(0);
            }
        }

    }

    private static long requestId() {
        System.out.println("informe o identificador do usuário >_: ");
        return scanner.nextLong();
    }

    private static UserModel requestToSave() throws ValidatorException {
        System.out.println("informe o nome do usuário");
        String name = scanner.next();
        System.out.println("informe o e-mail do usuário");
        String email = scanner.next();
        System.out.println("informe a data de aniversário do usuário");
        String birthdayString = scanner.next();
        LocalDate birthday = parseAndValidateBirthday(birthdayString);

        return validadeInputs(0, name, email, birthday);

    }

    private static UserModel validadeInputs(final long id, final String name,
                                              final String email, final LocalDate birthday) throws ValidatorException {
         UserModel user = new UserModel(0, name, email, birthday);
         verifyModel(user);
         return user;
    }

    private static UserModel requestToUpdate() throws ValidatorException {
        System.out.println("informe o identificador do usuário >_: ");
        long id = scanner.nextLong();
        System.out.println("informe o nome do usuário >_: ");
        String name = scanner.next();
        System.out.println("informe o e-mail do usuário >_: ");
        String email = scanner.next();
        System.out.println("informe a data de aniversário do usuário >_: ");
        String birthdayString = scanner.next();
        LocalDate birthday = parseAndValidateBirthday(birthdayString);

        return validadeInputs(id, name, email, birthday);
    }

}