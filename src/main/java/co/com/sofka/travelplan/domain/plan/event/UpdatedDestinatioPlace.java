package co.com.sofka.travelplan.domain.plan.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.plan.value.DestinationPlace;

public class UpdatedDestinatioPlace extends DomainEvent {

    private final DestinationPlace destinationPlace;

    public UpdatedDestinatioPlace(DestinationPlace destinationPlace) {
        super("travelplan.plan.updateddestinationplace");
        this.destinationPlace = destinationPlace;
    }

    public DestinationPlace getDestinationPlace() {
        return destinationPlace;
    }
}
