package oi.github.llFelipeGoncalves.controllers;

import static oi.github.llFelipeGoncalves.validator.UserValidator.parseAndValidateBirthday;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import oi.github.llFelipeGoncalves.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.models.MenuOptions;
import oi.github.llFelipeGoncalves.models.UserModel;
import oi.github.llFelipeGoncalves.service.IUserService;
import oi.github.llFelipeGoncalves.service.UserServiceImpl;
import oi.github.llFelipeGoncalves.views.ConsoleViews;

public class UserController {

  private final IUserService userService;
  private final ConsoleViews consoleViews;

  public UserController(IUserService userService, ConsoleViews consoleViews) {
    this.userService = userService;
    this.consoleViews = consoleViews;
  }

  public void handleMenuOptions(MenuOptions option) {
    switch (option) {
      case SAVE -> handleSave();
      case UPDATE -> handleUpdate();
      case DELETE -> handleDelete();
      case FIND_BY_ID -> handleFindById();
      case FIND_ALL -> handleFindAll();
      case EXIT -> System.exit(0);
      case INVALID -> consoleViews.displayError("opcao invalida. tente novamente...");
    }
  }

  public void handleSave() {
    try {
      String name = consoleViews.requestName();
      String email = consoleViews.requestEmail();
      String birthdayString = consoleViews.requestBirthday();
      LocalDate birthday = parseAndValidateBirthday(birthdayString);
      UserModel user = userService.createUser(name, email, birthday);
      consoleViews.displayMessage("Usuario salvo" + user);
    } catch (ValidatorException | DateTimeParseException e) {
      consoleViews.displayError(e.getMessage());
    }
  }

  public void handleUpdate() {
    try {
      long id = consoleViews.requestId();
      String name = consoleViews.requestName();
      String email = consoleViews.requestEmail();
      String birthdayString = consoleViews.requestBirthday();
      LocalDate birthday = parseAndValidateBirthday(birthdayString);
      UserModel user = userService.updateUser(id, name, email, birthday);
      consoleViews.displayMessage("Usuario atualizado" + user);
    } catch (UserNotFoundException | ValidatorException | DateTimeParseException e) {
      consoleViews.displayError(e.getMessage());
    }
  }

  public void handleDelete() {
    try {
      long id = consoleViews.requestId();
      userService.deleteUser(id);
      consoleViews.displayMessage("usuario deletado");
    } catch (UserNotFoundException e) {
      consoleViews.displayError(e.getMessage());
    }
  }

  public void handleFindById() {
    try {
      long id = consoleViews.requestId();
      UserModel user = userService.findById(id);
      consoleViews.displayUser(user);
    } catch (UserNotFoundException e) {
      consoleViews.displayError(e.getMessage());
    }
  }

  public void handleFindAll() {
    List<UserModel> users = userService.findAll();
    consoleViews.displayUsers(users);
  }

}
