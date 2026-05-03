package oi.github.llFelipeGoncalves.service;

import java.time.LocalDate;
import java.util.List;

import oi.github.llFelipeGoncalves.exceptions.EmptyStorageException;
import oi.github.llFelipeGoncalves.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.models.UserModel;

public interface IUserService {
    public UserModel createUser(String name, String email, LocalDate birthday) throws ValidatorException;

    public UserModel updateUser(long id, String name, String email, LocalDate birthday) throws ValidatorException, UserNotFoundException;

    public void deleteUser(long id) throws UserNotFoundException;

    public UserModel findById(long id) throws UserNotFoundException;

    public List<UserModel> findAll() throws EmptyStorageException;
}
