package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Vendors {

    @Id
    @SequenceGenerator(
            name="vendor_sequence",
            sequenceName="vendor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "vendor_sequence"

    )


    private Long ids;
    @JsonIgnore
    @ManyToMany(mappedBy = "vendor")
    private Set<Events>events=new HashSet<>();
    private String name;
    private String email;
    private Integer phone ;
    private String services;

    public Vendors(Long ids, String name, String email, Integer phone, String services) {
        this.ids = ids;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.services = services;
    }
    public Vendors(String name, String email, Integer phone, String services) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.services = services;
    }

    public Vendors() {
    }

    public Long getIds() {
        return ids;
    }

    public void setIds(Long ids) {
        this.ids = ids;
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }
    public Set<Events> getEvents() {
        return events;
    }
    @Override
    public String toString() {
        return "events{" +
                "ids=" + ids +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone + '\'' +
                ", services" + services +
                '}';
    }
}
