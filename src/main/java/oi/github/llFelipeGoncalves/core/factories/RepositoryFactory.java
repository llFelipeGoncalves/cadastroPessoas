package oi.github.llFelipeGoncalves.core.factories;

import oi.github.llFelipeGoncalves.core.repositories.InMemoryUserRepository;
import oi.github.llFelipeGoncalves.core.repositories.UserRepository;

public class RepositoryFactory {

  public static UserRepository createUserRepository() {
    return new InMemoryUserRepository();
  }
}
