package uy.edu.cei.megacalendar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uy.edu.cei.megacalendar.controllers.response.EventResponse;
import uy.edu.cei.megacalendar.models.EventModel;
import uy.edu.cei.megacalendar.services.EventService;

import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    /**
     * Este constructor equivale a @AllArgsArguments de lombok
     * @param eventService
     */
    public EventController(final EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/{id}")
    public EventResponse index(@PathVariable("id") final Long id) {
        Optional<EventModel> eventModel = this.eventService.fetchEventById(id);
        EventModel ev = eventModel.orElseThrow();
        EventResponse eventResponse = EventResponse.builder()
                .name(ev.getName())
                .build();
        return eventResponse;
    }

}
