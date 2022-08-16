package uy.edu.cei.megacalendar.controllers.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponse {
    private String username;
    private LocalDateTime createdAt;
}
