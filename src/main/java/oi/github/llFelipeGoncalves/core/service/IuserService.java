package oi.github.llFelipeGoncalves.core.service;

import java.time.LocalDate;
import java.util.List;

import oi.github.llFelipeGoncalves.core.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.core.exceptions.ValidatorException;
import oi.github.llFelipeGoncalves.core.models.UserModel;

public interface IuserService {
  UserModel save(String name, String email, LocalDate birthday) throws ValidatorException;

  UserModel update(long id, String name, String email, LocalDate birthday) throws ValidatorException, UserNotFoundException;

  void delete(long id);

  UserModel findById(long id);

  List<UserModel> findAll();
}
