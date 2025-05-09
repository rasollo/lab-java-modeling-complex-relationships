package com.ironhack.complex.relationships.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EXPOSITION")
public class Exposition extends Event {

}
