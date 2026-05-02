package oi.github.llFelipeGoncalves.core.service;

import java.util.List;

import oi.github.llFelipeGoncalves.core.models.UserModel;

public interface IuserService {
  UserModel save(UserModel user);
  UserModel update(UserModel user);
  void delete(long id);
  UserModel findById(long id);
  List<UserModel> findAll();
}
