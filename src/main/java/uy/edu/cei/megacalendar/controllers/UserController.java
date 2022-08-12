package uy.edu.cei.megacalendar.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uy.edu.cei.megacalendar.controllers.request.UserCreateRequest;
import uy.edu.cei.megacalendar.models.UserModel;
import uy.edu.cei.megacalendar.services.UserService;

@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;

    @GetMapping("/user/{id}")
    public UserModel index(@PathVariable("id") final Long id) {
        return userService.fetchUserById(id);
    }

    @PostMapping("/user")
    public HttpEntity<?> create(@RequestBody UserCreateRequest userCreateRequest) {
        boolean success = userService.createUser(userCreateRequest);
        return HttpEntity.EMPTY;
    }

}
