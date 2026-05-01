package oi.github.llFelipeGoncalves.ui.controllers;

import oi.github.llFelipeGoncalves.core.entities.User;
import oi.github.llFelipeGoncalves.core.services.UserService;
import oi.github.llFelipeGoncalves.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.ui.MenuOptions;
import oi.github.llFelipeGoncalves.ui.views.ConsoleView;

import java.util.List;

public class UserController {
    private final UserService userService;
    private final ConsoleView consoleView;

    public UserController(UserService userService, ConsoleView consoleView) {
        this.userService = userService;
        this.consoleView = consoleView;
    }

    public void run() {
        MenuOptions choice;
        do {
            consoleView.displayMenu();
            choice = consoleView.getMenuChoice();

            switch (choice) {
                case CREATE:
                    handleCreateUser();
                    break;
                case LIST:
                    handleListUsers();
                    break;
                case UPDATE:
                    handleUpdateUser();
                    break;
                case DELETE:
                    handleDeleteUser();
                    break;
                case EXIT:
                    consoleView.displayMessage("Saindo...");
                    break;
                default:
                    consoleView.displayError("Opção inválida. Tente novamente.");
            }
        } while (choice != MenuOptions.EXIT);

        consoleView.close();
    }

    private void handleCreateUser() {
        try {
            User user = consoleView.getUserInput();
            userService.createUser(user);
            consoleView.displayMessage("Pessoa cadastrada com sucesso!");
        } catch (ValidatorException e) {
            consoleView.displayError(e.getMessage());
        } catch (Exception e) {
            consoleView.displayError("Erro inesperado: " + e.getMessage());
        }
    }

    private void handleListUsers() {
        try {
            List<User> users = userService.getAllUsers();
            consoleView.displayUsers(users);
        } catch (Exception e) {
            consoleView.displayError(e.getMessage());
        }
    }

    private void handleUpdateUser() {
        try {
            Long id = consoleView.getUserIdInput();
            if (id == null) {
                consoleView.displayError("ID inválido.");
                return;
            }

            User existingUser = userService.getUserById(id);
            User updatedUser = consoleView.getUserUpdateInput(existingUser);
            userService.updateUser(updatedUser);
            consoleView.displayMessage("Pessoa atualizada com sucesso!");
        } catch (UserNotFoundException | ValidatorException e) {
            consoleView.displayError(e.getMessage());
        } catch (Exception e) {
            consoleView.displayError("Erro inesperado: " + e.getMessage());
        }
    }

    private void handleDeleteUser() {
        try {
            Long id = consoleView.getUserIdInput();
            if (id == null) {
                consoleView.displayError("ID inválido.");
                return;
            }

            userService.deleteUser(id);
            consoleView.displayMessage("Pessoa deletada com sucesso!");
        } catch (UserNotFoundException e) {
            consoleView.displayError(e.getMessage());
        } catch (Exception e) {
            consoleView.displayError("Erro inesperado: " + e.getMessage());
        }
    }
}