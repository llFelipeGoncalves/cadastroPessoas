package oi.github.llFelipeGoncalves.core.repositories;

import oi.github.llFelipeGoncalves.core.entities.User;
import oi.github.llFelipeGoncalves.exceptions.EmptyStorageException;
import oi.github.llFelipeGoncalves.exceptions.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public void save(User user) {
        user.setId(idGenerator.getAndIncrement());
        users.add(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        if (users.isEmpty()) {
            throw new EmptyStorageException("No users found in storage.");
        }
        return new ArrayList<>(users);
    }

    @Override
    public void update(User user) {
        Optional<User> existing = findById(user.getId());
        if (existing.isEmpty()) {
            throw new UserNotFoundException("User with ID " + user.getId() + " not found.");
        }
        users.remove(existing.get());
        users.add(user);
    }

    @Override
    public void delete(Long id) {
        Optional<User> user = findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User with ID " + id + " not found.");
        }
        users.remove(user.get());
    }

    @Override
    public boolean existsById(Long id) {
        return users.stream().anyMatch(user -> user.getId().equals(id));
    }
}