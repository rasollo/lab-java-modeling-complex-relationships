package com.ironhack.complex.relationships.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private GuestStatus status;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Guest() {
    }

    public Guest(String name, GuestStatus status, Event event) {
        this.name = name;
        this.status = status;
        this.event = event;
    }

    @Override
    public String toString() {
        return "Guest [id=" + id + ", name=" + name + ", status=" + status + ", event=" + event + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GuestStatus getStatus() {
        return status;
    }

    public void setStatus(GuestStatus status) {
        this.status = status;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public enum GuestStatus {
        ATTENDING, NOT_ATTENDING, NO_RESPONSE
    }

}
