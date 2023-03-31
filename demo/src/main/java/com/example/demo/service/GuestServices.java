package com.example.demo.service;

import com.example.demo.Entity.Events;
import com.example.demo.Entity.Guest;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class GuestServices {
    @Autowired
    public GuestServices(GuestRepository guestRepository, EventRepository eventRepository) {
        this.guestRepository = guestRepository;
        this.eventRepository = eventRepository;
    }
    private final GuestRepository guestRepository;
    private final EventRepository eventRepository;

    public Guest addguesttoevent(Long eventsid, Long id) {
        Guest guest=guestRepository.findById(id).get();
        Events event=eventRepository.findById(eventsid).get();
        guest.addtoevent(event);
        return guestRepository.save(guest);
    }

    @Transactional
    public void updateGuest(Long id,
                            String email,
                            String name) {
        Guest works=guestRepository.findById(id)
                .orElseThrow(()->new IllegalStateException(
                        "guest with id "+ id +" does not exist in database"));
        if (email!=null && email.length() >0 && !Objects.equals(works.getEmail(),email)) {
            works.setEmail(email);
        }
        if(name!=null&&name.length()>0 && !Objects.equals(works.getName(),name)){
            works.setName(name);
        }
    }

    public  void deleteGuest(Long id) {
        guestRepository.findById(id);
        boolean exists = guestRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException(
                    "guest with id "+ id +" does not exist in database"
            );}
        guestRepository.deleteById(id);

    }

    public void addGuest(Guest guest) {
        Optional<Guest> workeroptional= guestRepository.findGuestByEmail(guest.getEmail());
        if(workeroptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        guestRepository.save(guest);
    }

    public List<Guest> getGuests() {
        return guestRepository.findAll();
    }

    public Optional<Guest>  getOneGuest(Long workerID) {
        return guestRepository.findById(workerID);
    }

}

