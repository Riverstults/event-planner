package com.example.demo.Entity;
import com.example.demo.service.EventServices;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"SpringJavaInjectionPointsAutowiringInspection", "JpaAttributeTypeInspection"})
@Entity
@Table
public class Events {
    @Id
    @SequenceGenerator(
            name="event_sequence",
            sequenceName="event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence"
    )

    private Long event_id;

    @ManyToMany
    @JoinTable(
            name="events_vendors",
            joinColumns = @JoinColumn(name="event_id"),
            inverseJoinColumns=@JoinColumn(name="ids")
    )
    private Set<Vendors> vendor =new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "events")
    private Set<Guest>guests=new HashSet<>();
    private String name;
    private String location;
    private LocalDate date;
    private String desription;
    public Events(Long ids, String name, String location, LocalDate date, String desription) {
        this.event_id = ids;
        this.name = name;
        this.location = location;
        this.date = date;
        this.desription = desription;
    }
    public Events(String name, String location, LocalDate date, String desription) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.desription = desription;
    }

    public Events() {
    }

    public Long getIds() {
        return event_id;
    }

    public void setIds(Long ids) {
        this.event_id = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public Set<Vendors> getVendors() {
        return vendor;
    }
    public Set<Guest> getGuests() {
        return guests;
    }

    public void  vendorEntry(Vendors vendors) {
        vendor.add(vendors);
    }

    @Override
    public String toString() {
        return "events{" +
                "event_id=" + event_id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", desription='" +desription + '\'' +
                '}';
    }

}
