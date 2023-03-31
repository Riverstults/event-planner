package com.example.demo.controller;


import com.example.demo.Entity.Guest;
import com.example.demo.service.GuestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="api/guest")
public class GuestController {
    private final GuestServices guestServices;
    @Autowired
    public GuestController(GuestServices guestServices) {
        this.guestServices = guestServices;
    }

    @GetMapping
    public List<Guest> hello(){
        return guestServices.getGuests();

    }
    @PostMapping
    public void registerNewWorker(@RequestBody Guest guest){

        guestServices.addGuest(guest);
    }
    @DeleteMapping(path = "{ids}")
    public void deleteEvent(@PathVariable("ids")Long ids){
        guestServices.deleteGuest(ids);
    }
    @GetMapping("/get/{id}")
    public Optional<Guest> getOneGuest(@PathVariable("id")Long id){
        return guestServices.getOneGuest(id);

    }
    @PutMapping(path ="/update/{id}" )
    public void updateGuest(
            @PathVariable("id") Long id,
            @RequestParam(required = false)String email,
            @RequestParam(required = false)String name){
        guestServices.updateGuest(id,email,name);
    }
    @PutMapping(path="/{id}/{eventsid}")
    public Guest assignguesttoevent(@PathVariable("id")Long id, @PathVariable("eventsid")Long eventsid){
        return guestServices.addguesttoevent(eventsid,id);
    }



}

