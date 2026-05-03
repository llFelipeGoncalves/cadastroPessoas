package oi.github.llFelipeGoncalves;

import oi.github.llFelipeGoncalves.core.dao.UserDAO;
import oi.github.llFelipeGoncalves.core.service.UserService;
import oi.github.llFelipeGoncalves.ui.controller.UserController;
import oi.github.llFelipeGoncalves.ui.views.ConsoleView;

public class Main {
     public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        UserDAO userDAO = new UserDAO();
        UserService userService = new UserService(userDAO);
        UserController userController = new UserController(consoleView, userService);

        while(true) {
            consoleView.display();
            userController.handleMenuOption(consoleView.getMenuOption());
        }
    }
}

    