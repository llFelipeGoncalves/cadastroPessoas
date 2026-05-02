package oi.github.llFelipeGoncalves.core.services;

import oi.github.llFelipeGoncalves.core.entities.User;
import oi.github.llFelipeGoncalves.core.repositories.UserRepository;
import oi.github.llFelipeGoncalves.core.validators.UserValidator;
import oi.github.llFelipeGoncalves.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
public interface UserService {
    void createUser(User user) throws ValidatorException;
    User getUserById(Long id) throws UserNotFoundException;
    List<User> getAllUsers();
    void updateUser(User user) throws ValidatorException, UserNotFoundException;
    void deleteUser(Long id) throws UserNotFoundException;
}