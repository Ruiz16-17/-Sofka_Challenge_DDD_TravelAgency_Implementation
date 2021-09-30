package co.com.sofka.travelplan.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.hotel.value.BedroomId;
import co.com.sofka.travelplan.domain.hotel.value.NumberBedBedroom;

public class UpdatedNumberBedBedroom extends DomainEvent {

    private final BedroomId bedroomId;
    private final NumberBedBedroom numberBedBedroom;

    public UpdatedNumberBedBedroom(BedroomId bedroomId, NumberBedBedroom numberBedBedroom) {
        super("travelplan.hotel.updatednumberbedbedroom");
        this.bedroomId = bedroomId;
        this.numberBedBedroom = numberBedBedroom;
    }

    public BedroomId getBedroomId() {
        return bedroomId;
    }

    public NumberBedBedroom getNumberBedBedroom() {
        return numberBedBedroom;
    }
}
