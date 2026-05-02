package oi.github.llFelipeGoncalves;

import oi.github.llFelipeGoncalves.controller.UserController;
import oi.github.llFelipeGoncalves.factory.DAOFactory;
import oi.github.llFelipeGoncalves.models.MenuOptions;
import oi.github.llFelipeGoncalves.service.UserService;
import oi.github.llFelipeGoncalves.view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        // Usando Factory para criar DAO
        var userDAO = DAOFactory.createUserDAO();
        var userService = new UserService(userDAO);
        var consoleView = new ConsoleView();
        var userController = new UserController(userService, consoleView);

        while (true) {
            consoleView.displayMenu();
            MenuOptions option = consoleView.getMenuOption();
            userController.handleMenuOption(option);
        }
    }
}