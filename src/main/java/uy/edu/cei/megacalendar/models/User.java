package uy.edu.cei.megacalendar.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {
    private String username;

    public static User createBasicUser() {
        return User.builder().username("pepe").build();
    }
}
