package com.example.demo.Entity;

import jakarta.persistence.*;
@Entity
@Table
public class Guest {
    @Id
    @SequenceGenerator(
            name="guest_sequence",
            sequenceName="guest_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "guest_sequence"
    )
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="event_id",referencedColumnName = "event_id")
    private Events events;
    private String name;
    private String email;
    private String mailing;
    public Guest(Long id, String name, String email, String mailing) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mailing = mailing;
    }
    public Guest(String name, String email, String mailing) {
        this.name = name;
        this.email = email;
        this.mailing = mailing;
    }

    public Guest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMailing() {
        return mailing;
    }

    public void setMailing(String mailing) {
        this.mailing = mailing;
    }
    @Override
    public String toString() {
        return "events{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mailing=" + mailing +
                '}';
    }

    public Events getEvents() {
        return events;
    }

    public void addtoevent(Events event) {
        this.events = event;
    }
}
