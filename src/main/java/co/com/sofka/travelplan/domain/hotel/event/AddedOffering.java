package co.com.sofka.travelplan.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.generic.value.Name;
import co.com.sofka.travelplan.domain.hotel.value.OfferingId;

public class AddedOffering extends DomainEvent {

    private final OfferingId offeringId;
    private final Name name;
    private final Description description;

    public AddedOffering(OfferingId offeringId, Name name, Description description) {
        super("travelplan.hotel.addedoffering");
        this.offeringId = offeringId;
        this.name = name;
        this.description = description;
    }

    public OfferingId getOfferingId() {
        return offeringId;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }
}
