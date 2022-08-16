package uy.edu.cei.megacalendar.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserModel {
    @JsonIgnore
    private Long id;
    private UUID uuid;
    private String username;
    @JsonIgnore
    private String password;
    private String userTimezone = "America/Montevideo";
    private LocalDateTime createdAt;

    public static UserModel createBasicUser() {
        return UserModel.builder().username("pepe").build();
    }
}
