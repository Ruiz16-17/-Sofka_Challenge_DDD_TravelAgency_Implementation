package co.com.sofka.travelplan.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.value.BedroomId;

public class UpdatedNameBedroom extends DomainEvent {

    private final BedroomId bedroomId;
    private final Name name;

    public UpdatedNameBedroom(BedroomId bedroomId, Name name) {
        super("travelplan.hotel.updatedname");
        this.bedroomId = bedroomId;
        this.name = name;
    }

    public BedroomId getBedroomId() {
        return bedroomId;
    }

    public Name getName() {
        return name;
    }
}
