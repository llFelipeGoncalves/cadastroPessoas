package oi.github.llFelipeGoncalves.service;

import oi.github.llFelipeGoncalves.dao.UserDAO;
import oi.github.llFelipeGoncalves.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.models.UserModel;

import java.time.LocalDate;
import java.util.List;

import static oi.github.llFelipeGoncalves.validator.UserValidator.verifyModel;

public class UserService {

  private final UserDAO userDAO;

  public UserService(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public UserModel createUser(String name, String email, LocalDate birthday) throws ValidatorException {
    UserModel user = new UserModel(0, name, email, birthday);
    verifyModel(user); // Validação aqui
    return userDAO.save(user);
  }

  public UserModel updateUser(long id, String name, String email, LocalDate birthday)
      throws UserNotFoundException, ValidatorException {
    UserModel user = new UserModel(id, name, email, birthday);
    verifyModel(user); // Validação aqui
    return userDAO.update(user);
  }

  public void deleteUser(long id) throws UserNotFoundException {
    userDAO.delete(id);
  }

  public UserModel findUserById(long id) throws UserNotFoundException {
    return userDAO.findById(id);
  }

  public List<UserModel> findAllUsers() {
    return userDAO.findAll();
  }
}