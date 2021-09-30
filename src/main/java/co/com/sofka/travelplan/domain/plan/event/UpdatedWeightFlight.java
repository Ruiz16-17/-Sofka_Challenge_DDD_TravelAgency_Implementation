package co.com.sofka.travelplan.domain.plan.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.plan.value.FlightId;
import co.com.sofka.travelplan.domain.plan.value.Weight;

public class UpdatedWeightFlight extends DomainEvent {

    private final FlightId flightId;
    private final Weight weight;

    public UpdatedWeightFlight(FlightId flightId, Weight weight) {
        super("travelplan.plan.updatedweightflight");
        this.flightId = flightId;
        this.weight = weight;
    }
}
