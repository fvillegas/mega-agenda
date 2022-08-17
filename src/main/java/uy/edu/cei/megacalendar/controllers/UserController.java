package uy.edu.cei.megacalendar.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uy.edu.cei.megacalendar.controllers.request.UserCreateRequest;
import uy.edu.cei.megacalendar.controllers.response.UserResponse;
import uy.edu.cei.megacalendar.exceptions.InvalidPasswordFormatException;
import uy.edu.cei.megacalendar.models.NoUserModel;
import uy.edu.cei.megacalendar.models.UserModel;
import uy.edu.cei.megacalendar.services.UserService;
import uy.edu.cei.megacalendar.utils.UserTimezoneTransformerUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;

    @GetMapping("/user/{id}")
    public UserResponse index(@PathVariable("id") final Long id) {
        UserModel userModel = userService.fetchUserById(id);
        return UserResponse.builder()
                .username(userModel.getUsername())
                .build();
    }

    @GetMapping("/user/all")
    public List<UserResponse> list(@RequestParam(value = "limit", required = false) final Integer limit) {
        List<UserModel> userModelList = userService.fetchAll(limit);
        return userModelList.stream()
                .map(u -> UserResponse.builder()
                        .username(u.getUsername())
                        .uuid(u.getUuid())
                        .createdAt(
                                UserTimezoneTransformerUtil
                                        .fromEventTimezoneToUserTimezone(
                                                u.getUserTimezone(),
                                                u.getCreatedAt()
                                        )
                        )
                        .build()
                )
                .collect(Collectors.toList());
    }

    @GetMapping("/no-user/{id}")
    public NoUserModel showNoUserModel(@PathVariable("id") final Long id) {
        return this.userService.fetchNoUser(id);
    }

    @PostMapping("/user")
    public HttpEntity<?> create(@RequestBody UserCreateRequest userCreateRequest) throws InvalidPasswordFormatException {
        boolean success = userService.createUser(userCreateRequest);
        return HttpEntity.EMPTY;
    }

}
