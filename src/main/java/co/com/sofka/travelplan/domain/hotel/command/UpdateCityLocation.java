package co.com.sofka.travelplan.domain.hotel.command;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.travelplan.domain.hotel.value.CityLocation;
import co.com.sofka.travelplan.domain.hotel.value.HotelId;
import co.com.sofka.travelplan.domain.hotel.value.LocationId;

public class UpdateCityLocation extends Command {

    private final HotelId hotelId;
    private final LocationId locationId;
    private final CityLocation cityLocation;

    public UpdateCityLocation(HotelId hotelId, LocationId locationId, CityLocation cityLocation) {
        this.hotelId = hotelId;
        this.locationId = locationId;
        this.cityLocation = cityLocation;
    }

    public HotelId getHotelId() {
        return hotelId;
    }

    public LocationId getLocationId() {
        return locationId;
    }

    public CityLocation getCityLocation() {
        return cityLocation;
    }
}
