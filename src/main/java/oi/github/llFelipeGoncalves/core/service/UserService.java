package oi.github.llFelipeGoncalves.core.service;

import java.time.LocalDate;
import java.util.List;

import oi.github.llFelipeGoncalves.core.dao.UserDAO;
import oi.github.llFelipeGoncalves.core.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.core.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.core.models.UserModel;
import oi.github.llFelipeGoncalves.core.validator.UserValidator;

public class UserService implements IuserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserModel save(String name, String email, LocalDate birthday) throws ValidatorException {
        UserModel user = new UserModel(0, name, email, birthday);
        UserValidator.verifyModel(user);
        return userDAO.save(user);
    }

    @Override
    public UserModel update(long id, String name, String email, LocalDate birthday) 
            throws ValidatorException, UserNotFoundException {
        UserModel user = new UserModel(id, name, email, birthday);
        UserValidator.verifyModel(user);
        return userDAO.update(user);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    public UserModel findById(long id) {
        return userDAO.findById(id);
    }

    @Override
    public List<UserModel> findAll() {
        return userDAO.findAll();
    }

}
