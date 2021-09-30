package co.com.sofka.travelplan.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Description;
import co.com.sofka.travelplan.domain.hotel.value.OfferingId;

public class UpdatedDescriptionOffering extends DomainEvent {

    private final OfferingId offeringId;
    private final Description description;

    public UpdatedDescriptionOffering(OfferingId offeringId, Description description) {
        super("travelplan.hotel.updateddescriptionoffering");
        this.offeringId = offeringId;
        this.description = description;
    }

    public OfferingId getOfferingId() {
        return offeringId;
    }

    public Description getDescription() {
        return description;
    }
}
