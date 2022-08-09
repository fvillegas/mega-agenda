package uy.edu.cei.megacalendar.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserModel {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;

    public static UserModel createBasicUser() {
        return UserModel.builder().username("pepe").build();
    }
}
