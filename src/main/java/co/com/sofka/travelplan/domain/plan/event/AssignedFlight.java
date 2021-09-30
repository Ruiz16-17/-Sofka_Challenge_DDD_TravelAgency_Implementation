package co.com.sofka.travelplan.domain.plan.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.plan.value.FlightId;

public class AssignedFlight extends DomainEvent {

    private final FlightId flightId;

    public AssignedFlight(FlightId flightId) {
        super("travelplan.plan.assignedFlight");
        this.flightId = flightId;
    }

    public FlightId getFlightId() {
        return flightId;
    }
}
