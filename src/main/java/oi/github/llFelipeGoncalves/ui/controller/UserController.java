package oi.github.llFelipeGoncalves.ui.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import oi.github.llFelipeGoncalves.core.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.core.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.core.models.MenuOptions;
import oi.github.llFelipeGoncalves.core.models.UserModel;
import oi.github.llFelipeGoncalves.core.service.IuserService;
import oi.github.llFelipeGoncalves.ui.views.ConsoleView;

public class UserController {

  private final ConsoleView consoleView;
  private final IuserService userService;

  public UserController(ConsoleView consoleView, IuserService userService) {
    this.consoleView = consoleView;
    this.userService = userService;
  }

  public void handleMenuOption(MenuOptions option) {
    switch (option) {
      case SAVE -> handleSave();
      case UPDATE -> handleUpdate();
      case DELETE -> handleDelete();
      case FIND_BY_ID -> handleFindById();
      case FIND_ALL -> handleFindAll();
      case EXIT -> System.exit(0);
      case INVALID -> consoleView.displayError("Opção inválida!");
    }
  }

  public void handleSave() {
    try { 
      String name = consoleView.requestUserName();
      String email = consoleView.requestUserEmail();
      String Stringbirthday = consoleView.requestUserBirthday();
      LocalDate birthday = LocalDate.parse(Stringbirthday);
      userService.save(name, email, birthday);
      consoleView.displayMessage("Usuário " + name + " salvo com sucesso!");
    } catch (ValidatorException | DateTimeParseException e) {
      consoleView.displayError("Erro ao salvar usuário: " + e.getMessage());
    }
  }

  public void handleUpdate() {
    try { 
      long id = consoleView.requestUserId();
      String name = consoleView.requestUserName();
      String email = consoleView.requestUserEmail();
      String Stringbirthday = consoleView.requestUserBirthday();
      LocalDate birthday = LocalDate.parse(Stringbirthday);
      userService.update(id, name, email, birthday);
      consoleView.displayMessage("Usuário " + name + " atualizado com sucesso!");
    } catch (ValidatorException | DateTimeParseException e) {
      consoleView.displayError("Erro ao atualizar usuário: " + e.getMessage());
    }
  }

  public void handleDelete() {
    try { 
      long id = consoleView.requestUserId();
      userService.delete(id);
      consoleView.displayMessage("Usuário com ID " + id + " deletado com sucesso!");
    } catch (UserNotFoundException e) {
      consoleView.displayError("Erro ao deletar usuário: " + e.getMessage());
    }
  }

  public void handleFindById() {
    try { 
      long id = consoleView.requestUserId();
      UserModel user = userService.findById(id);
      consoleView.displayUser(user);
    } catch (UserNotFoundException e) {
      consoleView.displayError("Erro ao buscar usuário: " + e.getMessage());
    }
  }
    public void handleFindAll() {  
        List<UserModel> users = userService.findAll();
        consoleView.displayUsers(users);
    }

}