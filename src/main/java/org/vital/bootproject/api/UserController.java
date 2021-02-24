package org.vital.bootproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vital.bootproject.dao.UserRepository;
import org.vital.bootproject.model.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public List<User> getUserList() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping(path = "{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userRepository.findById(id);
    }
}
