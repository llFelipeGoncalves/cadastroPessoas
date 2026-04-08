package oi.github.llFelipeGoncalves.dao;

import oi.github.llFelipeGoncalves.exceptions.EmptyStorageException;
import oi.github.llFelipeGoncalves.exceptions.UserNotFoundException;
import oi.github.llFelipeGoncalves.models.UserModel;

import java.util.ArrayList;
import java.util.List;


public class UserDAO {

    private long nextId = 1L;

    private final List<UserModel> models = new ArrayList<>();

    public UserModel save(final UserModel model) {
        model.setId(nextId++);
        models.add(model);
        return model;
    }

    public UserModel update(final UserModel model) {
        UserModel toUpdate = findById(model.getId());
        models.remove(toUpdate);
        models.add(model);
        return model;
    }

    public void delete(final long id) {
        UserModel toDelete = findById(id);
        models.remove(toDelete);
    }

    public UserModel findById(final long id) {
        verifyStorage();
        String message = String.format("Não existe usuário com o id:%s cadastrado", id);
        return models.stream()
                .filter(u -> u.getId()==id)
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException(message));

    }

    public List<UserModel> findAll() {
        List<UserModel> result;
        try {
            verifyStorage();
            result = models;
        } catch (EmptyStorageException e) {
            e.printStackTrace();
            result = new ArrayList<>();
        }
        return result;
    }

    public void verifyStorage() {
        if (models.isEmpty()) throw new EmptyStorageException("O armazenamento está vazio");
    }

}
