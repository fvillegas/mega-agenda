package uy.edu.cei.megacalendar.controllers.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class UserResponse {
    private String username;
    private UUID uuid;
    private LocalDateTime createdAt;
}
