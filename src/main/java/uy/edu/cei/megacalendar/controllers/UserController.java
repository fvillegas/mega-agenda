package uy.edu.cei.megacalendar.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.cei.megacalendar.controllers.request.UserCreateRequest;
import uy.edu.cei.megacalendar.mappers.UserMapper;
import uy.edu.cei.megacalendar.models.UserModel;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserMapper userMapper;

    @PostMapping("/user")
    public void create(@RequestBody UserCreateRequest userCreateRequest) {
        System.out.println(userCreateRequest);
    }
}
