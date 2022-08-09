package uy.edu.cei.megacalendar.controllers.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class UserCreateRequest {
    private final String username;
    private final String password;
}
