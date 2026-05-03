package oi.github.llFelipeGoncalves.views;

import java.util.List;
import java.util.Scanner;

import oi.github.llFelipeGoncalves.models.MenuOptions;
import oi.github.llFelipeGoncalves.models.UserModel;

public class ConsoleViews {
  
  private final Scanner scanner = new Scanner(System.in);

  public void display() {
    System.out.println("Bem vindo ao sistema de cadastro de usuários");
    System.out.println("1 - Cadastro");
    System.out.println("2 - Atualizar");
    System.out.println("3 - Excluir");
    System.out.println("4 - Buscar por identificador ");
    System.out.println("5 - Listar");
    System.out.println("6 - Sair");
  }
  
  public MenuOptions getMenuOptions() {
    int userInput = Integer.parseInt(scanner.nextLine());
    return MenuOptions.fromValue(userInput);
  }

  public long requestId(){
    System.out.println("informe o id do usuario >_: ");
    return scanner.nextLong();
  }
  
  public String requestName() {
    System.out.println("informe o nome do usuario >_: ");
    return scanner.nextLine();
  }

  public String requestEmail() {
    System.out.println("informe o email do usuario >_: ");
    return scanner.nextLine();
  }

  public String requestBirthday() {
    System.out.println("informe o nome do usuario >_: ");
    return scanner.nextLine();
  }     

  public void displayMessage(String message) {
    System.out.println(message);
  }

  public void displayError(String error) {
    System.err.println(error);
  }

  public void displayUser(UserModel user) {
    System.out.println("Usuario encontrado" + user);
  }

  public void displayUsers(List<UserModel> users) {
    System.out.println("Usuarios cadastrados");
    users.forEach(System.out::println);
  }

}
