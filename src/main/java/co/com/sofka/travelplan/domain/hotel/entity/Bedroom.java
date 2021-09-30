package co.com.sofka.travelplan.domain.hotel.entity;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.value.*;
import java.util.Objects;

public class Bedroom extends Entity<BedroomId> {

    private Name name;
    private Description description;
    private NumberBedBedroom numberBedBedroom;
    private SizeBedroom sizeBedroom;

    public Bedroom(BedroomId entityId, Name name, Description description, NumberBedBedroom numberBedBedroom, SizeBedroom sizeBedroom) {
        super(entityId);
        this.name = name;
        this.description = description;
        this.numberBedBedroom = numberBedBedroom;
        this.sizeBedroom = sizeBedroom;
    }

    public void updateName(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public void updateDescription(Description description) {
        this.description = Objects.requireNonNull(description);
    }

    public void updateNumberBedBedroom(NumberBedBedroom numberBedBedroom) {
        this.numberBedBedroom = Objects.requireNonNull(numberBedBedroom);
    }

    public void updateSizeBedroom(SizeBedroom sizeBedroom) {
        this.sizeBedroom = Objects.requireNonNull(sizeBedroom);
    }

    public Name name() {
        return name;
    }
    public Description description() {
        return description;
    }
    public NumberBedBedroom numberBedBedroom() {
        return numberBedBedroom;
    }
    public SizeBedroom sizeBedroom() {
        return sizeBedroom;
    }
}
