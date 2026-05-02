package oi.github.llFelipeGoncalves.controller;

import oi.github.llFelipeGoncalves.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.models.MenuOptions;
import oi.github.llFelipeGoncalves.models.UserModel;
import oi.github.llFelipeGoncalves.service.UserService;
import oi.github.llFelipeGoncalves.view.ConsoleView;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class UserController {

  private final UserService userService;
  private final ConsoleView consoleView;

  public UserController(UserService userService, ConsoleView consoleView) {
    this.userService = userService;
    this.consoleView = consoleView;
  }

  public void handleMenuOption(MenuOptions option) {
    switch (option) {
      case SAVE -> handleSave();
      case UPDATE -> handleUpdate();
      case DELETE -> handleDelete();
      case FIND_BY_ID -> handleFindById();
      case FIND_ALL -> handleFindAll();
      case EXIT -> System.exit(0);
      case INVALID -> consoleView.displayError("Opção inválida. Tente novamente.");
    }
  }

  private void handleSave() {
    try {
      String name = consoleView.requestName();
      String email = consoleView.requestEmail();
      String birthdayString = consoleView.requestBirthday();
      LocalDate birthday = consoleView.parseAndValidateBirthday(birthdayString);
      UserModel user = userService.createUser(name, email, birthday);
      consoleView.displayMessage("Usuário salvo: " + user);
    } catch (ValidatorException | DateTimeParseException e) {
      consoleView.displayError(e.getMessage());
    }
  }

  private void handleUpdate() {
    try {
      long id = consoleView.requestId();
      String name = consoleView.requestName();
      String email = consoleView.requestEmail();
      String birthdayString = consoleView.requestBirthday();
      LocalDate birthday = consoleView.parseAndValidateBirthday(birthdayString);
      UserModel user = userService.updateUser(id, name, email, birthday);
      consoleView.displayMessage("Usuário atualizado: " + user);
    } catch (UserNotFoundException | ValidatorException | DateTimeParseException e) {
      consoleView.displayError(e.getMessage());
    }
  }

  private void handleDelete() {
    try {
      long id = consoleView.requestId();
      userService.deleteUser(id);
      consoleView.displayMessage("Usuário deletado.");
    } catch (UserNotFoundException e) {
      consoleView.displayError(e.getMessage());
    }
  }

  private void handleFindById() {
    try {
      long id = consoleView.requestId();
      UserModel user = userService.findUserById(id);
      consoleView.displayUser(user);
    } catch (UserNotFoundException e) {
      consoleView.displayError(e.getMessage());
    }
  }

  private void handleFindAll() {
    List<UserModel> users = userService.findAllUsers();
    consoleView.displayUsers(users);
  }
}