package co.com.sofka.travelplan.domain.hotel.event;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.travelplan.domain.hotel.value.CityLocation;
import co.com.sofka.travelplan.domain.hotel.value.LocationId;

public class UpdatedCityLocation extends DomainEvent {

    private final LocationId locationId;
    private final CityLocation cityLocation;

    public UpdatedCityLocation(LocationId locationId, CityLocation cityLocation) {
        super("travelplan.hotel.updatedcitylocation");
        this.locationId = locationId;
        this.cityLocation = cityLocation;
    }

    public LocationId getLocationId() {
        return locationId;
    }

    public CityLocation getCityLocation() {
        return cityLocation;
    }
}
