package oi.github.llFelipeGoncalves;

import oi.github.llFelipeGoncalves.dao.UserDAO;
import oi.github.llFelipeGoncalves.models.MenuOptions;
import oi.github.llFelipeGoncalves.models.UserModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final UserDAO dao = new UserDAO();
    private static final Scanner scanner = new Scanner(System.in);

     static void main() {

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
                    UserModel user = dao.save(requestToSave());
                    System.out.printf("Usuário salvo... %s", user);
                }
                case UPDATE -> {
                    UserModel user = dao.update(requestToUpdate());
                    System.out.printf("Usuário salvo... %s", user);
                }
                case DELETE -> {
                    dao.delete(requestId());
                    System.out.println("Usuário deletado...");
                }
                case FIND_BY_ID -> {
                        var id = requestId();
                        var user = dao.findById(id);
                        System.out.printf("Usuário com id %s", id);
                        System.out.println(user);
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

    private static UserModel requestToSave() {
        System.out.println("informe o nome do usuário");
        String name = scanner.next();
        System.out.println("informe o e-mail do usuário");
        String email = scanner.next();
        System.out.println("informe a data de aniversário do usuário");
        String birthdayString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = LocalDate.parse(birthdayString, formatter);

        return new UserModel(0, name, email, birthday);

    }

    private static UserModel requestToUpdate() {
        System.out.println("informe o identificador do usuário >_: ");
        long id = scanner.nextLong();
        System.out.println("informe o nome do usuário >_: ");
        String name = scanner.next();
        System.out.println("informe o e-mail do usuário >_: ");
        String email = scanner.next();
        System.out.println("informe a data de aniversário do usuário >_: ");
        String birthdayString = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = LocalDate.parse(birthdayString, formatter);

        return new UserModel(id, name, email, birthday);

    }

}