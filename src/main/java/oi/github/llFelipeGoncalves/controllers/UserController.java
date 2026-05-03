package oi.github.llFelipeGoncalves.controllers;

import oi.github.llFelipeGoncalves.models.MenuOptions;
import oi.github.llFelipeGoncalves.service.IUserService;
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
      case SAVE -> 
      case UPDATE -> 
      case DELETE -> 
      case FIND_BY_ID -> 
      case FIND_ALL -> 
      case INVALID -> 
    }
  }

  public void handleSave() {
    
  }

}
