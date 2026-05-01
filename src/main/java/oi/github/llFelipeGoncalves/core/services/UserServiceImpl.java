package oi.github.llFelipeGoncalves.core.services;

import oi.github.llFelipeGoncalves.core.entities.User;
import oi.github.llFelipeGoncalves.core.repositories.UserRepository;
import oi.github.llFelipeGoncalves.core.validators.UserValidator;
import oi.github.llFelipeGoncalves.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserValidator userValidator;

    public UserServiceImpl(UserRepository userRepository, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    @Override
    public void createUser(User user) throws ValidatorException {
        userValidator.validate(user);
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with ID " + id + " not found."));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void updateUser(User user) throws ValidatorException, UserNotFoundException {
        userValidator.validate(user);
        userRepository.update(user);
    }

    @Override
    public void deleteUser(Long id) throws UserNotFoundException {
        userRepository.delete(id);
    }
}