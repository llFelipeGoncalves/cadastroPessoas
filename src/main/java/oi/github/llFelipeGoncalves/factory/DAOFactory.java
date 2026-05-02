package oi.github.llFelipeGoncalves.factory;

import oi.github.llFelipeGoncalves.dao.UserDAO;

public class DAOFactory {

  public static UserDAO createUserDAO() {
    return new UserDAO();
  }
}