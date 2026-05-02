package oi.github.llFelipeGoncalves;

import oi.github.llFelipeGoncalves.core.repositories.InMemoryUserRepository;
import oi.github.llFelipeGoncalves.core.repositories.UserRepository;
import oi.github.llFelipeGoncalves.core.services.UserService;
import oi.github.llFelipeGoncalves.core.services.UserServiceImpl;
import oi.github.llFelipeGoncalves.core.validators.DefaultUserValidator;
import oi.github.llFelipeGoncalves.core.validators.UserValidator;
import oi.github.llFelipeGoncalves.ui.controllers.UserController;
import oi.github.llFelipeGoncalves.ui.views.ConsoleView;

/**
 * Ponto de entrada da aplicação.
 * Responsável apenas por configurar as dependências via injeção de dependência
 * e iniciar o controlador da aplicação.
 */
public class Main {
    public static void main(String[] args) {
        // Configuração das dependências (Dependency Injection)
        UserRepository userRepository = new InMemoryUserRepository();
        UserValidator userValidator = new DefaultUserValidator();
        UserService userService = new UserServiceImpl(userRepository, userValidator);
        ConsoleView consoleView = new ConsoleView();

        // Inicialização e execução da aplicação
        UserController controller = new UserController(userService, consoleView);
        controller.run();
    }
}
