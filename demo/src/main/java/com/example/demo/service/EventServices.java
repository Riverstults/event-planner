package com.example.demo.service;

import com.example.demo.Entity.Events;
import com.example.demo.Entity.Vendors;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class EventServices {

    private final EventRepository eventRepository;
    private final VendorRepository vendorRepository;
    @Autowired
    public EventServices(EventRepository eventRepository, VendorRepository vendorRepository) {
        this.eventRepository = eventRepository;
        this.vendorRepository = vendorRepository;
    }



    @Transactional
    public void updateEvent(Long ids,
                             String location,
                             String desription) {
        Events work=eventRepository.findById(ids)
                .orElseThrow(()->new IllegalStateException(
                        "event with id "+ ids +" does not exist in database"));
        if (location!=null && location.length() >0 && !Objects.equals(work.getLocation(),location)) {
            work.setLocation(location);
        }
        if(desription!=null&&desription.length()>0 && !Objects.equals(work.getDesription(),desription)){
            work.setDesription(desription);
        }
    }

    public  void deleteEvents(Long ids) {
        eventRepository.findById(ids);
        boolean exists = eventRepository.existsById(ids);
        if (!exists){
            throw new IllegalStateException(
                    "event with id "+ ids +" does not exist in database"
            );}
        eventRepository.deleteById(ids);

    }

    public void addEvent(Events events) {
        Optional<Events> eventoptional= eventRepository.findEventsByName(events.getName());
        if(eventoptional.isPresent()){
            throw new IllegalStateException("name taken");
        }
        eventRepository.save(events);
    }

    public List<Events> getEvents() {
        return eventRepository.findAll();
    }

    public Optional<Events> getOneEvent(Long eventId) {
        return eventRepository.findById(eventId);
    }

    public Events eventstovendor(Long eventId, Long ids) {
        Events event = eventRepository.findById(eventId).get();
        Vendors vendor = vendorRepository.findById(ids).get();
        event.vendorEntry(vendor);
        return eventRepository.save(event);
    }
}

