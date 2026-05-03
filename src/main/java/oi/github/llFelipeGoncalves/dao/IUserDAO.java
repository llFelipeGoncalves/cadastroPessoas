package oi.github.llFelipeGoncalves.dao;

import java.util.List;

import oi.github.llFelipeGoncalves.models.UserModel;

public interface IUserDAO {
  public UserModel save(final UserModel model);

  public UserModel update(final UserModel model);

  public void delete(long id);

  public UserModel findById(long id);

  public List<UserModel> findAll();
}
