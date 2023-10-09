package com.andygomez.ShopAll.service.impl;

import com.andygomez.ShopAll.model.User;
import com.andygomez.ShopAll.repository.UserRepository;
import com.andygomez.ShopAll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAllUser() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public User updateUser(Integer id, User user) {
        Optional<User> userExist = repository.findById(id);

        if (userExist.isPresent()) {
            User userActual = userExist.get();

            // Actualiza los campos del usuario con los valores proporcionados
            userActual.setName(user.getName());
            userActual.setEmail(user.getEmail());
            // Agrega más actualizaciones de campos según tus necesidades

            return repository.save(userActual);
        } else {
            return null; // El usuario no existe, se podría lanzar una excepción personalizada en lugar de retornar null
        }
    }

    @Override
    public boolean deleteUser(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
