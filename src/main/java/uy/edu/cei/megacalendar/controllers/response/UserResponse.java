package uy.edu.cei.megacalendar.controllers.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String username;
}
