package org.vital.bootproject.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.vital.bootproject.dao.UserRepository;
import org.vital.bootproject.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(@Qualifier("users_db") UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAllUser() {

        List<User> list = (List<User>) repository.findAll();
        for(User user : list) {
            System.out.println(user);
        }

        return list;
    }

    public Optional<User> findUserById(int id) {
        return repository.findById(id);
    }


}
