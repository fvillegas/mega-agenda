package uy.edu.cei.megacalendar.services;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String generateWelcomeMessage() {
        return "Hello from spring!!!";
    }

}
