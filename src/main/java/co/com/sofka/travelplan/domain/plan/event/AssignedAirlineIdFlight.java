package co.com.sofka.travelplan.domain.plan.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.plan.value.AirlineId;
import co.com.sofka.travelplan.domain.plan.value.FlightId;

public class AssignedAirlineIdFlight extends DomainEvent {

    private final FlightId flightId;
    private final AirlineId airlineId;

    public AssignedAirlineIdFlight(FlightId flightId, AirlineId airlineId) {
        super("travelplan.plan.assignedairlineidflight");
        this.flightId = flightId;
        this.airlineId = airlineId;
    }

    public FlightId getFlightId() {
        return flightId;
    }

    public AirlineId getAirlineId() {
        return airlineId;
    }
}
