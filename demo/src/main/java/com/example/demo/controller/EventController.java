package com.example.demo.controller;

import com.example.demo.Entity.Events;
import com.example.demo.Entity.Vendors;
import com.example.demo.service.EventServices;
import com.example.demo.service.VendorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="api/events")
public class EventController {
    private final EventServices eventServices;
    private final VendorServices vendorServices;

    @Autowired
    public EventController(EventServices eventServices, VendorServices vendorServices) {
        this.eventServices = eventServices;
        this.vendorServices = vendorServices;
    }

    @GetMapping
    public List<Events> hello(){
        return eventServices.getEvents();

    }
    @PostMapping
    public void registerNewWorker(@RequestBody Events events){

        eventServices.addEvent(events);
    }
    @DeleteMapping(path = "{ids}")
    public void deleteEvent(@PathVariable("ids")Long ids){
        eventServices.deleteEvents(ids);
    }
    @PutMapping(path ="/update/{ids}" )
    public void updateEvent(
            @PathVariable("ids") Long ids,
            @RequestParam(required = false)String location,
            @RequestParam(required = false)String desription){
        eventServices.updateEvent(ids,location,desription);
    }
@PutMapping(path= "/{event_id}/event/{ids}")
    Events connectEventstoVendors(
           @PathVariable Long event_id,
           @PathVariable Long ids
) {
return eventServices.eventstovendor(event_id,ids);

}
}

