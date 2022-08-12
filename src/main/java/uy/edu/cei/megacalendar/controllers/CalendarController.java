package uy.edu.cei.megacalendar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uy.edu.cei.megacalendar.models.EventModel;

import java.util.List;

public class CalendarController {

    @GetMapping("/calendar/{user_id}/today")
    public List<EventModel> fetchEventsForToday(@PathVariable("user_id") final Long user_id) {
        return null;
    }

    @GetMapping("/calendar/{user_id}")
    public List<EventModel> fetchEvents(@PathVariable("user_id") final Long user_id) {
        return null;
    }
}
