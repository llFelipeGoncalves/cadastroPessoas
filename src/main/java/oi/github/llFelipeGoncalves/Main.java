package oi.github.llFelipeGoncalves;

import oi.github.llFelipeGoncalves.controllers.UserController;
import oi.github.llFelipeGoncalves.dao.UserDAO;
import oi.github.llFelipeGoncalves.service.UserServiceImpl;
import oi.github.llFelipeGoncalves.views.ConsoleViews;

public class Main {
     public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        ConsoleViews consoleViews = new ConsoleViews();
        UserServiceImpl uServiceImpl = new UserServiceImpl(userDAO);
        UserController userController = new UserController(uServiceImpl, consoleViews);

        while (true) {
            consoleViews.display();
            userController.handleMenuOptions(consoleViews.getMenuOptions());
        }
     }
}