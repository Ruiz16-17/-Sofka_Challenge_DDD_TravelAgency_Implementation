package co.com.sofka.travelplan.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.value.BedroomId;
import co.com.sofka.travelplan.domain.hotel.value.NumberBedBedroom;
import co.com.sofka.travelplan.domain.hotel.value.SizeBedroom;

public class AddedBedroom extends DomainEvent {

    private final BedroomId bedroomId;
    private final Name name;
    private final Description description;
    private final NumberBedBedroom numberBedBedroom;
    private final SizeBedroom sizeBedroom;

    public AddedBedroom(BedroomId bedroomId, Name name, Description description, NumberBedBedroom numberBedBedroom, SizeBedroom sizeBedroom) {
        super("travelplan.hotel.addedbedroom");
        this.bedroomId = bedroomId;
        this.name = name;
        this.description = description;
        this.numberBedBedroom = numberBedBedroom;
        this.sizeBedroom = sizeBedroom;
    }

    public BedroomId getBedroomId() {
        return bedroomId;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }

    public NumberBedBedroom getNumberBedBedroom() {
        return numberBedBedroom;
    }

    public SizeBedroom getSizeBedroom() {
        return sizeBedroom;
    }
}
