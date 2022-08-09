package uy.edu.cei.megacalendar.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uy.edu.cei.megacalendar.mappers.UserMapper;
import uy.edu.cei.megacalendar.models.UserModel;

import java.util.List;

@AllArgsConstructor
@Service
public class MessageService {

    private UserMapper userMapper;

    public String generateWelcomeMessage() {

        List<UserModel> userModels = userMapper.fetchAll();

        return "Hello from spring!!!";
    }

}
