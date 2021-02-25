package org.vital.bootproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vital.bootproject.model.User;
import org.vital.bootproject.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUserList() {
        return userService.findAllUser();
    }

    @GetMapping(path = "{id}")
    public Optional<User> getUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }
}
