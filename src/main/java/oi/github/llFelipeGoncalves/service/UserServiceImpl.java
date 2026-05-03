package oi.github.llFelipeGoncalves.service;

import java.time.LocalDate;
import java.util.List;

import oi.github.llFelipeGoncalves.dao.UserDAO;
import oi.github.llFelipeGoncalves.exceptions.EmptyStorageException;
import oi.github.llFelipeGoncalves.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.models.UserModel;
import oi.github.llFelipeGoncalves.validator.UserValidator;

public class UserServiceImpl implements IUserService{

  private UserDAO userDAO; 

  public UserServiceImpl(UserDAO userDAO){
    this.userDAO = userDAO;
  }

  @Override
  public UserModel createUser(String name, String email, LocalDate birthday) throws ValidatorException {
    UserModel user = new UserModel(0, name, email, birthday);
    UserValidator.verifyModel(user);
    return userDAO.save(user);
  }

  @Override
  public UserModel updateUser(long id, String name, String email, LocalDate birthday)
      throws ValidatorException, UserNotFoundException {
        UserModel user = new UserModel(id, name, email, birthday);
        UserValidator.verifyModel(user);
        return userDAO.update(user);
      }

  @Override
  public void deleteUser(long id) throws UserNotFoundException {
    userDAO.delete(id);
  }

  @Override
  public UserModel findById(long id) throws UserNotFoundException {
    return userDAO.findById(id);
  }

  @Override
  public List<UserModel> findAll() throws EmptyStorageException {
    return userDAO.findAll();
  }

}
