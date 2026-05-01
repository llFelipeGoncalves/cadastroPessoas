package oi.github.llFelipeGoncalves.ui.views;

import oi.github.llFelipeGoncalves.core.entities.User;
import oi.github.llFelipeGoncalves.ui.MenuOptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("\n=== CADASTRO DE PESSOAS ===");
        System.out.println("1. Cadastrar pessoa");
        System.out.println("2. Listar pessoas");
        System.out.println("3. Atualizar pessoa");
        System.out.println("4. Deletar pessoa");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    public MenuOptions getMenuChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine().trim());
            return MenuOptions.fromValue(choice);
        } catch (NumberFormatException | IllegalArgumentException e) {
            return MenuOptions.INVALID;
        }
    }

    public User getUserInput() {
        System.out.print("Nome: ");
        String name = scanner.nextLine().trim();

        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        LocalDate birthday = getBirthdayInput();

        return new User(name, email, birthday);
    }

    public User getUserUpdateInput(User existingUser) {
        System.out.println("Dados atuais:");
        System.out.println("Nome: " + existingUser.getName());
        System.out.println("Email: " + existingUser.getEmail());
        System.out.println("Data de nascimento: " + existingUser.getBirthday().format(dateFormatter));

        System.out.println("\nDigite os novos dados (pressione Enter para manter o atual):");

        System.out.print("Nome [" + existingUser.getName() + "]: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) name = existingUser.getName();

        System.out.print("Email [" + existingUser.getEmail() + "]: ");
        String email = scanner.nextLine().trim();
        if (email.isEmpty()) email = existingUser.getEmail();

        System.out.print("Data de nascimento [" + existingUser.getBirthday().format(dateFormatter) + "]: ");
        String birthdayStr = scanner.nextLine().trim();
        LocalDate birthday = birthdayStr.isEmpty() ? existingUser.getBirthday() : parseDate(birthdayStr);

        return new User(existingUser.getId(), name, email, birthday);
    }

    public Long getUserIdInput() {
        System.out.print("ID da pessoa: ");
        try {
            return Long.parseLong(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public void displayUsers(List<User> users) {
        if (users.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
            return;
        }

        System.out.println("\n=== PESSOAS CADASTRADAS ===");
        for (User user : users) {
            System.out.println("ID: " + user.getId());
            System.out.println("Nome: " + user.getName());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Data de nascimento: " + user.getBirthday().format(dateFormatter));
            System.out.println("---");
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayError(String error) {
        System.err.println("Erro: " + error);
    }

    private LocalDate getBirthdayInput() {
        while (true) {
            System.out.print("Data de nascimento (dd/MM/yyyy): ");
            String input = scanner.nextLine().trim();
            LocalDate date = parseDate(input);
            if (date != null) {
                return date;
            }
            System.out.println("Data inválida. Use o formato dd/MM/yyyy.");
        }
    }

    private LocalDate parseDate(String input) {
        try {
            return LocalDate.parse(input, dateFormatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public void close() {
        scanner.close();
    }
}