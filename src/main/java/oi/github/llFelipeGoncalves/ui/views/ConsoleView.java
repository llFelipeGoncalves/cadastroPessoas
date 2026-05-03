package oi.github.llFelipeGoncalves.ui.views;

import java.util.List;
import java.util.Scanner;

import oi.github.llFelipeGoncalves.core.models.MenuOptions;
import oi.github.llFelipeGoncalves.core.models.UserModel;

public class ConsoleView {

  private final Scanner scanner = new Scanner(System.in);

  public void display(){
      System.out.println("Bem-vindo ao sistema de cadastro de pessoas!");
      System.out.println("Selecione uma opção:");
      System.out.println("1 - Cadastrar");
      System.out.println("2 - Atualizar");
      System.out.println("3 - Deletar");
      System.out.println("4 - Buscar por ID");
      System.out.println("5 - Listar");
      System.out.println("6 - Sair");
  }

  public MenuOptions getMenuOption() {
      int option = Integer.parseInt(scanner.nextLine());
      return MenuOptions.fromValue(option);
  }

  public long requestUserId() {
      System.out.println("Digite o ID do usuário:");
      return scanner.nextLong();
  }

  public String requestUserName() {
      System.out.println("Digite o nome do usuário:");
      return scanner.nextLine();
  }

  public String requestUserEmail() {
      System.out.println("Digite o email do usuário:");
      return scanner.nextLine();
  }

  public String requestUserBirthday() {
      System.out.println("Digite a data de nascimento do usuário (YYYY-MM-DD):");
      return scanner.nextLine();
  }

  public void displayMessage(String message) {
      System.out.println(message);
  } 

  public void displayError(String message) {
      System.err.println(message);
  } 

  public void displayUser(UserModel user) {
      System.out.println("Usuário encontrado: " + user);
  }

  public void displayUsers(List<UserModel> users) {
      System.out.println("Usuários encontrados: ");
      users.forEach(System.out::println);
  }

}
