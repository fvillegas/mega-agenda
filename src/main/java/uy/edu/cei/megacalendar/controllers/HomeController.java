package uy.edu.cei.megacalendar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.cei.megacalendar.services.MessageService;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final MessageService messageService;

    public HomeController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String hello() {
        return messageService.generateWelcomeMessage();
    }

}
