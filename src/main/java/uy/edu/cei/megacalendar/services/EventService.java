package uy.edu.cei.megacalendar.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uy.edu.cei.megacalendar.mappers.EventMapper;
import uy.edu.cei.megacalendar.models.EventModel;

import java.util.Optional;

@AllArgsConstructor
@Service
public class EventService {

    private final EventMapper eventMapper;

    public Optional<EventModel> fetchEventById(final Long id) {
        return this.eventMapper.fetchById(id);
    }

}
