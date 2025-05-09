package com.ironhack.complex.relationships.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("CONFERENCE")
public class Conference extends Event {
    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL)
    private List<Speaker> speakers;

    public Conference(Date date, Integer duration, String location, String title, List<Guest> guests,
            List<Speaker> speakers) {
        super(date, duration, location, title, guests);
        this.speakers = speakers;
    }

    public Conference(Date date, Integer duration, String location, String title, List<Guest> guests) {
        super(date, duration, location, title, guests);
    }

    public List<Speaker> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<Speaker> speakers) {
        this.speakers = speakers;
    }

    @Override
    public String toString() {
        return "Conference [speakers=" + speakers + "]";
    }
}
