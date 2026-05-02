package oi.github.llFelipeGoncalves.core.service;

import java.util.List;

import oi.github.llFelipeGoncalves.core.dao.UserDAO;
import oi.github.llFelipeGoncalves.core.models.UserModel;
import oi.github.llFelipeGoncalves.core.validator.UserValidator;

public class UserService implements IuserService {

  private final UserDAO user;
  private final UserValidator validator;

  public UserService(UserDAO user, UserValidator validator) {
      this.user = user;
      this.validator = validator;
  }

    @Override
    public UserModel save(UserModel user) {
        
        return null;
    }

    @Override
    public UserModel update(UserModel user) {
        // Implementation for updating user
        return null;
    }

    @Override
    public void delete(long id) {
        // Implementation for deleting user
    }

    @Override
    public UserModel findById(long id) {
        // Implementation for finding user by ID
        return null;
    }

    @Override
    public List<UserModel> findAll() {
        // Implementation for finding all users
        return null;
    }

}
