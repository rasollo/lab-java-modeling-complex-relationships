package com.ironhack.complex.relationships.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Speaker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer presentationDuration;

    @ManyToOne
    @JoinColumn(name = "conference_id")
    private Conference conference;

    public Speaker() {
    }

    public Speaker(String name, Integer presentationDuration, Conference conference) {
        this.name = name;
        this.presentationDuration = presentationDuration;
        this.conference = conference;
    }

    @Override
    public String toString() {
        return "Speaker [id=" + id + ", name=" + name + ", presentationDuration=" + presentationDuration
                + ", conference=" + conference + "]";
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

    public Integer getPresentationDuration() {
        return presentationDuration;
    }

    public void setPresentationDuration(Integer presentationDuration) {
        this.presentationDuration = presentationDuration;
    }

    public Conference getConference() {
        return conference;
    }

    public void setConference(Conference conference) {
        this.conference = conference;
    }

}
