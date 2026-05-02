package oi.github.llFelipeGoncalves.view;

import oi.github.llFelipeGoncalves.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.models.MenuOptions;
import oi.github.llFelipeGoncalves.models.UserModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {

  private final Scanner scanner = new Scanner(System.in);

  public void displayMenu() {
    System.out.println("\n============================================");
    System.out.println("Bem vindo ao sistema de cadastro de usuários");
    System.out.println("1 - Cadastro");
    System.out.println("2 - Atualizar");
    System.out.println("3 - Excluir");
    System.out.println("4 - Buscar por identificador ");
    System.out.println("5 - Listar");
    System.out.println("6 - Sair");
  }

  public MenuOptions getMenuOption() {
    int userInput = Interger.parseInt(scanner.nextInt());
    return MenuOptions.fromValue(userInput);
  }

  public long requestId() {
    System.out.println("informe o identificador do usuário >_: ");
    return scanner.nextLong();
  }

  public String requestName() {
    System.out.println("informe o nome do usuário");
    return scanner.next();
  }

  public String requestEmail() {
    System.out.println("informe o e-mail do usuário");
    return scanner.next();
  }

  public String requestBirthday() {
    System.out.println("informe a data de aniversário do usuário");
    return scanner.next();
  }

  public LocalDate parseAndValidateBirthday(String birthdayString) throws ValidatorException {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    try {
      return LocalDate.parse(birthdayString, formatter);
    } catch (DateTimeParseException e) {
      throw new ValidatorException("Erro: O formato da data está incorreto. Use dd/MM/yyyy");
    }
  }

  public void displayMessage(String message) {
    System.out.println(message);
  }

  public void displayError(String error) {
    System.err.println(error);
  }

  public void displayUser(UserModel user) {
    System.out.println("Usuário encontrado: " + user);
  }

  public void displayUsers(List<UserModel> users) {
    System.out.println("Usuários cadastrados:");
    users.forEach(System.out::println);
  }
}