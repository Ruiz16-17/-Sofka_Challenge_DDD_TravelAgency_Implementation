package co.com.sofka.travelplan.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.hotel.value.LocationId;

public class AssignedLocationId extends DomainEvent {

    private final LocationId locationId;

    public AssignedLocationId(LocationId locationId) {
        super("travelplan.hotel.asignedlocationid");
        this.locationId = locationId;
    }

    public LocationId getLocationId() {
        return locationId;
    }
}
