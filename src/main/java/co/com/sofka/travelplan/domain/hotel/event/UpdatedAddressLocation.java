package co.com.sofka.travelplan.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.generic.value.Address;
import co.com.sofka.travelplan.domain.hotel.value.LocationId;

public class UpdatedAddressLocation extends DomainEvent {

    private final LocationId locationId;
    private final Address address;

    public UpdatedAddressLocation(LocationId locationId, Address address) {
        super("travelplan.hotel.updatedaddreslocation");
        this.locationId = locationId;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public LocationId getLocationId() {
        return locationId;
    }
}
